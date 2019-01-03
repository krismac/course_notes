## Modeling a one to many relationship

Let's create a table to store the articles of our writers.

articles will have

* id
* title
* body

We will worry about the writer later

> Ask the students to determine what type these columns will be.

Let's add a new table at the top of our file and comment out the queries we wrote earlier.

```sql
-- codeclan_times.sql
DROP TABLE articles; -- Above DROP TABLE writers
-- Just below CREATE TABLE writers
CREATE TABLE articles (
  id SERIAL8,
  title VARCHAR(255),
  body TEXT,
  published_date DATE
);
```

```zsh
# terminal
psql -d codeclan_times -f codeclan_times.sql;
```

Aside: You will often see 255 used because it's the largest number of characters that can be counted with an 8-bit number. It maximizes the use of the 8-bit count, without frivolously requiring another whole byte to count the characters above 255. We'll come back to binary another time.

```sql
-- codeclan_times.sql
INSERT INTO articles (title, body, published_date) VALUES ('The Future is Robots', 'ultrices sagittis.', '2018-09-14');
INSERT INTO articles (title, body, published_date) VALUES ('CodeClan Wins Yet Another Award', 'Lorem ipsum dolor', '2019-09-10');

SELECT * FROM articles;
```

```zsh
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

```sql
# psql terminal
SELECT * FROM articles;
```

[Task:] Add an article

# Constraints

We can add "constraints" to our table definition, which will validate the data we try to enter against some basic rules.

* A article must have a title and a published_date

```sql
-- codeclan_times.sql
CREATE TABLE articles (
  id SERIAL8,
  title VARCHAR(255) NOT NULL,
  body TEXT,
  published_date DATE NOT NULL
);
```

```zsh
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

Let's try to insert some invalid data.

```sql
# codeclan_times.sql
INSERT INTO articles (title) VALUES ('My Article Title');
```

```zsh
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

## Primary Keys

We already discussed associating articles and writers by adding the owner's name to the article table. We came to the conclusion that using the owner's ID is the better solution.

If we want to use an ID, it's important that we make sure that every row has an ID. Currently, we could set the ID field of our articles to be null or a duplicate value.

```sql
-- codeclan_times.sql
UPDATE articles SET ID = 1;
```

> Ask if anybody can remember what we mentioned earlier that can solve this

The way we can make sure that his will never happen is to ask SQL to set our ID column to be the table's PRIMARY KEY.

A primary key is a column that uniquely defines a record. A primary key column cannot contain a NULL value. A table can have only one primary key. So we are explicitly saying that we want our ID field to be our main identifier for the rows in the table.

```sql
-- codeclan_times.sql
CREATE TABLE articles (
  id SERIAL8 PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  body TEXT,
  published_date DATE NOT NULL
);

CREATE TABLE writers (
  id SERIAL8 PRIMARY KEY, -- UPDATED
  f_name VARCHAR(255),
  l_name VARCHAR(255),
  staff BOOLEAN,
  dob DATE
);
```

```zsh
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

Now we can't alter it like we just did.

```sql
UPDATE articles SET ID = 1;
```

## Foreign Keys

The last thing we want to do is to reflect the relationship between our writers and our article!

We can now use this primary key as an identifier in another table. When we do this we refer to it as a 'foreign key'. It's simply a primary key from another table.

> draw this on the board (one to many)

```sql
-- codeclan_times.sql
CREATE TABLE articles (
  id SERIAL8 PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  body TEXT,
  published_date DATE NOT NULL,
  writer_id INT8 REFERENCES writers(id)
);
```

We can see that the writers table now has a serial id and the articles table now has a "references writer(id)" statement. Our writer_id is a reference to the primary key in the writers table.

Foreign keys are generally named according to the convention "table_name_singular_id", unless another name makes more 'sense' (but it would always have `_id` to indicate it's a foreign key).

Now, before we do anything else - what happens if we change the order of the drops and run this again? Because articles now depends on writers, if we want to delete the writer table we must remove any tables that depend on it's primary keys.

Otherwise we'd end up with a whole bunch of zombie references to it. Let's fix that up and put it back in the correct sequence.

If we inspect our newly created rows, we can see the ids of the writers. Let's use these to modify the creation of the articles.

```sql
-- codeclan_times.sql
SELECT * FROM writers; --find the ids - depending on who got deleted 1 should be gone...

-- Now update the 2 previous articles, by adding the writer_id to them

INSERT INTO articles (title, body, published_date, writer_id) VALUES ('The Future is Robots', 'Lorem ipsum delo', '2018-09-22', 1);
INSERT INTO articles (title, body, published_date, writer_id) VALUES ('The Future is Robots II', 'Lorem ipsum delo', '2018-09-22', 2);

```

```zsh
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

What happens if we try to add a article with a writer id that doesn't exist?

```sql
-- codeclan_times.sql
INSERT INTO articles (title, body, published_date, writer_id) VALUES ('The Future is Robots II', 'Lorem ipsum delo', '2018-09-22', 5);
```

We get an error, as we might expect:

```
psql:codeclan_times.sql:24: ERROR:  insert or update on table "articles" violates foreign key constraint "articles_writer_id_fkey"
```

PSQL expects that the `writer_id` field of `articles` will contain an `INT` which `REFERENCES` the primary key of another table - the `id` column of `writers`. This `writer_id` column therefore contains a **foreign key**.

When we try to `INSERT INTO articles` some data, including a `INT` that _doesn't_ correspond to any `id` field in `writers`, we get an error. The constraint of a foreign key is that its value must also exist somewhere in the column of the other table, and `1138` is not an `id` of any writer. We have violated the foreign key constraint, which is what the error tells us.

## Conclusion

This is what we call a One to Many relationship. Each article has ONE owner (`writer`). A writer can have MANY `articles`, as different rows in the article table can have the same `writer_id`.

As a final step, lets add one more article to Clark, then lets find all articles that he has!

```sql
INSERT INTO articles (title, body, published_date, writer_id) VALUES ('The Future is Robots', 'Lorem ipsum delo', '2018-09-22', 1);
INSERT INTO articles (title, body, published_date, writer_id) VALUES ('The Future is Robots', 'Lorem ipsum delo', '2018-09-22', 1);

SELECT articles.*, writers.*
FROM articles, writers
WHERE writer_id = 1
AND writer_id = articles.id
```
