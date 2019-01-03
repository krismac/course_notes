require_relative("./game")
require_relative("./word")
require_relative("./player")

puts "Please enter a secret word:"
input = gets.chomp
hidden_word = Word.new(input)
snowman = Game.new(hidden_word, Player.new("Player 1"))

print %x{clear}


until snowman.is_won? || snowman.is_lost?
  puts "Welcome to Snowman!"
  puts "The hidden word is: #{snowman.reveal_word}"
  puts "#{snowman.lives_remaining} lives remaining"
  puts "Guess a letter:"
  snowman.guess(gets.chomp[0])
  print %x{clear}
end

puts "You win! The word was #{snowman.reveal_word}" if snowman.is_won?
puts "You suck! The word was #{input}" if snowman.is_lost?
