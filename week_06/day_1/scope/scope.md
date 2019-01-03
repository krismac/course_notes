# Variable Scope

**Lesson Duration: 45 minutes**

### Learning Objectives

- Understand global, function and block scope
- Know the difference between the `var`, `let` and `const` keywords
- Be able to use `var`, `let` and `const` variable declarations appropriately

## Intro

Variables can help us organise and keep track of data in our code, we give a piece of data a name and can then pass it around and keep track of its value. We've seen that we can declare variables with the `var` keyword, but we haven't talked about the details of how `var` affects the scope of a variable. We're going to take a closer look at variable scoping, how `var` works, and then we'll take a look at two more keywords JavaScript gives us for declaring variables: `let` and `const`.

## Function Scope with `var`

When declaring variables so far we've used the `var` keyword. The `var` keyword declares a variable in the current function's scope. It is only defined within that function, and can't be seen outside it.

Let's make a new file and take a look.

```sh
touch scope.js
```

```js
var secretsFunction = function () {
  var pinCode = [0, 0, 0, 0];
  console.log('pinCode inside secretsFunction:', pinCode);
  // -> pinCode inside secretsFunction: [ 0, 0, 0, 0 ]
}

secretsFunction();
console.log('pinCode outside secretsFunction:', pinCode);
// -> ReferenceError: pinCode is not defined
```

This means that our variables aren't all in the same global scope. When working with globally scoped variables, it can be hard to be sure which variables are relevant to the current task, and we can end up with variable name clashes. Things would get really messy as our applications get larger. `var` saves us from this.

### Lexical Scope

Another cool thing about variable scope in JavaScript is that our functions capture the variables from the parent scope in which they are defined. This is called lexical scope. This means we can access variables from inside the function that are declared outside of the function.

```js
var name = 'Jill'; // NEW
var secretsFunction = function () {
  var pinCode = [0, 0, 0, 0];
  console.log('name inside secretsFunction:', name); // MODIFIED
  // -> name inside secretsFunction: Jill
}

secretsFunction();
console.log('name outside secretsFunction:', name); // MODIFIED
// -> name outside secretsFunction: Jill
```

## Block Scope with `let`

Function scope with `var` isn't always ideal though as it can leave things in our scope that we don't expect. Let's write a function to find names that begin with a certain letter.

```js
var filterNamesByFirstLetter = function (names, letter) {
  var filteredNames = [];
  for (var name of names) {
    if (name[0] === letter) {
      filteredNames.push(name);
    }
  }
  return filteredNames
}

var students = ['Alice', 'Bob', 'Alyssia', 'Artem', 'Babs'];
var filteredStudents = filterNamesByFirstLetter(students, 'A');
console.log('filteredStudents:', filteredStudents);
```

Great, no problems here right? Everything's working as we expect. However, `var` is actually doing something that it probably shouldn't. What should the value of `name` be after the loop, just before we `return`?

```js
var filterNames = function (names, letter) {
  // ...
  console.log('name after loop:', name); // NEW
  // -> name after loop: Babs
  return filteredNames
}
```


`name` was just a temporary variable for storing each name for one iteration of the loop. After the loop has finished it still exists within the scope of our function even though it's not relevant anymore, and is just polluting our scope. This happens because we declared the variable using `var`.
Function scope is not what we want here. We want a variable scoped only to the `for` loop's block `{}`. We want block scope, and to get it, we can use the `let` keyword.

```js
var filterNames = function (names, letter) {
  var filteredNames = [];
  for (let name of names) { // MODIFIED
    if (name[0] === letter) {
      filteredNames.push(name);
    }
  }

  console.log('name after loop:', name);
  // -> ReferenceError: name is not defined
  return filteredNames
}
```

Variables declared with `let` are block scoped. This means they don't exist outside the block (`{}`) that they are declared in. Like function scopes, any further, nested blocks within a certain block scope will be able to access the `let` declared variable. Anything outside the block (similarly to how function scopes work) won't be able to access variable within the block where the `let` variable is declared.

Many people argue that you should never use `var`. Using `let`, you can still create variables that are scoped to a whole function, by declaring them at the "top level" of the function, outside any other blocks. This can often signal your intentions for the variable better than using `var` and its unusual function scoping behaviour.

Instead of using `var` like this:

```js
let isItFive = function (number) {
  if (number === 5) {
    var result = true;
  } else {
    var result = false;
  }
  return result;
}
```

We would use `let` like this:


```js
let isItFive = function (number) {
  let result;
  if (number === 5) {
    result = true;
  } else {
    result = false;
  }
  return result;
}
```

### Paired discussion: 5 minutes

Read the following code. Discuss it in pairs or small groups.

Without running the code, try to figure out what the value of the `console.log`ed variables will be.

```js
let temperature = 30;

if (temperature > 15) {
  let jacket = false;
  var happy = true;
} else {
  let jacket = true;
  var happy = false;
}

console.log('jacket after if-else blocks:', jacket);
console.log('happy after if-else blocks:', happy);
```

