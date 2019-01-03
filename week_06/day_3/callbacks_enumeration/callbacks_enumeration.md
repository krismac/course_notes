# Callback Functions & Enumeration

**Lesson Duration: 120 minutes**

### Learning Objectives
- Understand the implications of functions being first-class objects
- Be able to interrogate documentation
- Be able to pass functions to higher-order functions
- Be able to use built-in Array enumeration methods

## Introduction

In this lesson we are going to look at the key language features of JavaScript, higher-order functions and callbacks.

A higher order function accepts or returns another function. A callback is a function that is passed to a function as an argument.

Using higher-order functions and callbacks allow us to write more dynamic code and form the foundations of the event-driven programming that we will be doing for the browser later in the course.

Today we are going to be using some of JavaScript's built in higher-order functions that handle iterating over arrays; the enumeration methods.

## Higher-order Functions and Callbacks

We have seen that in JavaScript, functions are first class objects. This means they can be stored in variables and data structures; and passed as arguments to other functions.

A higher order function is a function that takes a function as an argument or returns a function.

A callback is a function that is passed to another function as an argument.

Before we start writing our own higher-order functions, let's look at using some that are built in JavaScript methods.

## Enumeration Methods

We know we can iterate over an array using a `for of` loop, but there are a number of enumeration methods on the Array prototype that enable us to do the same and some offer us extra functionality. These enumeration methods are higher-order functions; they take in a callback which they invoke for each element of the array.

### `forEach`

We have seen that we can loop through an array using the `for of` loop. Let's use it to log out each element of an array.

```sh
touch enumeration.js
```

```js
const numbers = [1, 2, 3, 4, 5];

for (const number of numbers) {
  console.log(`This is number ${number}`)
}
```

We can achieve exactly the same result using the enumeration method `forEach`. `forEach` is a method on the Array prototype and is a higher-order function, in that it takes in a callback as an argument. `forEach` will loop over the array (`numbers`), and for each iteration will invoke the callback, passing the callback the current element (`number`).

```js
// ...

numbers.forEach((number) => {
  console.log(`This is number ${number}`);
})
```

Note: We do not invoke the callback that we pass to `forEach`. We pass the whole function declaration and `forEach` is responsible for invoking it for each iteration of the loop, passing it the current number.

### Using the MDN docs

Look at the documentation for the `forEach` method on the [MDN docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach).

In the documentation, any arguments in square brackets are optional. We can see that `forEach` takes a callback function, and that `forEach` will pass the callback function the current element of the array, and also optionally the current index position.

Let's see how we would modify the message to make use of the element's index position.

```js
numbers.forEach((number, index) => { // MODIFIED
  console.log(`This is number ${number} at index position ${index}`); // MODIFIED
});
```

### Using `forEach` to manipulate an array

We are going to write a function that iterates over the array of numbers and returns a new array with each number from the original array multiplied by two. To do this we are going to use `forEach` to handle the iterating.

We will start by declaring a function that creates a new array and returns it. This is the array we are going to populate with the multiplied numbers.

```js
// ...

const multiplyByTwo = function () { // NEW
  const result = [];

  return result;
}
```

Now we are going to use `forEach` to iterate over the `numbers` array, multiply each number by two, and push the multiplied number into the new array. `forEach` takes a callback function, and it will invoke our callback for each iteration, passing the callback the current element from the array (`number`).

```js
const multiplyByTwo = function () {
  const result = [];

  numbers.forEach((number) => { // NEW

  });

  return result;
}
```

We can now multiply `number` by two and push it into the new array.

```js
const multiplyByTwo = function () {
  const result = [];

  numbers.forEach((number) => {
    const multiplied = number * 2; // NEW
    result.push(multiplied); // NEW
  });

  return result;
}

console.log(multiplyByTwo()); // NEW
```

Now when we run the code, as we have logged out the return value of `multiplyByTwo` we can see we have returned an array with each number multiplied by two.

### Return Value of `forEach`

> Instructor note: Ask the class...

Looking at the docs again, what is the return value of `forEach`?

<details>
<summary>Answer:</summary>
`undefined`
</details>

