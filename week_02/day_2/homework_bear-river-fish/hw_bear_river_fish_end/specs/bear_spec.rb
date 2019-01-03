require('minitest/autorun')
require('minitest/rg')
require_relative('../bear.rb')
require_relative('../fish.rb')
require_relative('../river.rb')

class TestBear < Minitest::Test

  def setup
    @bear = Bear.new("Yogi","Grizzly")

    fish1 = Fish.new("Bob")
    fish2 = Fish.new("Harry")
    fish3 = Fish.new("Fred")

    @amazon = River.new("Amazon", [fish1, fish2, fish3])
  end

  def test_bear_name
    assert_equal("Yogi", @bear.name)
  end

  def test_bear_has_empty_food_array
    assert_equal(0,@bear.food_count)
  end

  def test_bear_can_take_fish_from_river
    @bear.take_fish_from_river(@amazon)
    assert_equal(1,@bear.food_count)
    assert_equal(2,@amazon.number_of_fishes)
  end

  def test_bear_cant_take_fish_from_empty_river
    river = River.new("Clyde", [])
    @bear.take_fish_from_river( river )
    assert_equal(0,@bear.food_count)
    assert_equal(0,river.number_of_fishes)
  end

end
