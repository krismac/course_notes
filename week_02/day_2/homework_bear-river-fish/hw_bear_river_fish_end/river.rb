class River

  def initialize(name, fishes)
    @name = name
    @fishes = fishes
  end

  def get_name
    @name
  end

  def number_of_fishes
    @fishes.size
  end

  def get_fish
    @fishes.pop
  end
end