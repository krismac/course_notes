# Modular Front-end with Pub/Sub Lab: Fastest Animals

**Duration: 60 minutes**

### Learning Objectives

- Know how to structure a pub/sub application with initial data
- Know how to dynamically populate a select element with option elements

## Intro

We have been using the pub/sub architectural pattern to build front-end application. In this lesson we are going to look at an application that implements the pub/sub pattern and has some initial data that it uses to populate the page.

## Top 10 Fastest Animals Application

![Top 10 Fastest Animals Application](images/10_fastest_animals.png)

*Application Architecture*

Run the fastest animals app. You will need to install the dependencies and run webpack to generate the bundle:

```bash
npm install
npm run build
```
Open the index.html in the browser.

To familiarise yourself with the application do the following:

- Anywhere you are not sure what a value is, use `console.log` and/or the debugger to inspect it
- Change the variables to have names that are meaningful to you
- Use the Chrome dev tools - looking at the Elements tab will help you see how the JavaScript is manipulating the DOM

Complete the tasks and answer the questions:

### Tasks

1. Draw a diagram of the application architecture detailing the views and models.
2. Draw a diagram of the event and data flow through the application, detailing the publishing and subscribing with the data being passed between components.

### Questions

1. What the model `Animals` responsible for?
2. What is the view `SelectView` responsible for?
3. What does the `SelectView`'s `populate` method do?
4. What is the view `AnimalInfoView` responsible for?
5. What is app.js responsible for?
