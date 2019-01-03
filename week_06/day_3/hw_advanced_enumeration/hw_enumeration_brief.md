# Enumeration Homework

### Learning Objectives

- Be able to pass functions to higher-order functions
- Be able to use built-in Array enumeration methods

## Brief

You have been given four projects, each containing a coding problem. You should write the code to make the tests pass, without modifying the spec files. You should use JavaScript's built-in enumerator methods where appropriate.

You should attempt to make your code as clean as possible. You don't have to do all the work in the function that's being called in the test. Don't be afraid to attach little helper functions to the provided prototype.

Note: For now, make sure you use arrow functions for your callbacks to avoid problems with context. We will be looking more at the differences between function declaration types soon.

## UPPERCASER

`map` an array of strings to a new array containing uppercase versions of each string.

## Pangram Finder

A pangram is a sentence or phrase which contains every letter of the alphabet. "The quick brown fox jumps over the lazy dog." is probably the most notable pangram in English.

Given a sentence or phrase you should be able to determine whether or not `every` letter of the alphabet is included in it.

## Isogram Finder

An isogram is a word, phrase or sentence that does not contain any repeated letters. "Orange" is an isogram but "Banana" is not.

Given a word, phrase or sentence you should be able to determine whether or not it is an isogram. That is, you should be able to determine whether `every` letter is unique.

## Extension: Anagram Finder

An anagram is a word formed by rearranging the letters of another word. Listen is an anagram of silent, for example.

Given a word and an array of other words you should be able to `filter` the array, leaving only the anagrams of the word in question in the array.
