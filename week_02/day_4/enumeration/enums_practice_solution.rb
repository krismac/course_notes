pets = [
{
    name: "Sir Percy",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
},
{
    name: "King Bagdemagus",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
},
{
    name: "Sir Lancelot",
    pet_type: :dog,
    breed: "Pomsky",
    price: 1000,
},
{
    name: "Arthur",
    pet_type: :dog,
    breed: "Husky",
    price: 900,
},
{
    name: "Tristan",
    pet_type: :dog,
    breed: "Basset Hound",
    price: 800,
},
{
    name: "Merlin",
    pet_type: :cat,
    breed: "Egyptian Mau",
    price: 1500,
}
]

## Print out all of the names using a loop
for pet in pets
    p pet[:name]
end

## Print out all of the names using an enumerable
pets.each { |pet| p pet[:name] }

## Find the pet named "Tristan" using a loop and if statement
result = nil

for pet in pets
  if pet[:name] == "Tristan"
    result = pet
  end
end

p result

##Find the pet named "Tristan" using an enumerable
enums_result = pets.find { |pet| pet[:name] == "Tristan" }

p enums_result


## Using enumerable methods:
## 1. Find the pet which breed is Husky

enums_result = pets.find { |pet| pet[:breed] == "Husky" }

p enums_result

## 2. Make an array of all of the pets' names
names_array = pets.map {|pet| pet[:name]}

p names_array
## 3. Find out if there are any pets of breed 'Dalmation' (true or false)

# .find is always useful when trying to find one item in an array
p pets.find {|pet| pet[:breed] == 'Dalmation'}

# .any? is built specifically for this situation, just checking if something exists or not
p pets.any? {|pet| pet[:breed] == 'Dalmation'}


## 4. Find the most expensive pet i.e. pet with the highest/maximum price

# .max is pretty handy, but confusing syntax (introduced in ruby version 2.4)

# p pets.max {|current_pet, next_pet| current_pet[:price] <=> next_pet[:price] }

# If we couldn't use max, we would have to do a few different things together
prices = pets.map {|pet| pet[:price]}
sorted = prices.sort {|a, b| b <=> a }
high_price = sorted.first
expensive_pet = pets.find {|pet| pet[:price] == high_price}
p expensive_pet

## 5. Find the total value (price) of all of the pets added together.

#there's two ways we could do this...

# You could map and then reduce, a common pattern:
prices = pets.map {|pet| pet[:price]}
p prices.reduce {|total, price| total + price}
# Note: Ruby 2.4 has .sum which is a shortcut for this reduce call

#  or do it on 1 line
p pets.reduce(0) {|total, pet| total + pet[:price]}
# Passing an argument to reduce sets this value, 0, as the initial value of the accumulator (the first parameter to the block - 'total' in this case)

## 6. Change each pet so their price is 50% cheaper

pets.each {|pet| pet[:price] /= 2}
p pets

# Note: this will modify the original
