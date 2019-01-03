# Test-Driven Development Using Assert and Mocha

**Duration: 75 minutes**

## Learning Objectives
- Be able to write basic tests using Node's Assert module
- Be able to write unit tests using Assert in combination with Mocha
- Be able to run test files with Mocha using an npm script

## Intro

We've learned the fundamentals of JavaScript and we're able to use them to write some fairly robust code, but how can we be sure that our code works?

We could use `console.log()` to verify that our functions have the expected output, but then our code would be littered with redundant statements that aren't relevant to its functionality.

We could remove those `console.log()`s once we're satisfied that our code works, but then how would we test that our code still works if we were to refactor it?

Unit tests to the rescue!

## Assert

Node ships with a basic testing module out of the box which we can use to unit test our code. This module provides us with a set of assertion methods that can be used for testing.

These testing tools are quite primitive, in that they don't offer much functionality, and are usually used in tandem with a testing framework like Mocha as a result.

We'll begin by taking a look at Node's Assert module on it's own so that we can get a feel for how it works before we start using it with a testing framework.

## Writing Tests with Assert

The first thing that we'll need to do is create a .js file to work in.

```sh
touch play.js
```

Node ships with the `assert` module out of the box, but if we want to use it then we have to `require` it.

```js
// play.js

const assert = require('assert');
```

Now we're ready to start writing some basic tests.

### `assert.equal()`

Now that we have access to the `assert` module, we can use any of the methods that come with it. We can use the `equal()` method to check if two values are the same, just like you might have done when unit testing in other languages.

```js
assert.equal(true, true);
```

We can then run our tests in the same way that we would run any other .js file.

```sh
node play.js
```

Notice that we don't get any feedback at all. This isn't ideal. Node will only tell us if our tests are failing. Let's break our test and see what happens.

```js
assert.equal(true, false);
```

```sh
node play.js

# -> AssertionError [ERR_ASSERTION]: true == false
```

>Note: Assert will only show us one failing test at a time. Comment out any failing tests before moving on

This is better than nothing but it isn't very descriptive or expressive.

Another potential issue that we could encounter when using  `equal()` is that, as we can see from the above AssertionError, it uses JavaScript's abstract equality operator (`==`).

If the two parameters are of different types then JavaScript will first try to find a common type for them before determining whether or not they are equal.

The following test will convert the string `'1'` to a numerical value before performing a strict comparison on them, deciding that they are equal and passing.

```js
assert.equal(1, '1');
```

Just like using the abstract equality operator (`==`) elsewhere in our code this can lead to unexpected behaviours, such as the following test passing.

```js
assert.equal([], ![]);
```

We should be as specific as possible when testing therefore avoid using `equal()`.

### `assert.strictEqual()`

Assert gives us another method, `strictEqual()`, which uses JavaScripts strict equality operator (`===`). As a general rule of thumb we should use that instead of `equal()` so that we can be certain that our tests are passing or failing for the right reasons.

The following test will fail.

```js
assert.strictEqual(1, '1');
```

```sh
node play.js

# -> AssertionError [ERR_ASSERTION]: 1 === '1'
```

The two values are not strictly the same so this is typically the desired behaviour of our tests.

There is one more thing that we need to know when writing our assertions with Assert: when comparing objects using `equal()` or `strictEqual()` JavaScript will check if they are the same object.

The following test will fail as a result of this.

```js
assert.strictEqual([1, 2, 3], [1, 2, 3]);
```

The arrays look the same but they aren't physically the same array.

The following test, however, will pass because both variables refer to the exact same array.

```js
const firstArray = [1, 2, 3];
const secondArray = firstArray;
assert.equal(firstArray, secondArray);
```

### `assert.deepEqual()` and `assert.deepStrictEqual()`

Assert gives us another set of methods; `deepEqual()`  and `deepStrictEqual()`. These methods look at the values contained within the object and use those to determine if the objects are equal, rather than checking if the object are the same object.

