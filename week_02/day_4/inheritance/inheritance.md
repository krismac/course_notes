# Inheritance

## Learning Objectives

- Be able to describe inheritance
- Implement superclass and subclass
- Know how to override methods
- Sharing a constructor

> Duration 2 hours

Sometimes we might have a bunch of classes that all share some behaviour. For example, a sparrow can fly, but so can a crow.

A car has wheels, but so does a motorbike - they also both help you travel somewhere, and both have an engine that can start.

How can we represent this in our code?

```bash
#terminal

touch car.rb motorbike.rb
mkdir specs
touch specs/car_spec.rb specs/motorbike_spec.rb

atom .
```

```ruby
# car_spec.rb
require('minitest/autorun')
require('minitest/rg')
require_relative('../car')

class TestCar < Minitest::Test
  def setup
    @car = Car.new()
  end

  def test_car_can_start_engine
    assert_equal("Vrrmmm", @car.start_engine)
  end

end
```

```ruby
# car.rb
class Car
  def start_engine
    return "Vrrmmm"
  end
end
```

Now if we want to make a motorbike that also starts its engine what do we do? The simplest solution is that we can copy and paste the code.

```ruby
# motorbike_spec.rb

require('minitest/autorun')
require('minitest/rg')
require_relative('../motorbike')

class TestMotorbike < Minitest::Test
  def setup
    @motorbike = Motorbike.new()
  end

  def test_motorbike_can_start_engine
    assert_equal("Vrrmmm", @motorbike.start_engine)
  end
end
```

```ruby
# motorbike.rb
class Motorbike
  def start_engine
    return "Vrrmmm"
  end
end
```

This is dirty. We want to be able to reuse our code.

If we change this method we need to alter it in two places. We can move this to a "super class" where the behaviour can be shared among the two "sub classes".

```bash
# terminal

touch vehicle.rb
```

```ruby
# vehicle.rb
class Vehicle
  def start_engine
    return "Vrrmmm"
  end
end
```

```ruby
# vehicle_spec.rb
require('minitest/autorun')
require('minitest/rg')
require_relative('../vehicle.rb')

class TestVehicle < Minitest::Test
  def setup
    @vehicle = Vehicle.new()
  end

  def test_vehicle_can_start_engine
    assert_equal("Vrrmmm", @vehicle.start_engine)
  end
end
```

```ruby
# car.rb
require_relative('vehicle')
class Car < Vehicle

end
```

```ruby
# motorbike.rb
require_relative('vehicle')
class Motorbike < Vehicle

end
```

Our tests still pass. This is as if the two classes are joined together - the behaviour is passed down to the subclass. This is called "inheriting" properties or behaviours.

## Overriding

If we declare a method with the same name in a subclass that is shared with a parent, we override it.  Ruby first looks to the class, and then the super class.  Let's change the motorbike so it has specific behaviour.

```ruby
# motorbike_spec.rb

class MotorbikeTest < MiniTest::Test
	def setup
    @motorbike = Motorbike.new("green")
  end

  def test_motorbike_can_start_engine
    assert_equal("Vrrmmm (I'm a motorbike), HELL YEAH!", @motorbike.start_engine)
  end
end
```

```ruby
# motorbike.rb

class Motorbike
	def start_engine
    return "Vrrmmm (I'm a motorbike), HELL YEAH!"
  end
end
```

## `super`
What if wanted our motorbike to do something unique and to also do its parent behaviour.  Enter `super`.

`super` calls its parent (super) class method.

```ruby
# motorbike.rb

class Motorbike < Vehicle
  def start_engine
    vehicle_start = super()
    return vehicle_start + " (I'm a motorbike), HELL YEAH!"
  end
end
```

## Shared Constructor

Note that if we add a constructor to Vehicle, all of the derived classes share it.

```ruby
# vehicle.rb

attr_reader :number_of_wheels
def initialize
  @number_of_wheels = 4
end
```

```ruby
# vehicle_spec.rb

def test_vehicle_has_number_of_wheels
  assert_equal(4, @vehicle.number_of_wheels)
end
```

```ruby
# car_spec.rb

def test_car_has_four_weels
	assert_equal(4, @car.number_of_wheels)
end
```

If we added a parameter to the constructor, all of our vehicle classes would have to use it.

```ruby
# vehicle.rb

attr_reader :number_of_wheels
def initialize(number_of_wheels)
  @number_of_wheels = number_of_wheels
end
```

```ruby
# vehicle_spec.rb

def setup
  @vehicle = Vehicle.new(4)
end
```

Now if we want to set one of our subclasses to have that property as a constant value, e.g. so we don't have to keep on passing in that a car has four wheels, we can call super() on the intialize method and pass in the value.

```ruby
# car.rb

def initialize
  super(4)
end
```

We can do the same for our motorbike so it always has two wheels.

If we want to also pass additional parameters to the constructor, we can do this - we can override initialize and also call super to set the wheels.

```ruby
# car.rb

attr_reader :model

def initialize(model)
  super(4)
  @model = model
end
```

```ruby
# car_spec.rb

def setup
  @car = Car.new("Ferrari")
end

def test_car_has_model
  assert_equal("Ferrari", @car.model)
end
```


> [Task:] Make your own mini chain of inheritance: Make a Person class.  A person should have a first name and last name and a talk method which says its name.  Make a Medic class which inherits from Person, and also has a heal method.  Make a Agent class that talks like an agent.  "The names Bond, James Bond".

# Finally...

This inheritance stuff seems pretty useful. However if we use it too much it can sometimes be limiting, or make us write our code in a convoluted way. For example, imagine we want to make a Bicycle class. Surely this should inherit from Vehicle - it does transport people around, and it does have wheels. However it doesn't have an engine, so inheriting a start_engine method is a bit of a problem.. what are some solutions?

- Overwrite the start_engine to just return 'I don't have an engine'
- Remove start_engine from vehicle and put it back on Car and Motorbike
- Add another layer of inheritance to have 'EnginedVehicles' and 'HumanPoweredVehicles'

... all of these are a bit nasty. This is where we come onto composition as an alternative way of structuring our programs.
