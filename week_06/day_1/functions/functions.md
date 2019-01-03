# Functions

**Lesson Duration: 45 minutes**

### Learning Objectives
- Be able to declare functions
- Understand that functions can be anonymous
- Know the differences between function declarations and anonymous function expressions

## Intro

We've now covered most of the core building blocks of a programming language, but we're still missing a big one: functions. Functions are incredibly useful, they let us split our code up into small, reuseable chunks. Breaking our code up like this lets us build DRY, modular applications. We can give that section of code a meaningful name, making our code more readable and more easily understood.

Let's make a new file to have a look at functions in JavaScript.

```
touch functions.js
atom .
```

## Named Function Declarations

There are a number of ways of declaring a function in JavaScript. First, we'll look at named functions.

To declare the function we use the `function` keyword. This keyword is followed by a name for the function and brackets (`()`). Then braces (`{}`) are used to define the function body. To return a value from our function we use the `return` keyword.

```js
function sayHello() {
  return 'Hello World!';
}
```

We execute the code contained in a function by referring to it by it's name and using brackets `()` to invoke (or call) it: `sayHello()`.

```js
function sayHello() {
  return 'Hello World!';
}
console.log('sayHello message:', sayHello());
// -> sayHello message: Hello World!
```

`sayHello()` gives us back the string `'Hello World!'` when our code runs.

## Arguments & Parameters

We don't always want our functions to output a hard-coded value; often we want the function to take some input, and return a different output depending on what was input. This makes our functions more flexible and let's us reuse our code. Instead of saying 'Hello world!', we might want to take input from the outside world to decide who we say hello to.

What happens when we try to pass an argument to the function as we invoke it?

```js
function sayHello() {
  return 'Hello World!';
}
console.log('sayHello message:', sayHello('Danielle'));
// -> sayHello message: Hello World!
```

We still just get `'Hello World!'`, but that's not too surprising, we haven't named a parameter or done anything with the argument that we passed in. What is a bit surprising is that JavaScript doesn't seem to have a problem with us passing in this unused argument. It's simply ignored, the code runs fine with no errors.

To use the argument inside our function we need to declare a parameter by adding a name for the variable between the brackets (`()`). We can then reference it by name within the function.

```js
function sayHello(name) { // MODIFIED
  return `Hello ${name}!`; // MODIFIED
}

console.log('sayHello message:', sayHello('Danielle'));
// -> sayHello message: Hello Danielle!
```

Now that we're expecting a parameter to be passed, and using it within our function, what happens if we don't pass one in?

```js
console.log('sayHello with no arguments:', sayHello()); // NEW
// -> sayHello with no arguments: Hello undefined!
```

Again, JavaScript doesn't seem to care all that much. No errors, it still runs fine. It just declares an empty parameter that never gets a value passed into it. Our `name`'s value is `undefined`.

### Default Parameters

JavaScript supports default parameter syntax similar to that found in many other languages, meaning we can set a default value to be used if no argument is passed in. Let's set `'World'` as the default value which will be taken by `name` if no value is passed to the function.

```js
function sayHello(name = 'World') { // MODIFIED
  return `Hello ${name}!`;
}

console.log('sayHello with no arguments:', sayHello());
// -> sayHello with no arguments: Hello World!
```

We can add more parameters by listing them between the brackets `()`,  as a comma separated list `,`.

```js
function sayHello(greeting, name = 'World') { // MODIFIED
  return `${greeting} ${name}!`;
}
console.log('sayHello message:', sayHello('Hi', 'Danielle')); // MODIFIED
// -> sayHello message: Hi Danielle!
```

Note: The parameter with a default must be last in the list, so that if only one argument is passed, the argument will be treated as `greeting`, and `World!` with be used as the value for `name`.

### Hoisting

A slightly strange feature of the named `function` declaration is that the `function` declaration is "hoisted". This means that when the JavaScript interpreter parses the code, and just before it actually runs, it essentially moves the function declaration to the top of the file. This means that we can use our function before it is declared.

```js
console.log('sayHello message:', sayHello('Danielle', 'Hi')); // MODIFIED
// -> sayHello message: Hi Danielle!

function sayHello(name = 'World', greeting) { // MODIFIED
  return `${greeting} ${name}!`;
}
```

This can be kind of confusing as it can make the code harder to follow. There is an argument that you should not depend on this hoisting behaviour at all.

