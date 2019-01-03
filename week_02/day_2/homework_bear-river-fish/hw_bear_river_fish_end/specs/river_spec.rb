require('minitest/autorun')
require('minitest/rg')
require_relative('../fish.rb')
require_relative('../river.rb')

class TestRiver < Minitest::Test

  def setup
    @fish1 = Fish.new("Bob")
    @fish2 = Fish.new("Harry")
    @fish3 = Fish.new("Fred")
    @river = River.new("Amazon", [@fish1,@fish2,@fish3])
  end

  def test_can_have_name
    assert_equal("Amazon", @river.get_name)
  end

  def test_initial_state
    assert_equal(3, @river.number_of_fishes)
  end

  def test_can_get_fish
    fish = @river.get_fish
    assert_equal(@fish3.name, fish.name)
  end

end
