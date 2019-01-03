# Lab - Stereo

You are being asked to model a stereo system made up of separate components. The stereo will contain a radio and at least one of the following: record deck, CD player, cassette deck(if it's a really old stereo).  It will also be possible to connect an external sound source e.g. mp3 player, phone.

## Objectives

* Practice creating abstract classes
* Practice creating abstract methods
* Practice using abstract classes
* Practice creating interfaces
* Practice implementing interfaces in classes

You will need to:

1. Create a class `Radio`, which has a method `tune`. This may simply return a string of the station being tuned to (e.g. Radio 1).

2. Create classes for different components e.g. record deck, CD player etc. Each class will have instance variables particular to that component e.g. a record deck may have play speeds, a CD player may have a number of CDs it can play at a time (think of the old-fashioned multi-changers). As the stereo is made up of separate components, each component should have its own make and model, and methods to operate them e.g. a CD player might have a `play` method. (If different components have the same methods then this might suggest that they implement the same interface);

3. Create an abstract class `Component` which contains attributes you see as being common to all the main items in the stereo system. The classes created in step 2 above can then inherit from this `Component` class.

4. Create a `Stereo` class, which contains all the components created above. It should also a name, have methods to use all the components in the stereo e.g. tune radio, play CD etc, raise, lower volume.

5. Create an interface IConnect. This should have a method `connect` which takes in an instance of a `Stereo` and return a string which contains the name of the stereo it is connected to.

6. Create a device e.g. mp3 player which implements the IConnect interface.

## Possible Extensions

* Perhaps you could add output devices e.g. speakers, headphones, and have one connected to the stereo.
* Anything else you can think of.

## Remember
Use TDD, with separate test files for each class.