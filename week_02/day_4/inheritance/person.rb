class Person

  attr_reader :f_name, :l_name

  def initialize(f_name, l_name)
    @f_name = f_name
    @l_name = l_name
  end

  def talk
    return "My name is #{@f_name} #{@l_name}"
  end

end
