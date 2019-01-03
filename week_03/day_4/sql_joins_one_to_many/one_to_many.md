# Joining data together
`

In our writers example, we linked the articles to a writer through the `writer_id`, but we didn't have an easy way to see that information all together.

Say for example, we wanted to view a list of wrtiers names with the relevant information about their articles.

We could do it, but we'd have to use multiple queries.

It is possible to do in one query, we just need to add a new tool to our toolbelt to make this happen - joins.

## Joins

When we join data, there's a few different ways we can approach it but the one thing that really matters is that there has to be some commonality between the tables. In our case, we have the Jedi id linking the two tables and we can use this to do some interesting things.

With joins, we think in terms of a 'right' column and a 'left' column. These can be any table you like, but it's worth being clear in your head which one you are talking about.

Let's say the `writers` table is the 'left' table and the `articles` table is the 'right table'.

You can think of a join query as giving us back a sort of 'middle' view that takes data from both sides and combines it.

We might want to:
- find a match between the columns in both tables using a common key => INNER JOIN
- return all rows from the left table (`writers`), with the matching rows in the right table (`articles`). The result is NULL in the right side when there is no match. => LEFT JOIN
- return all rows from the right table (`articles`), with the matching rows in the left table (`writers`). The result is NULL in the left side when there is no match. => RIGHT JOIN

The first option is the most common and that's what we are going to look at just now.

## Explicitly Naming Tables

Sometimes when writing our queries, we want to make it clear which tables we're working with. Let's look at a really simple example:

```sql
-- psql
SELECT * FROM writers;
```

We can explicitly name the table like so:

```sql
SELECT writers.* FROM writers;
```

This helps when we have tables with the same property e.g. id or name etc. We can make it very clear which table we want to use.

This will be incredibly useful when we make joins between tables, as it will help
us keep track of which tables have which properties.

## INNER JOIN

INNER JOIN syntax is pretty weird, but hang in there and we'll be okay.

Let's see if we can list all of the Jedi with their relevant article data.

STEP ONE: Select the columns from the left hand table, using an alias.

```sql
SELECT writers.* FROM writers;
```

STEP TWO: Introduce the right hand table you want to bring into the join and the common property you want to match on

```sql
SELECT writers.* FROM writers
INNER JOIN articles
ON writers.id = articles.writer_id;
```

STEP THREE: Bring in the columns from the right hand table

```sql
SELECT writers.*, articles.* FROM writers
  INNER JOIN articles
  ON writers.id = articles.writer_id;
```

There is our data!

[TASK]: See if you can return only the writer name and articles title from the join.

```sql
SELECT writers.name, articles.title FROM writers
  INNER JOIN articles
  ON writers.id = articles.writer_id;
```

## Left (Outer) Join

I mentioned earlier that we might want to do a query where we return all the rows from the left table (`writers`), with the matching rows in the right table (`articles`). In this case, any writer with no matching article will have values shown as null for those columns.

```sql
SELECT writers.*, articles.* FROM writers
  LEFT JOIN lightsabers
  ON writers.id = articles.writer_id;
```

Right joins are exactly the same, but with the tables swapped around. It doesn't matter for our articles, since every single article is owned by a writer so there is never a case where a null would be shown.
