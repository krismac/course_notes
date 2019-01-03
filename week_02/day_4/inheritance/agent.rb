require_relative('person.rb')

class Agent < Person

  def talk
    return "The name's #{@l_name}, #{@f_name} #{@l_name}"
  end

end


bond = Agent.new("James", "Bond")
p bond.talk
