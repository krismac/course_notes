require_relative('person.rb')

class Medic < Person

  def heal
    return "I can heal people"
  end

end

m = Medic.new("Harry", "Pooter")
puts m.talk
