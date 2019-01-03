# Pair Programming Lab - Pub or Snowman!

Choose a brief that you and your pair programming partner is going to build!

Work one one laptop and Git commit regularly!

Remember to use TDD.

## Pub

In pairs, plan and create an object oriented model of a Pub, with Drinks and Customers!

MVP:
  - A `Pub` should have a `name`, a `till`, and a collection of `drinks`
  - A `Drink` should have a `name`, and a `price`
  - A `Customer` should have a `name`, and a `wallet`
  - A `Customer` should be able to buy a `Drink` from the `Pub`, reducing the money in its `wallet` and increasing the money in the `Pub`'s `till`

Extensions:
  - Add an `age` to the `Customer`. Make sure the `Pub` checks the `age` before serving the `Customer`.
  - Add `alcohol_level` to the Drink, and a `drunkenness` level to the `Customer`. Every time a `Customer` buys a drink, the `drunkenness` level should go up by the `alcohol_level`.
  - `Pub` should refuse service above a certain level of `drunkenness`!

Advanced extensions:
  - Create a `Food` class, that has a `name`, `price` and `rejuvenation_level`. Each time a `Customer` buys `Food`, their `drunkenness` should go down by the `rejuvenation_level`
  - Pub can have a `stock` (maybe a Hash?) to keep track the amount of `drinks` available (Hard! Might need to change the drinks array to a drinks hash)
  - Pub can have a `stock_value` method to check the total value of its `drinks`


## Snowman

In pairs, plan out, build and test an object oriented implementation of the word guessing game Snowman.

 - A player has 6 chances to guess a hidden word.
 - Each incorrect guess will melt part of the snowman. A player wins when they guess the word and lose when they run out of lives and the snowman melts.

## MVP

* A `Game` will have properties for a `Player` object, a `HiddenWord` object, and an array of `guessed_letters`
* A `Player` will have a `name` and number of `lives`
* A `HiddenWord` will be initialised with a `word` string, but will only `display` letters which have been correctly guessed, replacing the rest with the `*` character
* The `HiddenWord` should also be able to report `true` or `false` if a letter appears in the `word`

## Extension - `Game` logic

* The `Game` should be able to pass a single letter to a `HiddenWord` as a guess
* It should store these single letters in its `guessed_letters` array
* It should be able to subtract a life from a `Player` if the guess is incorrect
* It should be able to tell whether the game `is_won?` or `is_lost?`

## Advanced Extension

* Make a `Runner` file to run the game in Terminal:
  * Ask a user to input a secret word
  * Hide the secret word from the player <- *Hint: research how to clear the Terminal screen in Ruby*
  * Play the game! Collect guesses typed in by the player, process guesses with your `Game` methods, and display appropriate messages to turn your classes into a working game!

## Rules of Snowman

A user enters a word or phrase:

```
wheel of fortune
```

This is then hidden or obscured, and presented to the player:

```
***** ** *******
```

The player guesses "e", and the letter is revealed:

```
**ee* ** ******e
```

The player guesses "x" and loses a life.

The player guesses "f" and its position is revealed, along with the "e" previously guessed:

```
**ee* *f f*****e
```
