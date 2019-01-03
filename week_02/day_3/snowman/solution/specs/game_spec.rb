require("minitest/autorun")
require("minitest/rg")

require_relative("../game")
require_relative("../word")
require_relative("../player")

class GameTest < MiniTest::Test

  def setup
    word = Word.new("test")
    player = Player.new("Alan")
    @game = Game.new(word, player)
  end

  def test_guessed_letters_starts_empty
    assert_equal([], @game.guessed_letters)
  end

  def test_guess_letter
    @game.guess("t")
    assert_equal(["t"], @game.guessed_letters)
  end

  def test_guess_letter__duplicates_dont_count
    @game.guess("t")
    @game.guess("t")
    assert_equal(["t"], @game.guessed_letters)
  end

  def test_reveal_word
    @game.guess("t")
    assert_equal("t**t", @game.reveal_word)
  end

  def test_game_is_lost__false_at_start
    refute(@game.is_lost?)
  end

  def test_game_is_lost__true_after_six_fails
    @game.guess("a")
    @game.guess("b")
    @game.guess("c")
    @game.guess("d")
    @game.guess("f")
    refute(@game.is_lost?)
    @game.guess("g")
    assert(@game.is_lost?)
  end

  def test_game_is_won__false_at_start
    refute(@game.is_won?)
  end

  def test_game_is_won__true
    @game.guess("t")
    @game.guess("e")
    refute(@game.is_won?)
    @game.guess("s")
    assert(@game.is_won?)
  end

end
