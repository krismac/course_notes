# Intro to Pry

> Give out the starter code and ask people to look at it for five mins to see what's going on, but not to run it.

> Run the test and read the error together. `Cake can't be coerced into Integer`, which suggests something isn't what we think it is. There is something that we think is an Integer, but is actually a Cake object.

Until now, when our apps aren't working and our tests aren't passing, we have to print our values to the screen using `p` or worse, `puts` to figure out what is going on in our code.

> Use `p rating` before line 15 of `cake_shop.rb` to demonstrate this

Wouldn't it be nice if we didn't have to do that? There is an alternative, which we'll look at in this lesson:

## Pry

Pry is an alternative to `irb` with syntax highlighting, "pretty printing" of objects and a few other useful features. But it also gives us breakpoints. With pry we can add breakpoints into our code so that when we run our code, it stops executing at the breakpoint and allows us to look around and inspect things that have already been executed.

We can install Pry as a Ruby gem. We'll also install a gem called `pry-byebug` that gives us a handy `next` command, which we'll use later.

```bash
gem install pry pry-byebug
```

If we run our starter code's `cake_shop_spec.rb`, we get an error. Reading the error message we can see that the error actually occurred in `cake_shop.rb`. So we'll use Pry in that file by `require`ing the `pry` gem at the top of the file:

```ruby
# cake_shop.rb
require('pry')
```

If we look again at the error, it will tell us the line number of the error, which is where we do `ratings_sum += rating`. So we'll add a Pry breakpoint just _before_ that line with the following code:

```ruby
# cake_shop.rb
ratings_sum = 0
for rating in @cakes
  binding.pry #NEW
  ratings_sum += rating
end
```

Now when we run the test file we see Pry in the terminal. All the code above the break point has been executed, and we land at a prompt:

```
[1] pry(#<CakeShop>)>
```

Here we can execute normal Ruby code, just like `irb`. We can also type commands, like `ls` to see the methods and variables we have available:

```
[1] pry(#<CakeShop>)> ls
CakeShop#methods: average_cake_rating  cakes
instance variables: @cakes
locals:
  _   _dir_  _file_  _out_  average  ratings_sum
  __  _ex_   _in_    _pry_  rating
```

So if we type `ratings_sum` we get `0`, as we haven't added the individual rating yet.

```
[2] pry(#<CakeShop>)> ratings_sum
=> 0
```

In our loop, we have a variable `rating`. Each iteration through the loop we are adding the `rating` to the counter, `ratings_sum`. We can assume that `rating` should be an Integer. Let's inspect `rating`:

```
[3] pry(#<CakeShop>)> rating
=> #<Cake:0x007fd6aa2ea800
 @ingredients=
  ["chocolate",
   "cocoa powder",
   "flour",
   "eggs",
   "sugar",
   "butter"],
 @name="brownie",
 @rating=5>
```

Uh oh. `rating` is the whole cake object. So when we are trying to add our `rating` to our `ratings_sum`, it's giving us an error because it can't add a `Cake` object to an integer. So our error makes sense: `Cake can't be coerced into Integer`

What are we actually iterating through? We thought we were iterating through the `rating`s, but actually we seem to be iterating through `Cake` objects. Let's inspect `@cakes`.

```
[4] pry(#<CakeShop>)> @cakes
=> [
  # Array of Cake objects
]
```

So our mapping hasn't done anything. That's because we forgot to save our mapping to a variable. Let's save it, updating the variable `@cakes`, as that's what we are iterating through with our loop.

```ruby
def average_cake_rating()

  ratings = @cakes.map { |cake| cake.rating() } #NEW

  ratings_sum = 0
  for rating in ratings #NEW
    binding.pry
    ratings_sum += rating
  end

  average = ratings_sum / ratings.length #NEW

  return average

end
```

Exit from Pry by typing `!!!` at the prompt and run the test again.

Once you have hit the breakpoint you can step through your code, line by line, using `next`. We can step through the code, inspecting the `rating` on each iteration of the loop.

```
[1] pry(#<CakeShop>)> rating
=> 5
```

```
[2] pry(#<CakeShop>)> next
```

```
[2] pry(#<CakeShop>)> rating
=> 4
```

`rating` is an integer, and it seems to be changing with every iteration. That should be enough for enough to pass the test. We can keep using the `next` command to run through every iteration, or we can simply exit Pry with `!!!`, remove the `binding.pry` line from our class and run the tests again.

```
Finished in 0.001079s, 926.7840 runs/s, 926.7840 assertions/s.
1 runs, 1 assertions, 0 failures, 0 errors, 0 skips
```

Success!
