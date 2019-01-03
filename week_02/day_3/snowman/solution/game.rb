class Game

  attr_reader :guessed_letters

  def initialize(word, player)
    @word = word
    @player = player
    @guessed_letters = []
  end

  def guess(letter)
    @guessed_letters << letter unless @guessed_letters.include?(letter)
    @player.lose_life() unless @word.include?(letter)
  end

  def reveal_word()
    @word.display(@guessed_letters)
  end

  def lives_remaining()
    return @player.lives
  end

  def is_lost?()
    return @player.lives <= 0
  end

  def is_won?()
    return !reveal_word().include?("*")
  end

end
