require("minitest/autorun")
require('minitest/rg')
require_relative("../pub")
require_relative("../drink")
require_relative("../customer")

class PubTest < MiniTest::Test

  def setup
    @drink1 = Drink.new("beer", 2.0)
    @drink2 = Drink.new("wine", 3.0)
    @drink3 = Drink.new("gin", 4.0)
    drinks = [@drink1, @drink2, @drink3]
    @pub = Pub.new("The Prancing Pony", 100.0, drinks)
    @customer = Customer.new("Frodo", 10.0)
  end

  def test_pub_has_name
    assert_equal("The Prancing Pony", @pub.name())
  end

  def test_pub_has_till
    assert_equal(100.0, @pub.till())
  end

  def test_pub_has_drinks
    assert_equal(3, @pub.drinks().length())
  end

  def test_pub_can_serve_drink
    @pub.serve(@customer, @drink1)
    assert_equal(8.0, @customer.wallet())
    assert_equal(102.0, @pub.till())
  end

end
