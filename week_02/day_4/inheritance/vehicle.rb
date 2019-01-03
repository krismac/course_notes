class Vehicle

  attr_reader :number_of_wheels

  def initialize(number_of_wheels)
    @number_of_wheels = number_of_wheels
  end

  def start_engine
    return "Vrmmmmm"
  end

end
