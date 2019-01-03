require_relative('car.rb')
require_relative('motorbike.rb')
require_relative('bubble_car.rb')

my_car = Car.new("MG", 2)
my_bike = Motorbike.new("trial")
my_bubble_car = BubbleCar.new("Ford", 2, 9)

lambourghini = Car.new("Lambourghini", 2)
puts lambourghini.number_of_wheels
