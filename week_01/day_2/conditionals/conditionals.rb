if true
  p 'this code will always run'
end

if false
  p 'this will never run'
end

if 1 > 1000
  p 'this will never run'
elsif false
  p 'this will never run either'
elsif 5 == 6
  p 'this will never run either!!!'
else
  p 'this will run'
end

p 'Guess my favourite animal...'

guess = gets().chomp().downcase()

if guess == 'giraffe'
  p 'Yay! My favourite!!'
else
  p 'Aww, not my favourite'
end

craig_hungry = true
craig_tired = false

if craig_hungry && craig_tired
  p 'Craig is HANGRY'
end

if craig_hungry || craig_tired
  p 'Craig is a bit grumpy'
end

score = gets.chomp.to_i

case score
when 10
  p 'perfect!'
when 7..9
  p 'merit'
when 5..6
  p 'pass'
else
  p 'fail :('
end

result = 'fail'

score = 6

# if score >= 5
#   result = 'pass'
# end

# Guard version:
result = 'pass' if score >= 5

p result

score = 6

if score >= 5
  p 'pass'
else
  p 'fail'
end

# Ternary
p score >= 5 ? 'pass' : 'fail'
