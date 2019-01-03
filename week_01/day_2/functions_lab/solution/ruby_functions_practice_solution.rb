def return_10()
  return 10
end

def add(first_number,second_number)
  return first_number + second_number
end

def subtract(first_number,second_number)
  return first_number - second_number
end

def multiply(first_number,second_number)
  return first_number * second_number
end

def divide(first_number,second_number)
  return first_number / second_number
end

def length_of_string(input_string)
  return input_string.length
end

def join_string(string_1, string_2)
  return string_1 + string_2
end

def add_string_as_number(string_1, string_2)
  return string_1.to_i + string_2.to_i
end

def number_to_full_month_name(number)
  month_name = case number
    when 1
      "January"
    when 2
      "February"
    when 3
      "March"
    when 4
      "April"
    when 5
      "May"
    when 6
      "June"
    when 7
      "July"
    when 8
      "August"
    when 9
      "September"
    when 10
      "October"
    when 11
      "November"
    when 12
      "December"
    end
  return month_name
end

def number_to_short_month_name(number)
  sliced_month_name = number_to_full_month_name(number).slice(0,3)
  return sliced_month_name
end

def volume_of_cube(length_of_side)
  volume = length_of_side ** 3
  return volume
end

def volume_of_sphere(radius)
  volume = (4.0 / 3.0) * Math::PI * (radius ** 3)
  return volume.round(2)
end

def fahrenheit_to_celsius(fahrenheit)
  celsius = (fahrenheit - 32) * (5.0/9.0)
  return celsius.round(2)
end
