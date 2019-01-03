# Homework

## Exercise A

### Given the following data structure:

```ruby
stops = [ "Croy", "Cumbernauld", "Falkirk High", "Linlithgow", "Livingston", "Haymarket" ]
```

### Complete these tasks:

1. Add `"Edinburgh Waverley"` to the end of the array
2. Add `"Glasgow Queen St"` to the start of the array
3. Add `"Polmont"` at the appropriate point (between `"Falkirk High"` and `"Linlithgow"`)
4. Work out the index position of `"Linlithgow"`
5. Remove `"Livingston"` from the array using its name
6. Delete `"Cumbernauld"` from the array by index
7. How many stops there are in the array?
8. How many ways can we return `"Falkirk High"` from the array?
9. Reverse the positions of the stops in the array
10. Print out all the stops using a for loop

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

1. Get Jonathan's Twitter handle (i.e. the string `"jonnyt"`)
2. Get Erik's hometown
3. Get the array of Erik's lottery numbers
4. Get the type of Avril's pet Monty
5. Get the smallest of Erik's lottery numbers
6. Return an array of Avril's lottery numbers that are even
7. Erik is one lottery number short! Add the number `7` to be included in his lottery numbers
8. Change Erik's hometown to Edinburgh
9. Add a pet dog to Erik called "Fluffy"
10. Add another person to the users hash


## Exercise C

### Given the following data structure:

```ruby
united_kingdom = [
  {
    name: "Scotland",
    population: 5295000,
    capital: "Edinburgh"
  },
  {
    name: "Wales",
    population: 3063000,
    capital: "Swansea"
  },
  {
    name: "England",
    population: 53010000,
    capital: "London"
  }
]
```
### Complete these tasks:

1. Change the capital of Wales from `"Swansea"` to `"Cardiff"`.
2. Create a Hash for Northern Ireland and add it to the `united_kingdom` array (The capital is Belfast, and the population is 1,811,000).
3. Use a loop to print the names of all the countries in the UK.
4. Use a loop to find the total population of the UK.
