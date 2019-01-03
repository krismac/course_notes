require("minitest/autorun")
require('minitest/rg')
require_relative("../pub")
require_relative("../drink")
require_relative("../customer")

class PubTest < MiniTest::Test

  def setup
    @drink1 = Drink.new("beer", 2.0, 5)
    @drink2 = Drink.new("wine", 3.0, 10)
    @drink3 = Drink.new("gin", 4.0, 30)
    drinks = [@drink1, @drink2]
    @pub = Pub.new("The Prancing Pony", 100.0, drinks)
    @customer1 = Customer.new("Frodo", 10.0, 28, 0)
    @customer2 = Customer.new("Merry", 15.0, 17, 0)
    @customer3 = Customer.new("Pippin", 100.0, 28, 0)
  end

  def test_pub_has_name
    assert_equal("The Prancing Pony", @pub.name())
  end

  def test_pub_has_till
    assert_equal(100.0, @pub.till())
  end

  def test_pub_has_drinks
    assert_equal(2, @pub.drinks().length())
  end

  def test_customer_too_young__returns_true
    assert_equal(true, @pub.customer_too_young?(@customer2))
  end

  def test_customer_too_young__returns_false
    assert_equal(false, @pub.customer_too_young?(@customer1))
  end

  def test_customer_too_drunk__returns_false
    assert_equal(false, @pub.customer_too_drunk?(@customer1))
  end
  def test_customer_too_drunk__returns_true
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    assert_equal(true, @pub.customer_too_drunk?(@customer3))
  end

  def test_pub_can_serve_stocked_drink
    @pub.serve(@customer1, @drink1)
    assert_equal(8.0, @customer1.wallet())
    assert_equal(102.0, @pub.till())
  end

  def test_pub_cannot_serve_non_stocked_drink
    @pub.serve(@customer1, @drink3)
    assert_equal(10.0, @customer1.wallet())
    assert_equal(100.0, @pub.till())
  end

  def test_pub_checks_age__serves_over_18
    @pub.serve(@customer1, @drink2)
    assert_equal(7.0, @customer1.wallet())
    assert_equal(103.0, @pub.till())
  end

  def test_pub_checks_age__doesnt_serve_underage
    @pub.serve(@customer2, @drink2)
    assert_equal(15.0, @customer2.wallet())
    assert_equal(100.0, @pub.till())
  end

  def test_pub_doesnt_serve_at_or_above_50_drunkenness
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    @pub.serve(@customer3, @drink2)
    assert_equal(85.0, @customer3.wallet())
    assert_equal(50, @customer3.drunkenness())
    assert_equal(115.0, @pub.till())
  end

end
