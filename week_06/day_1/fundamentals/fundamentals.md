# JavaScript Fundamentals

**Tutorial Duration: 60 minutes**

### Learning Objectives

- Be able to declare variables
- Understand the differences between data types
- Be able to write conditionals
- Understand the concept of truthy and falsy values and it's uses
- Know the truthy and falsy values
- Understand the equality operators

## Introduction

When learning a new programming language there are a number of key things to be aware of. These include:

- whether it is dynamically or statically typed
- what the data types are
- whether it is weakly or strongly typed
- the truthy and falsy values

In this lesson we are going to look at what we mean by these terms and how they apply to JavaScript so that we are able to write programs knowing what the expected behaviour of the language is.

## Running a JavaScript file in Node

Create a file called js_fundamentals.js. We can use the console's `log` method to output a value.
> Note: Run the file with the command `node js_fundamentals.js`.

```js
// js_fundamentals.js

console.log("Hello World!");
```

We can run the file using Node.

```sh
node js_fundamentals.js
```

## Variables

JavaScript, like other programming languages, allows us to declare variables and assign values to them, so that we can reference them later.

We declare variables using the keyword `var`. Let's create a variable `name` with the value "Mickey":

```js
var name = "Mickey";
console.log("name:", name);
// -> name: Mickey
```

> It's good practice to pass a string label to `console.log()` as the first argument to more easily identify the output.

### Semicolons

Notice that we end each line with a semicolon to tell the JavaScript runtime that it has reached the end of our statement.

JavaScript has a feature called automatic semicolon insertion which means that semicolons are optional for the most part. We will be writing our semicolons manually for the duration of this course however, as it's important to know where they do and don't belong.

### Dynamic Typing

Dynamically typed languages type check at run time, in contrast to statically typed languages which type check at compile time. Type checking is the verification of a value's type, so that the environment can determine which operations are safe or unsafe. For example, whether or not it is safe to call a particular method on it.

Knowing that JavaScript is dynamically typed, what would we expect to happen if we reassign the value of the following variable, `greeting`, to be a number?

```js
var greeting = "hello";
```

<details>

<summary>
Answer
</summary>

The JavaScript runtime will decide which type to use when the code runs. So while the value of `greeting` is initially a string, it can be reassigned to be a number.

```js
var greeting = "hello";
greeting = 5;
console.log(greeting);
// -> 5
```

</details>

## Data Types

Can you think of any reasons why it's important to know which data type we are dealing with?

<details>

<summary>Answer</summary>

- So that we know which methods and properties we have available to call on variables and values
- So we know which operators we can use. As demonstrated in the following example, we can use the addition operator (`+`) when dealing with string types, but not the subtraction operator (`-`), which gives us `NaN` (Not-A-Number). More on that later.

```js
"hello" + " world!";
// -> "hello world!

"hello" - "h";
// -> NaN
```

</details>
<br>

JavaScript has a number of primitive data types:

- number
- string
- null
- undefined
- boolean
- symbol

In JavaScript we can always check the data type of a value using the `typeof` operator, which returns the type of a value as a string.

```js
typeof "hello";
// -> string
```

JavaScript wraps up primitive values in objects so we are able to call methods on them.

```js
"no way!".toUpperCase();
// -> NO WAY!
```

### Number

Number is the only numerical data type in JavaScript. It does not differentiate between whole and decimal numbers.

```js
typeof 1;
// -> 'number'

typeof 1.5;
// -> 'number'
```

The standard arithmetic operators are available to us:

 - Addition `+`

```js
1 + 2;
// -> 3
```

 - Subtraction `-`

```js
1 - 2;
// -> -1
```

- Multiplication `*`

```js
2 * 2;
// -> 4
```

- Division `/`

```js
4 / 2;
// -> 2
```

- Exponentiation `**`

```js
2 ** 3;
// -> 8
```

- Remainder `%`

```js
3 % 2;
// -> 1
```

### String

Strings can be declared with:

