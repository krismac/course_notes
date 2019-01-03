require("minitest/autorun")
require("minitest/rg")

require_relative("../word")

class WordTest < MiniTest::Test

  def setup
    @word = Word.new("test")
  end

  def test_is_hidden
    assert_equal("****", @word.display)
  end

  def test_word_includes_letter
    assert(@word.include?('t'))
  end

  def test_reveals_letters
    revealed_t = @word.display(['t'])
    assert_equal("t**t", revealed_t)
  end

  def test_reveals_whole_word
    revealed_word = @word.display(['t', 'e', 's'])
    assert_equal("test", revealed_word)
  end

end
