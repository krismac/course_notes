require("minitest/autorun")
require('minitest/rg')
require_relative("../drink")

class DrinkTest < MiniTest::Test

  def setup
    @drink = Drink.new("wine", 4.0, 5)
  end

  def test_drink_has_name
    assert_equal("wine", @drink.name())
  end

  def test_drink_has_price
    assert_equal(4.0, @drink.price())
  end

  def test_drink_has_alcohol_level
    assert_equal(5, @drink.alcohol_level())
  end

end