`forEach` doesn't return a value and we can't return anything from the callback that we pass to it. If we try and return from the callback, we are returning into the `forEach` and as `forEach` is implemented in a way that it doesn't do anything with the return value, for have no way of accessing that value. Instead we have to manually handle the value. In this case we have added the modified element into the previously declared empty array. In this way `forEach` is a direct replacement for a `for` loop.

### Task: (10 minutes)

Using the `forEach` enumeration method, complete the following tasks:

1. Write a function called `getEvens` that returns a new array that only contains the even numbers from the original array.
2. Write a function called `sumElements` that returns the sum total of all the elements of the original array.

**Hint:** If you get stuck, start by writing the function using a `for of` loop, then refactor, replacing the `for` loop with the `forEach`.

<details>
<summary>Example Solution:</summary>

```js
// ...

const getEvens = function () {
  const result = [];

  numbers.forEach((number, index) => {
    if (number % 2 === 0) {
      result.push(number);
    }
  });

  return result;
}

console.log(getEvens());
```

```js
// ...

const sumElements = function () {
  let total = 0;

  numbers.forEach((number) => {
    total += number;
  })

  return total;
}

console.log(sumElements());
```
</details>

### Other enumeration methods (`map`, `filter`, `reduce`)

`map`, `filter` and `reduce` are three commonly used enumeration methods on the Array prototype. They are similar to `forEach`, in that they take a callback and iterate over the array invoking the callback for each element, passing in the element, but they each have some extra inbuilt functionality.

### Paired discussion (5 minutes)

1. Look at the MDN docs and find out the return value of `map`, `filter` and `reduce` and think of a situation when you might want to use each of them.

2. Using what you found out in question one, decide which of these enumeration methods would be useful for which of our functions, `multipleByTwo`, `getEvens`, `sumElements`.

<details>
<summary>Answers:</summary>

1. Return values:
  - `map` returns a new array of the same length as the original array, but with a transformation made to some or all of the elements.
  - `filter` returns a new array containing a subset, or selection, of the original array based on a condition.
  - `reduce` returns a single value. Common examples of using `reduce` is for finding the sum total of all the elements in an array, or finding the largest of all the elements. In both cases we _reduce_ the array down to one value, with `reduce` keeping track of a value while iterating.

2. Use cases:
  - `multiplyByTwo` - `map`. We want to create a new array of the same length as the original with each element transformed (multiplied by two)
  - `getEvens` - `filter`. We want to create a new array which contains a subset of the original array.
  - `sumElements` - `reduce`. We want to keep track of the running total while iterating and return the final total.

</details>

### `map`

Let's refactor `multiplyByTwo` to use `map` to handle the iterating. We know that the return value of `map` is a new array, so we don't need to declare our own empty array. Instead let's store the the array that `map` will return to us in a variable.

```js
const multiplyByTwo = function () {
  const result = numbers.map(); // MODIFIED

  return result;
}
```

`map` takes a callback as an argument.

```js
// ...

const multiplyByTwo = function () {
  const result = numbers.map(() => {}); // MODIFIED

  return result;
}
```

Looking at the MDN docs, what parameter will our callback need, and what does it need to return? It needs a parameter to accept the current element of the array and it must return the value to be added to the new array.

```js
const multiplyByTwo = function () {
  const result = numbers.map((number) => { // MODIFIED
    return number * 2; // NEW
  });

  return result;
}
```

When we run the code, we can see we have returned the array with the numbers multiplied by two.

Note: If we forget to return from the callback, we will get an array of `undefined`s of the same length as the original length.

### `filter`

We are now going to refactor `getEvens` to use the enumeration method `filter`, to filter the original array and return a new array of only even numbers. As `filter` gives us a filtered array, we don't need to declare an empty array. Instead let's store the array that `filter` will return to us in a variable.

```js
// ...

const getEvens = function (){
  const result = numbers.filter(); // MODIFIED

  return result;
}
```

We can see from looking at the MDN docs that filter takes a callback. What parameter will our callback need, and what does the callback need to return?

1. The callback will need a parameter for the current element of the array (`number`)
2. The callback needs to return `true` if we want to keep the element, and `false` it we want to loose it. In this case we return true is the number is even, and false if not.

```js
const getEvens = function (){
  const result = numbers.filter((number) => { // MODIFIED
    return number % 2 === 0; // NEW
  });

  return result;
}
```

