require_relative('vehicle.rb')

class Motorbike < Vehicle

  attr_reader :type

  def initialize(type)
    super(2)
    @type = type
  end

  def start_engine
    return "I'm a motorbike"
  end

end
