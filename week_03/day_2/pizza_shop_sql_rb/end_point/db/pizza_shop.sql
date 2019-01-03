DROP TABLE IF EXISTS pizza_orders;

CREATE TABLE pizza_orders (
  id SERIAL4 PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  topping VARCHAR(255),
  quantity INT2
);