[MDN documentation on hoisting](https://developer.mozilla.org/en-US/docs/Glossary/Hoisting)

## Anonymous Function Expressions

We're about to see an incredibly powerful feature of JavaScript, which is a fairly uncommon feature in object oriented programming languages. Functions are first-class objects. This means that, like numbers, strings, arrays or objects, we can store functions in variables, put them in arrays or objects. We can also call methods on functions, pass functions into functions as arguments and even `return` a function from another function.

There's a lot to this aspect of JavaScript, so we'll see more of this in practice later in the module. For now, let's try writing a new function and storing it in a variable.

```js
var add = function (firstNumber, secondNumber) {
  return firstNumber + secondNumber;
}

console.log('1 + 3 with add:', add(1, 3));
// -> 1 + 3 with add: 4
```

This function doesn't look like our named function, `sayHello`, from before. We omitted the name. Since we can store function objects in variables, we can refer to them later by the name of the variable that we store them in, so in this case, the function name is optional. This is called an anonymous function expression.

It's worth noting that anonymous function expressions are not "hoisted", like named `function` declarations.

```js
console.log('1 + 3 with add:', add(1, 3));
// -> TypeError: add is not a function
var add = function (firstNumber, secondNumber) {
  return firstNumber + secondNumber;
}
```

### Task: 20 minutes

1. Declare a **named** function that takes an array of numbers, and returns the sum, or total, of all of the numbers in the array.

2. Define an **anonymous** function expression that takes two arguments:
  - an object, for example, `{ name: 'Wojtek', age: 30 }`
  - a string, for exmaple, `'name'`

  Your function should return `true` if the given string is a `key` on the given object and `false` if the object does not have a key that matches the string. Store this function in an appropriately named variable to invoke it.

<details>
<summary>Example solution</summary>

```js
// Task 1
function calculateTotal(numbers) {
  var total = 0;
  for (var number of numbers) {
    total += number;
  }
  return total;
}

var sum = calculateTotal([10, 40, 200, 50]);
console.log('sum of array of numbers:', sum);
```

```js
// Task 2
var objectHasKey = function (object, searchString) {
  for (var key in object) {
    if (searchString === key) {
      return true;
    }
  }
  return false;
}

var person = {
  name: 'Wojtek',
  age: 30
};

var keyIsFound = objectHasKey(person, 'name');
var keyNotFound = objectHasKey(person, 'email');

console.log('keyIsFound - should be true:', keyIsFound);
console.log('keyNotFound - should be false:', keyNotFound);
```
</details>

## Arrow Functions

There's actually one more way to define functions in JavaScript. Just like with anonymous function expressions, we'll see more and more uses for this as the course goes on, but for now, let's just take a look at the syntax of arrow function expressions.

```js
var multiply = (firstNumber, secondNumber) => {
  return firstNumber * secondNumber;
}

console.log('multiply 2 by 5:', multiply(2, 5));
// -> multiply 2 by 5: 10
```

We omit yet another part of the first named `function` declaration, this time it's the `function` keyword that we're dropping. Instead, an arrow function has a "fat arrow" (`=>`) pointing from the list of parameters in brackets (`()`) to the function body in braces (`{}`). This forms an anonymous function expression: `() => {}`. Arrow functions are _always_ anonymous, they cannot be named. If we want to refer to them later they must be assigned into a variable.

### Implicit Return

When our arrow function's body only contains a single expression, we can write it on one line and omit the `return` keyword and the braces. The function will implicitly return the expression the arrow is pointing to.

```js
var multiply = (firstNumber, secondNumber) => firstNumber * secondNumber; // MODIFIED
console.log('multiply 2 by 5:', multiply(2, 5));
```

`multiply`'s body only has one expression, `firstNumber * secondNumber`, which is evaluated and returned implicitly. This makes writing a simple function very concise.

## Recap

What are the three ways that we can declare functions in JavaScript?

<details>
<summary>Answer</summary>

Three:
1. Named function declarations - `function functionName () {}`
2. Anonymous functions - `var functionName = function () {}`
3. Arrow functions - `var functionName = () => {}`

</details>

What can named `function`s do that anonymous function expressions can't?

<details>
<summary>Answer</summary>

They can be invoked "before" they are defined, as they are [hoisted](https://developer.mozilla.org/en-US/docs/Glossary/Hoisting) to the top of the scope.

</details>

What can arrow functions do that other `function`s can't?

<details>
<summary>Answer</summary>

They can implicitly return an expression by leaving out the function body `{}` and the return keyword. As long as the `=>` points to a single expression.

</details>

## Conclusion

We use functions to organise our code, breaking it up into reuseable blocks, that can take arguments to remain flexible and useful in as many situations as possible. This stop us from writing the same, or very similar code multiple times.

We've also seen three different ways to create functions in JavaScript, and a couple of the differences. We'll see more of these as they become relevant as the course continues.
