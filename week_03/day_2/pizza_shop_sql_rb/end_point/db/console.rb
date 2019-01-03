require('pry-byebug')
require_relative('../models/pizza_order')

PizzaOrder.delete_all

order1 = PizzaOrder.new({ 'first_name'=> 'Luke', 'last_name'=> 'Skywalker', 'topping'=> 'Napoli', 'quantity'=> '1'})
order2 = PizzaOrder.new({ 'first_name'=> 'Darth', 'last_name'=> 'Vader', 'topping'=> 'Quattro Formaggi', 'quantity'=> '1'})
 
order1.save()
binding.pry
nil