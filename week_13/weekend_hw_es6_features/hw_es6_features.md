# Homework: es6 Classes

### Learning Objectives
- Be able to use Class syntax
- Be able to use `import` and `export` syntax
- Be able to use object destructuring
- Understand what a transpiler, such as Babel, is useful for

## Brief

### es6 Language Features

There are a some language features that were introduced with ECMAScript 2015 that we havn't looked at that. These features are used to when writing React idiomatically. Your task is to read the MDN documentation for these features (Classes, Import and Export, and Destructuring) and to refactor the Musical Instrument application to use them.

To run the Musical Instruments application:

- Install dependencies: `npm install`
- Run webapck in watch mode: `npm run build`
- Start the server in a new terminal window: `npm start`

and visit 'http://localhost:3000/'.

#### Classes

[https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes)

Replace the constructor functions and prototypal methods with the Classes syntax. Note: JavaScript still uses prototypal inheritance under the hood, JavaScript Classes are just syntactic sugar.

#### Import & Export

- [https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import)
- [https://developer.mozilla.org/en-US/docs/web/javascript/reference/statements/export](https://developer.mozilla.org/en-US/docs/web/javascript/reference/statements/export)

Replace the `module.exports` and `require`s with the default exports and imports.

#### Object Destructuring

[https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment#Object_destructuring](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment#Object_destructuring)

In instrument_family_view.js refactor the `render` method to destructure the instrument `family`'s properties as the `family` is passed into the function. This will mean you can refer to the just the properties inside the function. For example, `name`, rather than `family.name`.

### Transpilers

At the bottom of each of the above MDN pages there is a section called 'Browser Compatibility' that shows which browsers support these language features.

When using newer language features that are not supported by all browsers, we can use a transpiler to convert our code into a backwards compatible version JavaScript that we know is more widely supported. A JavaScript transpiler will take the source code that we write, and transpile it into the version of JavaScript that we specify in the configuration settings. We can use the configuration settings to specific exactly which browsers we want to target. This allows us to use all the latest language features, while still being sure our application will run for our users.

Babel is a JavaScript transpiler that does just this.

1. Read the Babel page, 'What is Babel?': [https://babeljs.io/docs/en/](https://babeljs.io/docs/en/)
2. Babel has a REPL that we can use to see how it transpiles our code: [https://babeljs.io/en/repl.html](https://babeljs.io/en/repl.html).
Experiment with it by typing in some es6 JavaScript (for example, an arrow function) and seeing what it transpiles to.

We will be using Babel when develop our React apps to transpile both the newer language features and other framework specific syntax into a widely supported version of JavaScript.