<details>
<summary>Answer</summary>

1. ReferenceError: jacket is not defined
2. happy after if-else blocks:, true);

</details>

## Constants with `const`

Sometimes we don't ever intend for a variable to change. These types of value are referred to as constants. JavaScript provides yet another way to declare variables, for constants we can use `const`. The scope of `const` variables is block scoped just like `let`.

```js
let calculateEnergy = function (mass) {
  const speedOfLight = 299792458;
  return mass * speedOfLight ** 2;
}

let energyOfMe = calculateEnergy(75);
console.log('energyOfMe (if I had a mass of 75kg)', energyOfMe);
// -> energyOfMe (if I had a mass of 75kg) 6740663840526132000
```

The speed of light is a constant, we don't want to be changing it during our function. The `const` keyword will help us out by throwing an error if we try to reassign to that variable. If we set it to `0`, set it to itself multiplied by 2, or even if we increment it by `1` with the `++` operator it will give the error, `TypeError: Assignment to constant variable.`.

```js
let calculateEnergy = function (mass) {
  const speedOfLight = 299792458;
  speedOfLight++ // NEW
  // -> TypeError: Assignment to constant variable.
  return mass * speedOfLight ** 2;
}

let energyOfMe = calculateEnergy(75);
console.log('energyOfMe (if I had a mass of 75kg)', energyOfMe);
```

We have to remove any code which reassigns the value of `speedOfLight` in order to make our code run at all.

```js
  // speedOfLight++ // MODIFIED
```

There are a couple more variables in this code that we never want to reassign. What happens if we allow our function assignment by reassigned?

```js
let calculateEnergy = function (mass) {
  const speedOfLight = 299792458;
  // speedOfLight++
  return mass * speedOfLight ** 2;
}

calculateEnergy = () => 0
let energyOfMe = calculateEnergy(75);
console.log('energyOfMe (if I had a mass of 75kg)', energyOfMe);
// -> energyOfMe (if I had a mass of 75kg) 0
```

We probably shouldn't allow our function to be reassigned now that we can prevent it. The same is true of the `energyOfMe` variable, why would we want to let it change? We get the result of the function, and all we do with it is `log` it out, we don't want it to change.

```js
const calculateEnergy = function (mass) { // MODIFIED
  const speedOfLight = 299792458;
  // speedOfLight++
  return mass * speedOfLight ** 2;
}

// calculateEnergy = () => 0 // MODIFIED
const energyOfMe = calculateEnergy(75); // MODIFIED
console.log('energyOfMe (if I had a mass of 75kg)', energyOfMe);
```

`const` isn't going to let us make this mistake. Generally, using `const` as much as possible makes our code more robust and less prone to another developer (or ourselves) accidentally changing something that shouldn't be changed.

However, `const` has its limitations. It _only_ prevents us from reassigning to the constant variable. It won't stop us modifying any mutable objects that are declared with `const`.

```js
const song = {
  title: 'Raspberry Beret',
  artist: 'Prince'
};

console.log('song before mutation', song);
song.title = 'When Doves Cry';
console.log('song after mutation', song);

const songs = [
  song,
  'Happy Birthday',
  'Hey Jude'
];

console.log('songs array before mutation', songs);
songs[1] = 'Call Me Maybe';
songs.pop();
console.log('songs array after mutation', songs);
```

`const` still prevents us accidentally reassigning the variable to a totally new object, so we still want to use it for mutable objects as well as [immutable](https://en.wikipedia.org/wiki/Immutable_object) values like `number`s and `string`s.

## Global Scope

If we don't use one of the key words (`var`, `let` or `const`) when declaring a variable, it will be in global scope, and available everywhere.

```js
const helloWorld = function () {
  result = "Hello World!";
}

helloWorld();
console.log(result);
// -> "Hello World!"
```

Polluting the global scope in this way is bad practice. We should always use a key word when declaring a variable.

## Recap

What is the difference between `let` and `const`?

<details>
<summary>Answer</summary>
`const` variables cannot be reassigned later in the program.
</details>

What are the respective scopes of `var`, `let` and `const` declared varaiables?

<details>
<summary>Answer</summary>

- `var`: function scope
- `let`: block scope
- `const`: block scope

</details>

What does `const` not prevent us from modifying?

<details>
<summary>Answer</summary>

The contents of any mutatable objects, like arrays or objects. `const` **only** prevents reassignment to the variable.

</details>

## Conclusion

Now we know the different behaviours and uses for `var`, `let` and `const`, we can make our code safer and less prone to mistakes. We can avoid `var`s unusual function scoping, and avoid accidental reassignments with `const`.

Broadly speaking, when defining a variable, use `const`. If you need to reassign that variable's value, switch to `let`. `var` is only actually appropriate in rare circumstances. So we're not going to see it much from this point on.
