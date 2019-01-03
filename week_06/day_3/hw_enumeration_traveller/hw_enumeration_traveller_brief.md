# Enumeration Homework: Traveller

### Learning Objectives
- Be able to pass functions to higher-order functions
- Be able to use built-in Array enumeration methods

## Brief

You have been given a project with two models, Traveller and Journey, and their corresponding test files.

A Journey has:

- a start location
- an end location
- a mode of transport
- a distance in miles

A Traveller has:

- an array of Journeys

You should write the code to make the Traveller tests pass, without modifying the spec files. You should use JavaScript's built-in enumerator methods, only using `forEach` if you can't find a way to use one of the other more appropriate methods.

### MVP

Traveller:

- should have a collection of journeys
- should be able to get the journeys start locations
- should be able to get the journeys end locations
- should be able to get journeys by transport
- should be able to get journeys over a certain distance

### Extensions

Traveller:

- should be able to calculate total distance travelled
- should be able to get a unique list of modes of transport

Note: Remember to remove the `x` from `xit()` on the pending tests to run them.