The following test will pass because even though the first and second parameters are not the same array they contain values which are equal.

```js
assert.deepEqual([1, 2, 3], [1, 2, 3]);
```

Similarly to `equal()`, `deepEqual()` uses JavaScript's abstract equality operator (`==`). We can mix `String`s and `Number`s and the test will still pass.

```js
assert.deepEqual([1, 2, 3], ['1', '2', '3']);
```

We can use `deepStrictEqual()`, which uses JavaScript's strict equality operator (`===`) to avoid this behaviour. The following test will fail because the contents of the array are not strictly the same values.

```js
assert.deepStrictEqual([1, 2, 3], ['1', '2', '3']);
```

```sh
node play.js

# -> AssertionError [ERR_ASSERTION]: [ 1, 2, 3 ] deepStrictEqual [ '1', '2', '3' ]
```

Third-party assertion libraries are available if you need something more fully featured but Assert should be able to take care of all of our needs for the time being.

## Mocha

Node's built in assert module is very basic as you can see. It gives us some methods that we can use to test our code but that's all. It doesn't even tell us if our tests are passing. If we only used `assert` to test our code then our test files could quickly become an unintelligible mess of calls to `equal()` unless we wrote our own testing framework to organise them.

Mocha has some nice features that help us to organise our tests and gives us much more readable and descriptive output.

## Writing Unit Tests With Mocha and Assert

Now that we've seen how some of the methods that we can get from Assert work, let's create a model, employing TDD, and look at how we can use Mocha to better organise and run our tests.

Before we do, it's worth mentioning that Mocha supports a number of different syntaxes. The type we're going to use is _Behaviour Driven Development_, or BDD.

BDD is an extension of TDD which attempts to focus on the user, and the product. Tests written in a BDD style will follow the format "It should...", and they should tie in closely to the user stories that you or your UX colleagues should have written.

> (As a... I want to... So that...)

The first thing that we'll need to do is create some files to work in. We're going to model a taxi, so we'll need a file for our `Taxi` model and corresponding spec file. We typically create a specs folder to keep our tests organised separately from our models and name our test files the same as our models with a \_spec suffix. For example, the test file for our taxi model will be called taxi_spec.js.

```sh
touch taxi.js
mkdir specs
touch specs/taxi_spec.js
```

We're going to be using Mocha to write and run our tests, so we have to install it using npm.

We'll use Mocha during development but our tests aren't necessary to actually run our application, so we'll save Mocha as a dev dependency.

If someone was to then clone our project with the intention of running it without modifying the code, they could use `npm install --production` to avoid installing our dev dependencies.

```sh
npm init
npm install --save-dev mocha
```

We have a test file and we've installed Mocha, so now we have everything that we need. How do we run our tests?

We want to use Mocha to run all of the files in our specs folder.

```sh
mocha specs

# -> zsh: command not found: mocha
```

We installed Mocha as a dependency of our project, but our Terminal has no idea what Mocha is.

There are a few ways that we could solve this problem: we could install Mocha globally, which would allow us to use this command, but then if another developer were to try to run our code then they would have to install Mocha too. Instead we can use an npm script to tell npm to run our tests with Mocha. We installed Mocha using npm, so npm knows what Mocha is.

We can create npm scripts by adding a name to refer to them by and the command that we want to execute as a key-value pair to the `"scripts"` object in our package.json.

npm expects us to have a `"test"` script, so it provides one by default. We can then update it's value so that it runs our tests for us.

```js
// package.json

"scripts": {
  "test": "mocha specs" // UPDATED
},
```

Now that we've added our npm script we can run it using `npm test` while we're at the same level as our package.json.

```sh
npm test

# -> 0 passing
```

When we run `npm test` npm looks at the scripts that we have defined in our for the key `"test"`, when it finds it executes the string value in Terminal for us; in this case `mocha specs`.

The script runs okay but we have 0 passing tests because we haven't written any tests yet.

If we want to start writing tests then the first thing that we have to do is require Assert and the model that we want to test. We'll be testing our `Taxi` model.

