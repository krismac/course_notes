# Enumeration

### Learning Objectives

- Understand how Ruby's `for` loop syntax works behind the scenes
- Be able to use Ruby's `Enumerable` methods to process data in an array
- Understand Ruby's block syntax

## Introduction

Coding is a creative exercise, and often there is more than one way to solve a problem. We have done a load of work using one particular tool - the `for` loop - but there is an alternative. Ruby is one of a number of languages (including JavaScript, Scala...) which includes enumeration methods out of the box.

In this lesson, we will explore some of the more useful enumeration methods, but before we do, let's expose a big lie Ruby has been telling you all this time.

## When is a `for` loop not a `for` loop?

Say we have an array of chickens:

```ruby
chickens  = [ "Margaret", "Hetty", "Henrietta", "Audrey", "Mabel" ]
```

We've already seen how we can loop over this array with `for`:

```ruby
for chicken in chickens
  p chicken
end
```

That makes sense, because `chickens` is an array, and `for` each `chicken` in the array, we can do a thing.

What if we messed up? What if we tried to do a `for` loop over something that isn't an array? What if we tried to do a `for` loop over an integer?

```ruby
for chicken in 42
  p chicken
end
```

Obviously that's not going to work, but we get quite a bizarre error message:

```
NoMethodError: undefined method `each' for 42:Integer
```

The error is telling us that Ruby tried to call a method `each` on an integer (42), which it didn't like. There is no method `each` on the `Integer` class.

Wait, `each`?? We never tried to use `each`! What gives, Ruby?

## The `Array#each` Method

