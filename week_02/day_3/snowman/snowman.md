# Pair Programming Lab - Snowman

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
