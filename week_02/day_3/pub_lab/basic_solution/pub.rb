class Pub

  attr_reader :name, :till, :drinks

  def initialize(name, till, drinks)
    @name = name
    @till = till
    @drinks = drinks
  end

  def serve(customer, drink)
    if @drinks.include?(drink)
      customer.buy(drink)
      @till += drink.price()
    end
  end

end
