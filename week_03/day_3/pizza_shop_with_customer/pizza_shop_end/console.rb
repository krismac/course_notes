require_relative('./models/pizza_order.rb')
require_relative('./models/customer.rb')
require('pry')

PizzaOrder.delete_all()
Customer.delete_all()

customer1 = Customer.new({
  'first_name' => 'Jimmy',
  'last_name' => 'McGill'
})
customer1.save()
customer2 = Customer.new({
  'first_name' => 'Gus',
  'last_name' => 'Fring'
})
customer2.save()

customer2.first_name = 'Gustavo'
customer2.update()

order1 = PizzaOrder.new({
  'customer_id' => customer1.id,
  'topping' => 'Pepperoni',
  'quantity' => 1
})
order2 = PizzaOrder.new({
  'customer_id' => customer1.id,
  'topping' => 'Vegetable',
  'quantity' => 8
})
order1.save()
order2.save()
order1.quantity = 1000
order1.update()
orders = PizzaOrder.all()

# customer1.orders()

binding.pry
nil
