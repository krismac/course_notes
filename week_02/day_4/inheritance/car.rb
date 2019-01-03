require_relative('vehicle.rb')

class Car < Vehicle

  attr_reader :model, :doors

  def initialize(model, doors)
    super(4)
    @no_times_driven = 0
    @model = model
    @doors = doors
  end

end
