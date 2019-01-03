# Homework: Pub/Sub Prime Checker

### Learning Objectives

- Be able to install and configure webpack in an application
- Be able to implement the pub/sub pattern in a front-end JavaScript application

## Brief

Your task is to create a Prime Checker application that allows a user to submit a number, and see if the number is [prime](https://en.wikipedia.org/wiki/Prime_number) or not. The logic for calculating whether a number is prime number or not is [provided](prime_number_checker_logic.md). Use it if you are struggling to write the logic yourself.

Use the pub/sub pattern to create modular views, with a model that handles the business logic. You should use the start point, which has the HTML already provided.

Use webpack to bundle your JavaScript files.

### MVP

- A user should be able to enter a number into the input, submit the form and see if the number is prime or not.

![Screenshot of Resulting Application](images/screenshot_prime_checker.png)

*Screenshot of Resulting Application*

### Planning

#### Webpack

You will need to set-up webpack in your application:

1. Install 'webpack' and 'webpack-cli' - `npm install webpack webpack-cli`
2. Create a webpack config file - webpack.config.js
3. Add the configuration details to the config file
4. Add a script to the package.json to run webpack in watch mode - `"build": "webpack -w"`
5. Add a script tag to link to the bundled file in the HTML - `<script type="text/javascript" src="js/bundle.js"></script>`
6. Run webpack - `npm run build`
7. Check the log that shows the JavaScript has loaded is showing in the browser console.
8. Add `bundle.js` to a .gitignore file

#### Pub/Sub

When developing an application that implements the pub/sub pattern, one approach is to follow the event and data flow. You might start by identifying which event starts the data flow, and handling that first. Then pass the data through the application, making sure you have it available to you at each stage, before progressing. Drawing a pub/sub event and data flow diagram that you can refer back to can help with this.