```js
// taxi_spec.js

const assert = require('assert');
const Taxi = require('../taxi.js');
```

### `describe()`

Before we write our first test let's take a look at one of the organisational functions that Mocha gives us: `describe()`.

Describe can be used to group similar tests. In this case we are going to use `describe()` to label our tests with the name of the relevant model. This will be displayed in the Terminal output when we run our tests. Later on when we have a lot of different models this will make the output of our tests a lot easier to read.

We'll call Mocha's `describe()` function and pass it two arguments:

1. The name of the model that we're testing as a `String`, in this case `'Taxi'`
2. A function which will contain all of the tests associated with the thing that we're describing. This syntax might look a little bit strange right now but we'll learn more about this very soon.

```js
describe('Taxi', function () {

});
```

### `it()`

Inside of the function that we're passing to `describe()` we can use the `it()` function for each of our test cases.

For the moment, we're just going to pass a single argument to `it()`: a `String` describing the test case.

We're going to add a manufacturer property to our `Taxi` so let's describe our test accordingly.

```js
describe('Taxi', function () {
  it('should have a manufacturer');
});
```

When combined with `it()` our test names should be readable and expressive. For example:

- `it('should have a name')`
- `it('can calculate the number of days until Christmas')`

Ideally, these should come from the user stories that you or your colleagues have written. This will help to keep you focussed on your product, and your MVP.

This also makes the output of our tests meaningful and errors easier to interpret as a result. If we run `npm test` now we can see what our test output will look like.

Notice that this test is listed as being `pending`. Pending tests are just tests that we haven't tackled yet - they're neither passing, nor failing.

It can be quite useful to write a few pending tests at once, so that we can see what we have to do. Let's add another:

```js
describe('Taxi', function () {
  it('should have a manufacturer');
  it('should have a model');
});
```

Now, we should have two pending tests. Let's get started on writing the body of the test.

In order to write the body of the test, just as we did with `describe`, we have to pass a function as the second argument to `it()`.

```js
describe('Taxi', function () {
  it('should have a manufacturer', function () {

  });

  it('should have a model', function () {

  });
});
```

This _anonymous_ function will contain the setup for our test, and our `assert`.

### Arrange-Act-Assert

As with many other testing frameworks we can use the arrange-act-assert pattern here.

1. Arrange: Perform any setup that might be required for the test
2. Act: Perform the action that we want to test
3. Assert: Check that our action had the expected result

```js
describe('Taxi', function () {
  it('should have a manufacturer', function () {
    const taxi = new Taxi('Toyota', 'Prius');      // Arrange
    const actual = taxi.manufacturer;              // Act
    assert.strictEqual(actual, 'Toyota');          // Assert
  });

  it('should have a model', function () {
    const taxi = new Taxi('Toyota', 'Prius');
    const actual = taxi.model;
    assert.strictEqual(actual, 'Prius');
  });
});
```

When employing TDD we should only be working on one test at a time. We can mark any tests that we don't want to run with `xit()`, which will tell Mocha to skip them. Let's skip the second test, so that we can concentrate on the first.

```js
xit('should have a model', function () { // UPDATED
  const taxi = new Taxi('Toyota', 'Prius');
  const actual = taxi.model;
  assert.strictEqual(actual, 'Prius');
});
```

We've written our test but it should fail because we haven't written the code to make it pass yet. We should always run our test at this point so that we can see it fail.

If you've never seen a test fail then you can't be sure that it's a good test, or that it tests anything at all.

```sh
npm test

# -> 1 failing
# -> TypeError: Taxi is not a constructor
```

Now we know exactly where to start. Let's create the constructor function for our `Taxi`, making sure not to forget our `module.exports`.

```js
// taxi.js

const Taxi = function (manufacturer) {
  this.manufacturer = manufacturer;
}

module.exports = Taxi;
```

Now we should be able to run our test again and it should pass.