- double quotation marks (`"`)
- single quotation marks (`'`)
- backticks (`` ` ``)

We can also use the `String()` function to convert non-string values to strings.

```js
String(5);
// -> '5'
```

We can use the `+` operator to concatenate strings.

```js
var name = "Minnie";
"Hello, " + name;
// -> 'Hello, Minnie'
```

Using backticks to declare a string allows us to use string interpolation.

```js
var name = "Donald";
`Hello, ${name}`;
// -> 'Hello, Donald'
```

A full list of string methods can be found here:
[MDN docs: String](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String)

### Null

The `null` value is used when a value is deliberately absent. A database might return `null` if you are trying to fetch a record that doesn't exist or you might return `null` from a search function when it finds no matches.

### Undefined

Undefined is the default value and type of declared variables where no value has been assigned.

```js
var myVariable;

myVariable;
// -> undefined

typeof myVariable;
// -> 'undefined'
```

`undefined` is different from `ReferenceError`, which is the error we get when trying to use a variable that hasn't been declared.

```js
bananas;
// -> ReferenceError: bananas is not defined
```

`NaN` is Not-A-Number. It is of type of number but has no numerical value. We get `NaN` when we perform some illegal mathematical operations. A numerical value `+ undefined` is probably the most common operation that results in `NaN`. This might happen if you try to access a value that you believe is a number but is actually `undefined`.

```js
undefined + 1;
// -> NaN
```

### Boolean

A `Boolean` has one of two values, either true or false. Like in other languages the key role of the `Boolean` values is for control flow.

### Symbol

In newer versions of JavaScript, we have a new type of primitive: `Symbol`. They are not widely used yet, and you will see them far less frequently than the other types of primitive we have looked at.

They function quite differently from symbols that you might have seen in other languages. In JavaScript, they are primarily used to create unique keys within key-value pairs.

## Control Flow

### Conditionals

As with other programming languages, JavaScript allows us to write conditionals. This is the syntax for the `if` statement:

```js
// if (first expression) {
//   statement to run if first expression evaluated as true
// }
// else if (second expression) {
//   statement to run if second expression evaluated as true
// }
// else {
//   statement to run if all other expressions evaluated as false
// }

if (1 > 0) {
	var message = "1 is greater than 0";
} else if (1 == 0) {
	var message = "1 is equal to 0";
} else {
	var message = "1 is not greater than 0";
}
```

### Short-circuiting

JavaScript employs short-circuiting. This means that in the above `if` statement, as the first condition is satisfied, the `else if` and `else` conditions and associated code blocks are never executed.

### Truthy and Falsy Values

While we know that the boolean values are true or false, we often want to evaluate a non-boolean value as true or false when working with control flow. For example, as an `if` statement expects a boolean value as its condition, whatever you pass to it will be coerced to either `true` or `false`. `null` is a falsy value so will be coerced to `false`.

```js
if (null) {
	var result = 'The expression evaluates to true.';
} else {
	var result = 'The expression evaluates to false.';
}
```

When we are learning a language we need to know which expressions and non-boolean values evaluate as `true` and which evaluate as `false`. The result of these evaluations are called the 'truthy' and 'falsy' values and are different for different languages.

### Task: (5 minutes)

We can convert from any value to a boolean with the Boolean function, `Boolean()`. For example:

```js
Boolean(null);
// -> false
```

Run the following in the Node REPL, use the Boolean function check out the truthy and falsy values:

- a string
- `''` (an empty string)
- `0`
- a number other than zero
- `undefined`
- `NaN`

> Note: To enter the Node REPL run the command 'node' in the terminal.

What are the falsy values in JavaScript?

<details>

<summary>Answer</summary>

- `0`
- `''` (an empty string)
- `NaN`
- `undefined`
- `null`

Everything else is coerced to true.

</details>
<br>

As these values are falsy, we can easily identify them using control flow and prevent them being displayed to the user where appropriate.

## Weak (or Loose) Typing

JavaScript is a weakly typed language, which means it makes implicit conversions (or coercions) between data types at run time.

### Task: (5 minutes)

Run the following in the Node REPL to see the results of JavaScript's type coercion:

1. `3 + “hello”`
2. `"route" + 6 + 6`
3. `6 + 6 + “route”`

When we attempt to perform operations that act on values of different types JavaScript will coerce one or more of them to a different type in order to make it work.

## Equality

### Types of Equality

Let's look at how some other expressions evaluate in JavaScript:

```js
2 == 2;		// -> true
2 == "2";	// -> true
2 === "2";	// -> false
```

The equivalent 'not equal' operators are != and !== respectively.

```js
2 != 2;		// -> false
2 != "2";	// -> false
2 !== "2";	// -> true
```

### Strict Equality (`===`)

The triple equals (strict equality) operator compares for equality by checking if both the type and value are the same.

### Loose Equality (`==`)

The double equals (abstract or loose equality) operator compares for equality *after* having coerced the values to a common type. This is a product of JavaScript being a weakly typed language, as previously discussed.

Because loose equality can cause unexpected behaviour, unless you have a good reason, it is good practice to use the triple equals (`===`), which only evaluates to true if both the value and the type match.

### Logical Operators

We can use the logical operators 'and' (`&&`) and 'or' (`||`) to make logic expressions.

```js
(1+1 === 2) && (1+1 === 4); // -> false
(1+1 === 2) || (1+1 === 4); // -> true
```
We can also use `!` for "not".

```js
!true;
// -> false
```

Short-circuiting also applied to the logical operators. This means that if the first expression in an `&&` statement evaluates to false, JavaScript does not bother evaluating the second expression, because the statement will evaluate to false regardless.

Similarly, if the first expression in an `||` statement is true, JavaScript does not bother evaluating the second expression, because the statement will evaluate to true regardless.

## Recap

1. What syntax has to be used to declare a string when using string interpolation?
2. What are the falsy values in JavaScript?
3. What does `!0` return?
4. What does `!0 && !1` return?
5. Why is it better practice to use the strict equality operator (`===`) over the loose equality operator (`==`)?

<details>

<summary>
Answers
</summary>

1. To use string interpolation, we have to declare string with backticks.
2. falsy values:
	- 0
	- '' (an empty string)
	- NaN
	- null
	- undefined
3. `!0` evaluates as true
4. `!0 && !1` evaluates as false
5. Because strict equals checks that both the type and value match, and avoids unexpected behaviour due to type coercion.

</details>
<br>

## Conclusion

In this lesson we saw how to write the basic syntax of JavaScript. We looked at JavaScript's data types and now know it's common truthy and falsy values.

We have learnt that Javascript is a dynamically and weakly typed language, meaning that type checking happens at run time and it performs implicit data type conversions. This prevents us from having to declare the types of our variables up front and means that we can reassign them to values of different types.

## Further Resources

[JavaScript Equality Table](https://dorey.github.io/JavaScript-Equality-Table/)

[Mozilla JavaScript Docs](https://developer.mozilla.org/bm/docs/Web/JavaScript)
