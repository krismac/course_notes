require("minitest/autorun")
require("minitest/rg")

require_relative("../player")

class PlayerTest < MiniTest::Test

  def setup
    @player = Player.new("Alan")
  end

  def test_name
    assert_equal("Alan", @player.name)
  end

  def test_lives_start_at_6
    assert_equal(6, @player.lives)
  end

  def test_can_lose_a_life
    @player.lose_life()
    assert_equal(5, @player.lives)
  end

end
