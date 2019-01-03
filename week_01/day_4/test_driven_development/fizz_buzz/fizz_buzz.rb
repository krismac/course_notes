def fizz_buzz(number)
  div_by_3 = number % 3 == 0
  div_by_5 = number % 5 == 0

  if div_by_3 && div_by_5
    return 'FizzBuzz'
  elsif div_by_3
    return 'Fizz'
  elsif div_by_5
    return 'Buzz'
  else
    return number.to_s()
  end
end