We have now used the enumeration method `filter` to return an array of just the even numbers.

### `reduce`

Lastly, we will refactor `sumElements` to use `reduce` to sum all the elements of the original array and return the total. Reduce can be used in many situations as it can keep track of a value while it iterates. In our case we want to keep track of the total.

We will use reduce to return the final total, so we don't need to declare a starting `total`. Instead we will save the return value of `reduce` to a variable.

```js
// ...

const sumElements = function () {
  const total = numbers.reduce(); // MODIFIED

  return total;
}
```

We can see from looking at the MDN docs that reduce takes a callback. What parameter will our callback need?

The callback will need two parameters:

1. An accumulator. This is the parameter that `reduce` uses to keep track of while iterating. In our case it will be the `runningTotal`.
2. The current item in the array (`number`).


```js
const sumElements = function () {
  const total = numbers.reduce((runningTotal, number) => { // MODIFIED

  });

  return total;
}
```

What does the callback need to return? Whatever we return from the callback, will become the accumulator (`runningTotal`) on the next iteration. This is how `reduce` keeps track of a value while iterating. In this case, we want to keep track of the running total, so we will return the `runningTotal` plus the current number. When `reduce` has finished looping, it will finally return `runningTotal`.

```js
// ...

const sumElements = function () {
  const total = numbers.reduce((runningTotal, number) => {
    return runningTotal + number;
  });

  return total;
}
```

Reduce takes a second argument, which is how we set the accumulator (`runningTotal`) for the first iteration. In this case we want it to start as `0`.

```js
// ...

const sumElements = function () {
  const total = numbers.reduce((runningTotal, number) => {
    return runningTotal + number;
  }, 0); // MODIFIED

  return total;
}
```

If we run the code, we can see we have now used `reduce` to sum the elements of the array.

We have seen that `forEach` can be used to achieve the same results as using these enumeration methods, but the benefits of using the enumeration methods with built-in functionality where appropriate include:

- cleaner, more readable and expressive code
- inversion of control - we don't have to worry about the implementation details of how JavaScript `maps`, `filters` or `reduces`


### How are these higher-order functions implemented?

We have used some of JavaScript's enumeration methods, which we know are higher-order functions because they take in a callback. Let's have a look at what they are doing with the callback that we pass to them.

If we were writing our own version of `forEach`, it would need to take in two arguments:

1. The array, because we are not writing this on the Array prototype we need to get access to the array by taking it in as argument.
2. The callback that will be invoked to for each element in the array.

Then we will iterate over the array, invoking the callback, passing in the current element on each iteration.

```js
const ourForEach = function (array, callback) {
  for (const element of array) {
    callback(element);
  }
};

const numbers = [1, 2, 3, 4, 5];

ourForEach(numbers, (number) => {
  console.log('the number is:', number);
});
```

## Recap

What is a higher-order function?

<details>
<summary>Answer:</summary>
A function that takes in another function as an argument, or returns a function.
</details>

What is a callback?

<details>
<summary>Answer:</summary>
A function that is passed to another function as an argument
</details>

What are the benefits of using JavaScripts enumeration methods?

<details>
<summary>Answer:</summary>

- cleaner, more readable and expressive code
- inversion of control - we don't have to worry about the implementation details of how JavaScript `maps`, `filters` or `reduces`

</details>

What do all the enumeration methods take as an argument?

<details>
<summary>Answer:</summary>
A callback
</details>

Do we invoke the callback that we pass to the enumeration method?

<details>
<summary>Answer:</summary>
No. We pass the function definition. The enumeration method is responsible for invoking the callback we pass it.
</details>


What happens if you try and return from the callback that you pass to `forEach`?

<details>
<summary>Answer:</summary>
Nothing. You can't access the value.
</details>

What will be the return value of `map` be if we don't return anything from the callback we pass it?

<details>
<summary>Answer:</summary>
An array of `undefined`s with the same length as the original array.
</details>


## Conclusion

We have written callbacks and passed them to a number of JavaScript enumeration methods, which are higher-order functions.

We started by using `forEach` to iterate over the array, manually creating the value we wanted to return from our function.

After refactoring the code to use `map`, `filter` and `reduce` we achieved the same results, but by using the functionality of these methods we were able to write cleaner more expressive code.
