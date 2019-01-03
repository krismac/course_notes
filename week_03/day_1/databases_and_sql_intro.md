# Databases and SQL Introduction

### Objectives

 - Understand what a database is
 - Explain what SQL is
 - Know how to use CRUD
 - Know how to create relationships

## What is a database?

A database is just somewhere for us to store our data. There are many different shapes and sizes of database. SQL is a language which is often used to query these databases and that's what we will be learning today.

## What do we do with databases

What do we store in databases?
> Get the students to make some suggestions

> Ensure you write the "CRUD" operations on the board under each other as the class suggest them, to read the acronym off vertically. Later, we will align these with the SQL commands written next to them.

 What sorts of manipulations do we make to data in databases?

 - Create (we can't do anything unless we can put data in)
 - Read (once it's in there, we need to get it out)
 - Update (if it needs to change, we need to be able to change it)
 - Delete (we'll need to be able to remove data from our database)

We refer to these four operations as "CRUD". This is important since you will come across it later when we begin web programming

> As you work through the sql commands, tick these off.

## What is SQL?

"SQL" stands for "Structured Query Language" (pronounced either as "ess-queue-ell" or "sequel"). In the same way that we use Ruby to talk to the computer, we can use SQL to talk to a database.

## PostgreSQL

SQL is just a language - we need an engine to run it on. In the same way that Ruby is just a language, that runs on an "interpreter" - our Ruby robot we spoke about before.

PostgreSQL is an open source object-relational database system that we will be using on the course.

To check that psql is installed, we can type this.

```bash
# terminal
which psql
```

> If there are any issues with running `psql`, ensure that the `postgresapp` is installed and running (it should have been configured in installfest), and that the path is updated to include it - launch `psql` from the system icon, and note the path used.

```bash
# terminal
psql
```

To quit the sql terminal

```sql
-- psql terminal
\q
```

## Structure

In SQL, a database is a collection of "tables". A table is a collection of "columns" and "rows".

A table describes the type of item that we want to store. A column represents some information we might find interesting about that item. A row is the physical data we want to save.

> Draw this on the board

For example, we might have a `zoo` database with a table called `animals`. The `animals` table might have the columns `name`, `age` and `species`. The `animals` table would then have rows of data like:

| `name` | `age` | `species` |
| --- | --- | --- |
| Leo | 12 | Lion |
| Tony | 8 | Tiger |

Note: a column is sometimes referred to as a field, but they mean the exact same thing.

## Creating a database

To work with data in databases we perform the four CRUD operations.
So we'll work through the SQL commands that give us that functionality.

Before we can do anything though, we need to create a table to store our records in. But before we can create a table, we have to create a database to put it in!

```sql
-- psql terminal
CREATE DATABASE codeclan_times; -- REMEMBER SEMI COLON
\q
```

Another, much more convenient way to create or delete a database is through the terminal:

```bash
dropdb codeclan_times
createdb codeclan_times
```

## Data Types

So before we run off and create lots of shiny tables, we need to talk about datatypes. You'll be glad to hear they roughly match up to what we have already seen in Ruby. There are many data types we can use in SQL - the most common we will be using are:

* VARCHAR - fixed length text (string)
* INT - numerical data (integer)
* BOOLEAN - true / false data (trueclass, falseclass, booleans)
* DATE - date (no time of day)

We can pass arguments to VARCHAR to say how large we want the data in the field to be as a maximum.

# Creating tables

By convention, we will name our database tables as the plural of the thing we are creating. So rows of animal data would be stored in a table called animals. Sheep would be stored in a table called... well, sheep.

Let's make a table that's going to store data about writers and articles for the Daily Planet. A writer might have the following attributes:

- f_name
- l_name
- staff (true / false)
- dob

> Get the students to think about what types these columns will be.

Before we create a table, we will drop it so that we can run our script multiple times. PostgreSQL won't let you create a table that already exists.

```bash
# terminal
touch codeclan_times.sql
```

We can use the following template every time we create a new database table:

```sql
DROP TABLE table_name;

CREATE TABLE table_name (
  column_name1 DATA_TYPE,
  column_name2 DATA_TYPE,
  column_name3 DATA_TYPE
)

```

So, in our case, it would look like this:

```sql
-- star_wars.sql
DROP TABLE writers;

CREATE TABLE writers (
  f_name VARCHAR(255),
  l_name VARCHAR(255),
  staff BOOLEAN,
  dob DATE
);
```

> 255 is used because it's the largest number of characters that can be counted with an 8-bit number. It maximizes the use of the 8-bit count, without frivolously requiring another whole byte to count the characters above 255.

- What is our table called?
- What are the names of our columns?
- What are the size constraints?

There is a special command that we can run from the terminal to execute PostgreSQL scripts.

```bash
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

We will write all of our statements in the one file and comment them out, so you can keep the story of what we are working through.


## Creating (-C-rud)

> Remember to tick off the CRUD items on the board

We're going to start with the C in CRUD but first let's learn the SQL statement that you'll probably use most of all.

```sql
-- codeclan_times.sql
SELECT * FROM writers;
```

> You may want to comment out select statements as you go, so only the latest one is shown, or just keep moving the select down the script as we go.

This says "get everything from the writers table." The `*` means 'all the fields'.

To "create" records in SQL, we use the `INSERT` clause.

We are going to make a lot of use of the Atom shortcuts `cmd` + `shift` + `d` to duplicate a line as well as `cmd` + `/` to comment a line.

The template for creating entries is the following:

```sql
INSERT INTO table_name (column_name1, column_name2) VALUES (value1, value2);
```

Let's create some writers!

```sql
-- codeclan_times.sql
-- REMEMBER SEMI COLONS!
-- The date format is YYYY-MM-DD

INSERT INTO writers (f_name, l_name, staff, dob) VALUES ('Clark', 'Kent', true,  '1939-02-18');
INSERT INTO writers (f_name, l_name, staff, dob) VALUES ('Lois', 'Lane', true, '1939-03-27');
INSERT INTO writers (f_name, l_name, staff, dob) VALUES ('Marcia', 'Clark', true, '1942-12-25');

SELECT f_name, l_name, TO_CHAR(dob, 'dd Mon yyyy')  FROM writers;
```

```bash
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

Note that the `INSERT 1 0` is telling us that 1 row was inserted with an id of 0 (has no id, more on this later).

We need to be careful with quotation marks in PostgreSQL - we should always use single quotes. Single quotes behave in the normal way we'd expect - defining text. Double quotes are reserved for system operations. Try not to worry too much about this, just remember to use single quotes when dealing with data.

If we ever need to use a quotation mark or apostrophe in our inserted text, we need to escape it with a backslash or use two of them.

We use the convention uppercase for SQL keywords and lowercase for our own terms. It's not mandatory but it makes it easier to read.

## Inserting nulls

What would happen if we do this?

```sql
-- codeclan_times.sql
INSERT INTO writers (f_name, l_name, staff) VALUES ('Jimmy', 'Olsen', false);
```

```sql
-- codeclan_times.sql
SELECT * FROM writers
```

```bash
# terminal
psql -d codeclan_times -f codeclan_times.sql
```
Notice that the value for `dob` is null. Any values which are not passed in are set to null.

## Selecting (c-R-ud)

This is the R is CRUD.

We have been "reading" records with the `SELECT` clause.

```sql
-- codeclan_times.sql
SELECT * FROM writers;
```

The star is saying that we want all the fields returned, if we said:

```sql
-- codeclan_times.sql
SELECT f_name FROM writers;
```

...it would only list the names.

We can also use `SELECT` to count how many rows we have

```sql
-- codeclan_times.sql
SELECT COUNT(*) FROM writers;
```
```sql
-- codeclan_times.sql
-- get name, staff and nice dob format
SELECT f_name, l_name, staff, TO_CHAR(dob, 'dd Mon yyyy')
```

# WHERE clause

We can use a WHERE clause to filter the data that we select.

```sql
SELECT * FROM writers
WHERE l_name = 'Kent'
```

> [TASK:]
- See if you can select all the columns of the staff WRITERS

```sql
SELECT *
FROM writers
WHERE staff = TRUE;
```

# ORDER BY

Let's add another clause to ORDER our results

```sql
SELECT *
FROM writers
ORDER BY dob ASC;
```

# Updating (cr-U-d)

This is the U in CRUD.

We use the `UPDATE` clause to change the values in existing records.

Template:
```sql
UPDATE table_name SET column_name1 = new_value1;
```

Let's update the staff column to true!

```sql
-- codeclan_times.sql
UPDATE writers SET staff = true;
```

```bash
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

Note that it says `UPDATE 4` - what does this mean?

This has updated all our records (4 of them)... what if we only want certain records to update?

We can use a `WHERE` clause to achieve this.

```sql
-- codeclan_times.sql
UPDATE writers
SET staff = false
WHERE f_name = 'Lois'
AND l_name = 'Lane';
```

```bash
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

We can even update more than one field at a time! This, however, uses a different syntax. When we select multiple columns to update, we have to put them in brackets, and we have to do the same when we give it the values we want to use. Remember, just like with Insert, order matters!

Template:
```sql
UPDATE table_name SET (column_name1, column_name2) = (new_value1, new_value2) WHERE column_name = target_value;
```

Let's update Clark!

```sql
-- Change the line you just wrote:
UPDATE writers SET (f_name, l_name) = ('Superman', NULL)
WHERE f_name = 'Clark'
AND l_name = 'Kent';
```

```bash
# terminal
psql -d codeclan_times -f codeclan_times.sql
```

> [TASK:]
- Update Superman and turn him back into Clark Kent
- Update Lois to be Superwoman


# Deleting (cru-D-)

This is the D in CRUD.

To delete records we use the `DELETE` clause. But **be careful**, there's no undo! When a record is deleted from a DB it's gone for ever. "Undelete" in the database world is "restore from last night's backup" (if there *was* a backup...)

Template:
```sql
DELETE FROM table_name WHERE column_name = target_value;
```

**SPOILERS** Let's delete Jimmy

```sql
-- codeclan_times.sql
DELETE FROM writers WHERE f_name = 'Jimmy' AND l_name = 'Olsen';
```

**WARNING**: If you don't specify the row(s) with a WHERE clause, it will delete *everything* from that table!

```sql
DELETE FROM writers; -- DELETES EVERYTHING FROM WRITERS
```

```bash
# terminal
psql -d codeclan_times -f codeclan_times.sql;
```

# Uniquely identifying rows

We want a unique identifier for each row. That column will contain a number, which will be unique for each row in the database, and ideally is managed by the database itself, so we don't need to worry about adding it when we insert new records.

## Serials

We are going to need an `id` column, to solve our problem of uniquely identifying rows.

The new `id` field is a `SERIAL` type -- an internal type of PostgreSQL's, which will look after numbering for us in an eight byte integer field. This gives us up to 9 quintillion[`*`] ids which is probably enough.

[`*`] Nine quintillion, two hundred twenty-three quadrillion, three hundred seventy-two trillion, thirty-six billion, eight hundred fifty-four million, seven hundred seventy-five thousand, eight hundred and seven. See https://en.wikipedia.org/wiki/9,223,372,036,854,775,807

Serials are super special integers, that auto increment themselves. If we had simply used INT, we'd have to manually curate them and make sure we added 1 every time we added a row, which would be horrible! This would also cause issues if we had concurrent users - what if they both made a row at the same time? Serials take care of this nightmare for us.

Note that different database engines handle this in different ways, serials are a PostgreSQL specific construct which other engines might use.

Let's update our writers

```sql
-- codeclan_times.sql
CREATE TABLE writers (
  id SERIAL8 PRIMARY KEY,
  f_name VARCHAR(255),
  l_name VARCHAR(255),
  staff BOOLEAN,
  dob DATE
);
```

If we run our script now we should see something cool. Each of our entries magically has a unique id, and we didn't need to do anything to manage it.


```sql
UPDATE writers SET staff = true WHERE id = 9;
```

Our next step is figuring out how to add articles to our writers!
