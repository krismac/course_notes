require_relative('../models/pizza_order')

PizzaOrder.delete_all()

pizza1 = PizzaOrder.new({
  "first_name" => "Walter",
  "last_name" => "White",
  "topping" => "Pepperoni",
  "quantity" => 1
})

pizza2 = PizzaOrder.new({
  "first_name" => "Jesse",
  "last_name" => "Pinkman",
  "topping" => "Italian Sausage",
  "quantity" => 12
})

pizza1.save
pizza2.save
