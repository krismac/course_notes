# Lab - Customer Model

We're going to add a Customer model so that we can assign `PizzaOrder`s to `Customer`s in Ruby, and reflect this relationship in our database

1. Create a `customers` table in the database by adding it to db/pizza_shop.sql and re-running that file with `psql -d pizza_shop -f db/pizza_shop.sql`

2. Create a constructor (`initialize` method) for the `Customer` that accepts an options Hash as its parameter and stores the customer's properties (`first_name`, `last_name`, `id`) as instance variables (Test this out in console.rb)

3. Write a `save` method for Customer objects (using the `SqlRunner` helper class) to take a Customer object and create a row in the `customers` database table. (Test this out in console.rb)

4. Write a `Customer.delete_all` method (using the `SqlRunner` helper class) and call it at the top of console.rb to avoid filling up the `customers` table every time we run console.rb

Extension

5. Add more CRUD methods to your Customer, you should use the `SqlRunner` helper class for all of these - You can do these in any order, whatever you prefer, for the next step after this lab we only need to be able to save Customers:
    - `Customer.all()` to get an array of all the Customer objects, one for each customer stored in the database
    - `.update()` to update the database to reflect changes to the Ruby object
    - `Customer.find(id)` to get a Customer object for a given id
    - `.delete()` to delete one customer object's related row from the DB table