```sh
npm test

# -> 1 passing
```

Next we're going to add a model property to our `Taxi` so we have to tell Mocha not to skip the second test.

```js
// taxi_spec.js

describe('Taxi', function () {
// ...

  it('should have a model', function () { // UPDATED
    const taxi = new Taxi('Toyota', 'Prius');
    const actual = taxi.model;
    assert.strictEqual(actual, 'Prius');
  });
});
```

Again, we should run our test so that we can see it fail. If it passed already then we would know that we had made a mistake.

```sh
npm test

# -> 1 passing
# -> 1 failing
# -> AssertionError [ERR_ASSERTION]: undefined === 'Prius'
```

`taxi.model` gives us back undefined, not the `String` that we want. That's because we haven't set that property in the constructor yet.

Let's go ahead and add that model property to our `Taxi`.

```js
// taxi.js

const Taxi = function (manufacturer, model) {
  this.manufacturer = manufacturer;
  this.model = model;
}
```

Now we should be able to run our tests again and see them both pass.

```sh
npm test

# -> 2 passing
```

### `beforeEach()`

So far, so good. There's some repetition in our test cases though. We're creating a new `Taxi` object in each test.

Mocha gives us some handy hooks which we can use to execute code at specific points during testing. In this case we want to create an object before each test, so we can use `beforeEach()`.

```js
// taxi_spec.js

describe('Taxi', function () {
  beforeEach();

  // ...
});
```

In contrast to the Mocha functions that we've used so far `beforeEach()` doesn't require a `String`. We'll just pass it the function that we want to execute before each of our test cases.

```js
let taxi;

beforeEach(function () {
  taxi = new Taxi('Toyota', 'Prius');
});
```

> We have to declare any variables outside of `beforeEach()` to prevent them from being scoped locally to that function.

We can now remove the `Taxi` objects that we created in each test and use the one that we're creating before each test using the `beforeEach()` hook.

```js
it('should have a manufacturer', function () {
  // const Taxi = new Taxi('Toyota', 'Prius'); REMOVED
  const actual = taxi.manufacturer;
  assert.strictEqual(actual, 'Toyota');
});

it('should have a model', function () {
  // const Taxi = new Taxi('Toyota', 'Prius'); REMOVED
  const actual = taxi.model;
  assert.strictEqual(actual, 'Prius');
});
```

### Task: 5 minutes

Add a `driver` property to our taxi. This should be a `String` containing the driver's name.

- Write a test to ensure that our taxi has a driver.
- Add a `driver` property to the taxi.

<details>
<summary>Example solution</summary>

```js
// taxi_spec.js

it('should have a driver', function () {
  const actual = taxi.driver;
  assert.strictEqual(actual, 'Jane');
});
```

```js
// taxi.js

const Taxi = function (manufacturer, model, driver) { // UPDATED
  this.manufacturer = manufacturer;
  this.model = model;
  this.driver = driver; // NEW
}
```

</details>

### Nested `describe()`s

`describe()`s can be nested within each other. This can be useful for grouping similar tests. We might have several tests cases to test the various outcomes of one piece of functionality, for example.

We're going to add an array of passengers to our `Taxi`, so let's use another `describe()` to group all of our tests relating to passenger functionality together.

```js
// taxi_spec.js

describe('Taxi', function () {
// ...

  describe('passengers', function () {

  });
});
```

> Note: You can skip entire `describe` blocks using `xdescribe`.

We can use then use `it()` for any test cases relating to this functionality, just like we did earlier.

First let's write a test to assert that we initially have an empty array of passengers.

```js
describe('passengers', function () {
  it('should start with no passengers');
});
```

Remember: if we want to assert that two array objects contain  the same values then we have to use `assert.deepEqual()`.

```js
describe('passengers', function () {
  it('should start with no passengers', function () {
    const actual = taxi.passengers;
    assert.deepStrictEqual(actual, []);
  });
});
```

Let's run our test and see it fail.

