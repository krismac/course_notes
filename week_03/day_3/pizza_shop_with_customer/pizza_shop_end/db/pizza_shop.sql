DROP TABLE IF EXISTS pizza_orders;
-- Must be after pizza_orders:
DROP TABLE IF EXISTS customers;

-- Must be before pizza_orders:
CREATE TABLE customers (
  id SERIAL8 PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE pizza_orders (
  id SERIAL8 PRIMARY KEY,
  customer_id INT8 REFERENCES customers(id),
  topping VARCHAR(255),
  quantity INT2
);