`each` is actually a method on the `Array` class. You can read about it [in the docs](https://ruby-doc.org/core-2.4.1/Array.html#method-i-each), but the example syntax uses some language features we haven't encountered yet:

```ruby
# From Ruby 2.4.1 Array docs:
a = [ "a", "b", "c" ]
a.each {|x| print x, " -- " }

# => a -- b -- c --
```

The curly brackets are wrapped around a Ruby feature called a block. In Ruby, a block is a bunch of code which isn't attached to anything. Compare that to a method, which is a bunch of code attached to a class.

But because they're not attached to anything, a block can be passed in to certain methods, like `Array#each`. This takes a bit of getting used to; we've been passing values into methods for nearly two weeks now, but now we are passing _functionality_ into methods.

Within the block we have a couple of pipe characters `|` surrounding a variable name. This variable name is given to every individual item in the array. The rest of the code in the block is then applied to every individual item in the array.

With that in mind, we can refactor our chicken `p`ing code like so:

```ruby
chickens  = [ "Margaret", "Hetty", "Henrietta", "Audrey", "Mabel" ]

chickens.each { |chicken| p chicken }
```

If our block runs over two or more lines, we use the keywords `do` and `end` to wrap the block, instead of `{`curly brackets`}`:

```ruby
chickens  = [ "Margaret", "Hetty", "Henrietta", "Audrey", "Mabel" ]

chickens.each do |chicken|
  shouting_chicken = chicken.upcase()
  p shouting_chicken
end
```

## The `Array#map` Method

Now that we've seen beyond the Ruby `for` loop's **lies**, what else can we use `each` for?

Let's say we wanted to find the lengths of the names of all the chickens, and have that data in an array. We can solve this problem in much the same way as before, but now using `each`:

```ruby
chickens = [ "Margaret", "Hetty", "Henrietta", "Audrey", "Mabel" ]

name_lengths = []
chickens.each {|chicken| name_lengths << chicken.length()}

p name_lengths
# => [8, 5, 9, 6, 5]
```

This is a really common task, as you might have seen in your work already. Often we have a collection of data in one form, and we want to process it somehow and end up with a collection of data in another form.

Ruby actually has a built-in method for this, and extremely useful array method called `map`. It can be called on one array, it performs a code block on each element and then, importantly, returns a new array of the processed data:

```ruby
chickens = [ "Margaret", "Hetty", "Henrietta", "Audrey", "Mabel" ]

name_lengths = chickens.map { |chicken| chicken.length }

p name_lengths
# => [8, 5, 9, 6, 5]
```

## The `Enumerable` Module

The `Enumerable` module is a whole bunch of methods that can be attached to collection classes, including arrays. The reason these methods aren't built into arrays is because the same functionality is desired in a lot of different classes for data types we haven't seen yet, and as we've said, Ruby developers don't like to repeat themselves! For example, next week we will see that the results we get back from a database query belong to a class which implements this `Enumerable` module.

> For the curious, [APIdock provides a non-complete list](https://apidock.com/ruby/Enumerable): ARGF, Row, CSV, DBM, Enumerator, Dir, GDBM, DependencyList, TarInput, SourceIndex, IO, Table, Matrix, Constructive, Prime, PseudoPrimeGenerator, AttlistDecl, Parent, Elements, SyncEnumerator, Element, Range, Set, SDBM, Struct, StringIO, Vector, Socket, GzipReader, Hash, Buffering, Registry, Filter, TaskArguments, Base, Node, Config, Generator, Table, Array

## Useful Enumerable Methods

- `each_with_index` is very similar to `each` but passes the current item and whatever position in the array it was located in:

```ruby
  chickens.each_with_index { |chicken, index| p "#{chicken} is at index #{index}"}
```

- `find` finds the first object that meets the condition in the block:

```ruby
p chickens.find { |chicken| chicken[0] == "H" }
# => "Hetty"
```

- `find_all` (a.k.a `select`) returns a new object (e.g. array) filled with only those original items where the block you gave it returned true:

```ruby
p chickens.find_all { |chicken| chicken[0] == "H" }
# => ["Hetty", "Henrietta"]
```

- `reduce` (a.k.a `inject`) combines all the elements of a collection into one single object, and you define how the elements are combined (e.g. by adding them together)

```ruby
p chickens.reduce { |list, chicken| list + ", " + chicken }
# => "Margaret, Hetty, Henrietta, Audrey, Mabel"
```

`reduce` is usually used with collections of numbers, rather than strings:

```ruby
numbers = [1, 2, 3, 4, 5, 6, 7, 8]
p numbers.reduce { |sum, number| sum + number }
# => 36
```

## Ok, great... Why?

Ruby as a language is designed to appeal to all developers. Remember the quote from Ruby's author, Matz:

> "I hope to see Ruby help every programmer in the world to be productive, and to enjoy programming, and to be happy. That is the primary purpose of the Ruby language."

One of the ways Ruby tries to make every programmer happy is by copying features from other languages, so that using Ruby feels familiar to more experienced developers.

`for` loops are as old as the hills, first appearing in the BASIC language in 1964, with similar constructs appearing in FORTRAN back in 1957. They exist in some form in just about every useful programming language you will encounter.

`each`-style features and enumerable methods tend to be a feature of more modern languages, particularly languages which place a greater emphasis on using functions than on using objects.

From our point of view, Java leans heavily on `for` loop syntax, but JavaScript relies more on `each` style functions. So we will be using both of these styles in the rest of the course. As Ruby developers, we have a choice and it is entirely down to personal preference. Enumerable methods wrap a huge amount of functionality into short, readable code, but do require us to learn a greater vocabulary of methods in order to use them effectively. And so Ruby provides us with the _syntactic sugar_ of a `for` loop.

## Summary

* We have exposed the **lies** at the heart of Ruby's `for` loop, and seen that it calls a method called `each` on whatever object it loops over.
* We have seen blocks for the first time, learned their unique syntax, and seen how to pass them into methods which can use them.
* We have looked into other applications of `each`, defined in the `Enumerable` module.

>[Optional Task/Mini-Lab]:

## Enumerators in Action

> touch a new file called enums_practice.rb and copy start code into slack

```
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

# Print out all of the names using a loop

# Print out all of the names using an enumerable

# Find a pet using a loop and if statement

# Find a pet using an enumerable
```

As can be seen, we have a collection of pet hashes.

- Print out all the names using a loop, then using an enumerable

```ruby
# using a loop

for pet in pets
    p pet[:name]
end
```

```ruby
# using an enumberable

pets.each { |pet| p pet[:name] }
```

- Find a pet using a loop and an if statement, then using an enumerable

```ruby
# loop and if statement

result = nil

for pet in pets
  if pet[:name] == "Tristan"
    result = pet
  end
end

p result
```

```ruby
# using an enumerable

enums_result = pets.find { |pet| pet[:name] == "Tristan" }

p enums_result
```

Now we've made a start, lets have a mini-lab. It's not paired, but feel free to talk amongst yourselves.

Here are the questions:

```ruby
## Task: using enumerable methods:
## 1. Find the pet which breed is Husky
## 2. Make an array of all of the pets' names
## 3. Find out if there are any pets of breed 'Dalmation' (true or false)
## 4. Find the most expensive pet i.e. pet with the highest/maximum price
## 5. Find the total value (price) of all of the pets added together.
## 6. Change each pet so their price is 50% cheaper
```
