require_relative('car.rb')

class BubbleCar < Car

  def initialize(model, doors, no_bubbles)
    super(model, doors)
    @no_bubbles = no_bubbles
  end

end
