require( 'minitest/autorun' )
require( 'minitest/rg' )
require_relative( '../cake' )


class TestCakeShop < MiniTest::Test

  def setup()
    ingredients1 = ["chocolate", "cocoa powder", "flour", "eggs", "sugar", "butter"]
    @cake1 = Cake.new("brownie", ingredients1, 5)
    ingredients2 = ["carrots", "raisins", "cinnamon", "flour", "eggs", "sugar", "butter"]
    @cake2 = Cake.new("carrot cake", ingredients2, 4)
  end

  def test_cake_has_name()
    assert_equal("brownie", @cake1.name)
  end

  def test_cake_has_rating()
    assert_equal(5, @cake1.rating)
  end


end
