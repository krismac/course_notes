# Homework

## Exercise A

### Given the following data structure:

```ruby
stops = [ "Croy", "Cumbernauld", "Falkirk High", "Linlithgow", "Livingston", "Haymarket" ]
```

### Complete these tasks:

1. Add `"Edinburgh Waverley"` to the end of the array
```ruby
stops.push("Edinburgh Waverley")
```
2. Add `"Glasgow Queen St"` to the start of the array
```ruby
stops.unshift("Glasgow Queen St")
```
3. Add `"Polmont"` at the appropriate point (between `"Falkirk High"` and `"Linlithgow"`)
```ruby
stops.insert(4, "Polmont")
```
4. Work out the index position of `"Linlithgow"`
```ruby
stops.index("Linlithgow")
```
5. Remove `"Livingston"` from the array using its name
```ruby
stops.delete("Livingston")
```
6. Delete `"Cumbernauld"` from the array by index
```ruby
stops.delete_at(2)
```
7. How many stops there are in the array?
```ruby
stops.size()
stops.count()
stops.length()
# => 7
```
8. How many ways can we return `"Falkirk High"` from the array?
```ruby
stops[2]
stops.at(2)
stops[-5]
stops.at(-5)
# loads more!
```
9. Reverse the positions of the stops in the array
```ruby
stops.reverse()
```
10. Print out all the stops using a for loop
```ruby
for stop in stops
  p stop
end
```

## Exercise B

### Given the following data structure:

```ruby
users = {
  "Jonathan" => {
    :twitter => "jonnyt",
    :lottery_numbers => [6, 12, 49, 33, 45, 20],
    :home_town => "Stirling",
    :pets => [
    {
      :name => "fluffy",
      :species => "cat"
    },
    {
      :name => "fido",
      :species => "dog"
    },
    {
      :name => "spike",
      :species => "dog"
    }
  ]  
  },
  "Erik" => {
    :twitter => "eriksf",
    :lottery_numbers => [18, 34, 8, 11, 24],
    :home_town => "Linlithgow",
    :pets => [
    {
      :name => "nemo",
      :species => "fish"
    },
    {
      :name => "kevin",
      :species => "fish"
    },
    {
      :name => "spike",
      :species => "dog"
    },
    {
      :name => "rupert",
      :species => "parrot"
    }
  ]
  },
  "Avril" => {
    :twitter => "bridgpally",
    :lottery_numbers => [12, 14, 33, 38, 9, 25],
    :home_town => "Dunbar",
    :pets => [
      {
        :name => "monty",
        :species => "snake"
      }
    ]
  }
}
```

### Complete these tasks:

1. Return Jonathan's Twitter handle (i.e. the string `"jonnyt"`)
```ruby
 users["Jonathan"][:twitter]
```
2. Return Erik's hometown
```ruby
users["Erik"][:home_town]
```
3. Return the array of Erik's lottery numbers
```ruby
users["Erik"][:lottery_numbers]
```
4. Return the type of Avril's pet Monty
```ruby
users["Avril"][:pets][0][:species]
```
5. Return the smallest of Erik's lottery numbers
```ruby
users["Erik"][:lottery_numbers].min
```
6. Return an array of Avril's lottery numbers that are even

	```ruby
	result = []
	for number in users["Avril"][:lottery_numbers]
		result << number if number.even?
	end
	p result
	
	```
	
	Or
	
	```ruby
	def evil_even_numbers(array_of_numbers)
	  result = []
	  for number in array_of_numbers
	    result.push(number) if(number.even?)
	  end
	
	  return result
	end
	
	array = users["Avril"][:lottery_numbers]
	evens = evil_even_numbers(array)
	
	p evens
	```

7. Erik is one lottery number short! Add the number `7` to be included in his lottery numbers
```ruby
users["Erik"][:lottery_numbers] << 7
```

8. Change Erik's hometown to Edinburgh
```ruby
users["Erik"][:home_town] = "Edinburgh"
```

9. Add a pet dog to Erik called "Fluffy"
	
	```ruby
	
	dog = {
	  :name => "fluffy",
	  :species => "dog"
	}
	
	users["Erik"][:pets] << dog
	```

10. Add another person to the users hash

	```ruby
	me =  {
	  :twitter => "tgoncalves",
	  :lottery_numbers => [1, 2, 9, 10, 14, 28],
	  :home_town => "Morningside",
	  :pets => [
	      {
	        :name => "tommy",
	        :species => "cat"
	      }
	    ]
	  }
	
	users["Tony"] = me
	```

## Exercise C

### Given the following data structure:

```ruby
united_kingdom = [
  {
    name: "Scotland",
    population: 5295000,
    capital: "Edinburgh"
  }, {
    name: "Wales",
    population: 3063000,
    capital: "Swansea"
  }, {
    name: "England",
    population: 53010000,
    capital: "London"
  }
]
```

### Complete these tasks:

1. Change the capital of Wales from `"Swansea"` to `"Cardiff"`.
```ruby
united_kingdom[1]["capital"] = "Cardiff"
```
2. Create a Hash for Northern Ireland and add it to the `united_kingdom` array (The capital is Belfast, and the population is 1,811,000).
```ruby
northern_ireland = {
  name: "Northern Ireland",
  population: 1811000,
  capital: "Belfast"
}
united_kingdom.push(northern_ireland)
```
3. Use a loop to print the names of all the countries in the UK.
```ruby
for country in united_kingdom
  p country[:name]
end
```
4. Use a loop to find the total population of the UK.
```ruby
total = 0
for country in united_kingdom
  total += country[:population]
end
# => total = 63179000
```
