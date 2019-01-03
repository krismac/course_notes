# Theme Park - Homework Revising Abstract Classes, Interfaces and Polymorphism.

### Learning Objectives

Practice modelling a large real world domain and what you have learned about using:

* classes
* inheritance
* abstract classes
* interfaces

## ThemePark

### MVP

#### Classes and Abstract Classes

Model a ThemePark (with various Attraction and Stalls) and its Visitors.

Remember to model class diagrams first, then write tests, then write code.

1. `Visitor` has age, height, money
2. Using an `Attraction` abstract class (which has a `name`), create some subclasses for `Rollercoaster`, `Dodgems`, `Park`, `Playground`
3. Using a `Stall` abstract class (which has a `name`, `ownerName` and `parkingSpot`), create some classes for `IceCreamStall`, `CandyFlossStall`, `TobaccoStall`

#### Interfaces

Introduce some Interfaces to enable charging, restricting and reviewing attractions and stalls:

1. `ITicketed` promises `double defaultPrice()` and `double priceFor(Visitor)`
2. `ISecurity` promises `boolean isAllowedTo(Visitor)`
3. `IReviewed` promises `int getRating()` and `String getName()`

	Have some of the classes implement these interfaces. Below are the rules about what the implementations should be:

4. `Playground` implements `ISecurity` because it has a maximum age of 15
5. `TobaccoStall` implements `ISecurity` because it has a minimum age of 18
6. `Rollercoster` implements `ISecurity` and requires a visitor to be over 145cm tall and over 12 years of age

#### Polymorphism

1. All `Attraction`s and `Stall`s have a class variable `int rating`
2. All `Attraction`s and `Stall`s implement `IReviewed` and implement a getter for `int getRating()` and `String getName()`
3. `ThemePark` has a method `getAllReviewed()` which returns an ArrayList of `IReviewed`

### Extensions

#### Classes and Abstract Classes

1. `ThemePark` stores all `Attractions` and `Stalls` in it.
2. `ThemePark` has a method `visit(Visitor, Attraction)`

#### Interfaces

> Note: Starting prices are: £8.40 `Rollercoaster`, £4.50 `Dodgems`, £2.80 `IceCreamStall`, £4.20 `CandyFlossStall`, £6.60 `TobaccoStall`

1. `Rollercoaster` implements `ITicketed` and charges tall people over 200cm double fee
2. `Dodgems` implements `ITicketed` and charge half price to children under 12 years old
3. All `Stall`s implements `ITicketed` but they use a starting price whoever is buying
4. `Park` and `Playground` have no ticketing gate so do not implement `ITicketed` for these, but all other `Attraction`s do.


#### Polymorphism

1. `ThemePark` has a method `getAllAllowedFor(Visitor)` which takes a `Visitor` and returns an ArrayList of `ITicketed`
2. `ThemePark` has a method that can return a string with all reviews, returning a String a little bit like this: `Rollercoster: 4, Dodgems: 8, Park: 2, IceCream: 6, TobaccoStall: 1 `
