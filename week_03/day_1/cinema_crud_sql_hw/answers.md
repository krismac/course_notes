# SQL Homework Answers

1) Return ALL the data in the 'movies' table.

```sql
SELECT * FROM movies;
```

2) Return ONLY the name column from the 'people' table

```sql
SELECT name FROM people;
```

3) Oops! Someone at CodeClan spelled Keith's name wrong! Change it to reflect the proper spelling.

```sql
UPDATE people SET name = 'Keith Douglas' WHERE id = 22;
```

4) Return ONLY your name from the 'people' table.

```sql
SELECT name FROM people WHERE id = 1;
```

5) The cinema is showing 'Batman Begins', but Batman is DC, not Marvel! Delete the entry from the 'movies' table.

```sql
DELETE FROM movies WHERE title = 'Batman Begins';
```

6) Create a new entry in the 'people' table with the name of one of the instructors.

```sql
INSERT INTO people (name) VALUES ('Siân RD');
```

7) Pawel, has decided to hijack our movie evening, Remove him from the table of people

```sql
DELETE FROM people WHERE name = 'Pawel';
```


8) The cinema has just heard that they will be holding an exclusive midnight showing of 'Avengers: Infinity War'!! Create a new entry in the 'movies' table to reflect this.

```sql
INSERT INTO movies (title, year, show_time) VALUES ('Avengers: Infinity War', 2017, '00:00');
```

9) The cinema would also like to make the Guardian movies a back to back feature. Update the 'Guardians of the Galaxy' show time from 12:10 to 21:30

```sql
UPDATE movies SET show_time = '21:30' WHERE title = 'Guardians of the Galaxy';
```

## Extension

1) Research how to delete multiple entries from your table in a single command.

```sql
DELETE FROM table WHERE name='' OR name='';
```

2) Select all the movies ordered by year in descending order

```sql
SELECT * FROM movies
ORDER BY year DESC;
```