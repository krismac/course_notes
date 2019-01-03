class Bear
  attr_accessor :name, :type

  def initialize(name,type)
    @name = name
    @type = type
    @food = []
  end

  def roar
    "Rooooar"
  end

  def food_count
    @food.size
  end

  # Psuedocode! Write the logic in plain english first
  def take_fish_from_river(river)
  #   # i need a river
  #   # the river needs to give me a fish from inside itself
  #   # store the fish in local variable here in this method
    fish = river.get_fish()
  #   # put that fish in Bear's stomach (@food)
      @food << fish if !fish.nil?
  end

end
