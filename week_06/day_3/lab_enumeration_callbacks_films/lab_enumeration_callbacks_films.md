# Enumeration and Callbacks Lab: Cinema

**Lab Duration: 90 minutes**

### Learning Objectives

- Be able to pass functions to higher-order functions
- Be able to use built-in Array enumeration methods

## Brief

You have been given a project with two models, `Cinema` and `Film`, and their corresponding test files.

A Film has:

- a title
- a genre
- a year
- a length

A Cinema has:

- an array of `Film`s

You should write the code to make the Cinema tests pass. You should use JavaScript's built-in enumerator methods, only using `forEach` if you can't find a way to use one of the other more appropriate methods.

Hint: You may want to explore other enumeration methods from the MDN documentation. For example, `find` works very similarly to `filter`, but rather than returning an array of items that match a condition, it returns the first item. Other useful methods include `some` and `every`.

### MVP

Cinema:

- should have a collection of films
- should be able to get a list of film titles
- should be able to find a film by title
- should be able to filter films by genre
- should be able to check whether there are some films from a particular year (`true`/`false`)
- should be able to check whether all films are over a particular length (`true`/`false`)
- should be able to calculate total running time of all films

### Extensions

Add a another test, `'Cinema should be able to filter films by year'`.

We already have a method that filters films by genre, the functionality of which is very similar. We don't want two separate methods as that wouldn't be DRY. Your task is get the final test to pass by to writing a new method called `filmsByProperty`, which takes two arguments:

1. the name of the property
2. the value being search for

Once the final test is passing, modify the test `'Cinema should be able to filter films by genre'` to use the new `filmsByProperty` method.

### Consideration

If you use reduce, remember that you will need to pass in the initial value of the accumulator as the second argument.
