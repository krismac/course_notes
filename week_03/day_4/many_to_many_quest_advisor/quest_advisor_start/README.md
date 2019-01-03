# Quest Advisor

## Setup

**Create database**

```sh
createdb quest_advisor
```

-----

**Create tables in database**

```sh
psql -d quest_advisor -f ./db/quest_advisor.sql
```

-----

**Create seed data for DB**

(This will fail in the start point)

```sh
ruby console.rb
```
