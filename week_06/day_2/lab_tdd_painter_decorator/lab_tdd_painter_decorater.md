# Lab: TDD Painter Decorator

**Suggested Lab Duration: 90 minutes**

### Learning Objectives

- Be able to write unit tests using Assert in combination with Mocha
- Be able to run test files with Mocha using an npm script
- Be able to create an application using multiple interacting objects

## Brief

Your task is to create an application that allows a painter decorator to manage paint stock and decorating jobs. You application should allow a user to calculate how much paint is required to paint a room, and whether they have enough paint in stock to paint the room.

**Note: Work on the assumption that one litre of paint covers one square meter.**

### MVP

A room should:

- have an area in square meters
- should start not painted
- should be able to be painted

A paint can should:

- have a number of litres of paint
- be able to check if it is empty
- be able to empty itself of paint

A decorator should:

- start with an empty paint stock
- be able to add a can of paint to paint stock
- be able to calculate total litres paint it has in stock
- be able to calculate whether is has enough paint to paint a room
- be able to paint room if has enough paint in stock

### Extensions

A decorator should:

- should be able to decrease amount of paint in stock when painting a room
- should be able to remove empty paint cans from stock

Hint: We want to avoid removing items from arrays while iterating over them. This is because iteration uses the index number to access the current item, and if you remove an item during one of the iterations, the position of each of the following items will be changed and lead to unexpected results.

### Planning

To setup your project you will need a models folder with a specs folder inside. You will also need to:

- Initialise npm with `npm init`
- Install mocha as a dev dependency with `npm install -D mocha`
- Update the `npm test` script in the package.json run your spec files with mocha using `mocha models/specs`
- Create a .gitignore file to ignore the node_modules directory

### Considerations

Remember to use the appropriate `assert` method for the data types you are comparing in your tests.
