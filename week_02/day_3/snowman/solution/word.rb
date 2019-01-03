class Word

  def initialize(hidden_word)
    @hidden_word = hidden_word
  end

  def display(guesses = [])
    displayed_word = ""
    for char in @hidden_word.split('')
      if guesses.include?(char) || char == " "
        displayed_word << char
      else
        displayed_word << "*"
      end
    end
    return displayed_word
  end

  def include?(letter)
    return @hidden_word.include?(letter)
  end

end
