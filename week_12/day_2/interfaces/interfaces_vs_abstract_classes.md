# Interfaces vs Abstract Classes

## Objectives

- Understand the difference between an abstract class and an interface

## What's the difference?

Often in interviews you will be asked to explain the difference between an abstract class and an interface.

### Guidelines

Here are some guidelines on when to use an abstract class and when to use interfaces in Java:

- An abstract class is good if you think you will plan on using inheritance since it provides a common base class implementation to derived classes.
- An abstract class is also good if you want to be able to declare non-public methods. In an interface, all methods must be public.
- If you think you will need to add methods in the future, then an abstract class is a better choice. Because if you add new method headings to an interface, then all of the classes that already implement that interface will have to be changed to implement the new methods. That can be quite a hassle.
- Interfaces are a good choice when you think that the API will not change for a while.
- Interfaces are also good when you want to have something similar to multiple inheritance, since you can implement multiple interfaces.

## In Summary

If you ever get asked the difference in an interview...

Abstract classes:

- Subclass can have only ONE superclass
- Can contain properties
- Can contain default implementations
- Can define abstract methods which must be implemented on subclass
- Give the superclass type to the subclass

Interfaces:

- Implementing class can have MANY interfaces
- Cannot contain properties
- Cannot contain default implementations
- Defines method signatures which must be implemented on class using it
- Gives the implementing class the interface type