```sh
npm test

# -> 3 passing
# -> 1 failing
# -> AssertionError [ERR_ASSERTION]: undefined deepEqual []
```

Our test fails because `taxi.passengers` is `undefined` and we want it to be an empty array. That's because we haven't defined it in our constructor.

Let's add that empty array of passengers to our `Taxi` constructor now.

```js
// taxi.js

const Taxi = function (manufacturer, model, driver) {
  // ...
  this.passengers = []; // NEW
}
```

Now our test should pass.

```sh
npm test

# -> 4 passing
```

Next we're going to extend our `Taxi`, adding additional functionality for the passengers array.

### Task: 20 minutes

Employing TDD, add the following methods to your taxi:

- `numberOfPassengers`
- `addPassenger`
- `removePassengerByName`
- `removeAllPassengers`

A passenger should be represented as a `String` containing the passenger's name.

<details>
<summary>Example Solution</summary>

```js
// taxi_spec.js

it('should be able to return the number of passengers', function () {
  const actual = taxi.numberOfPassengers();
  assert.strictEqual(actual, 0);
});

it('should be able to add passengers', function () {
  taxi.addPassenger('Mike');
  const actual = taxi.numberOfPassengers();
  assert.strictEqual(actual, 1);
});

it('should be able to remove a passenger by name', function () {
  taxi.addPassenger('Mike');
  taxi.addPassenger('Lucas');
  taxi.removePassengerByName('Lucas');
  const expected = ['Mike']
  const actual = taxi.passengers;
  assert.deepStrictEqual(actual, expected);
});

it('should be able to remove all passengers', function () {
  taxi.addPassenger('Mike');
  taxi.addPassenger('Lucas');
  taxi.removeAllPassengers();
  const actual = taxi.numberOfPassengers();
  assert.strictEqual(actual, 0);
});
```

```js
// taxi.js

Taxi.prototype.numberOfPassengers = function () {
	return this.passengers.length;
}

Taxi.prototype.addPassenger = function (passenger) {
  this.passengers.push(passenger);
}

Taxi.prototype.removePassengerByName = function (passenger) {
  const indexOfPassenger = this.passengers.indexOf(passenger);
  this.passengers.splice(indexOfPassenger, 1);
}

Taxi.prototype.removeAllPassengers = function () {
  this.passengers.splice(0, this.numberOfPassengers());
}
```

</details>

## Recap

> Instructor note: Ask the class...

Which methods did we use from Node's Assert module?

<details>
<summary>Answers</summary>

`equal()`  
`strictEqual()`  
`deepEqual()`  
`deepStrictEqual()`

</details>

<br>

What is the difference between `equal()` and `strictEqual()`?

<details>
<summary>Answer</summary>

`equal()` uses the abstract equality operator (`==`) while `strictEqual()` uses the strict equality operator (`===`).
</details>

<br>

What is the difference between `equal()` and `deepEqual()`?

<details>
<summary>Answer</summary>

When comparing objects `equal()` expects both arguments to be references to the exact same object, whereas `deepEqual()` will check if the contents of the objects are the same.

</details>

<br>

How can we set up an npm script to run our tests for us?

<details>
<summary>Answer</summary>

Add `mocha specs` to the test script in our package.json. This tells npm to run the files in our specs directory with mocha. We can then run this script using `npm test`.

</details>

<br>

Which Mocha function can we use to group similar tests?

<details>
<summary>Answer</summary>

`describe()`

</details>

## Further Resources

- [Assert Documentation](https://nodejs.org/api/assert.html)
- [Mocha Documentation ](https://mochajs.org)
- [Introducing BDD](https://dannorth.net/introducing-bdd/)

## Conclusion

We can now write descriptive and well organised unit tests, which will help us to determine whether or not our code is working. Providing that we write good tests they can even ensure that we write better code.

Once our unit tests are in place we can safely refactor without having to worry about breaking anything. If our tests still pass then we know that our code is still working.

Our code will be better and more maintainable as a result of unit testing.
