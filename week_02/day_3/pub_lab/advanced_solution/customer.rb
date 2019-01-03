class Customer

  attr_reader :name, :wallet, :age, :drunkenness

  def initialize(name, wallet, age, drunkenness)
    @name = name
    @wallet = wallet
    @age = age
    @drunkenness = drunkenness
  end

  def buy_drink(drink)
    if sufficient_funds?(drink)
      @wallet -= drink.price()
      @drunkenness += drink.alcohol_level()
    end
  end

  def sufficient_funds?(item)
    return wallet >= item.price()
  end

end
