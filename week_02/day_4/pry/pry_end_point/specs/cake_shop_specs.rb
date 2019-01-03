require( 'minitest/autorun' )
require( 'minitest/rg' )
require_relative( '../cake_shop' )
require_relative( '../cake' )


class TestCakeShop < MiniTest::Test

  def setup
    ingredients1 = ["chocolate", "cocoa powder", "flour", "eggs", "sugar", "butter"]
    cake1 = Cake.new("brownie", ingredients1, 5)
    ingredients2 = ["carrots", "raisins", "cinnamon", "flour", "eggs", "sugar", "butter"]
    cake2 = Cake.new("carrot cake", ingredients2, 4)
    ingredients3 = ["lemon juice", "flour", "eggs", "sugar", "butter"]
    cake3 = Cake.new("lemon drizzle", ingredients3, 3)

    @cakes = [ cake1, cake2, cake3]
    @kates_cakes = CakeShop.new(@cakes)
  end

  def test_average_cake_rating
    assert_equal(4.0, @kates_cakes.average_cake_rating())
  end


end
