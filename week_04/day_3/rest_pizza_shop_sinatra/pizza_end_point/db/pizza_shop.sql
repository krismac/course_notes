DROP TABLE pizza_orders;

CREATE TABLE pizza_orders (
  id serial4 primary key,
  first_name varchar(255),
  last_name varchar(255),
  topping varchar(255),
  quantity int2
);