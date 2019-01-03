# Composition

## Objectives

- Understand what composition is
- Understand how inheritance can sometimes lead us into dead-ends
- Learn how we can use composition over inheritance to resolve these
- Understand how to compose objects using interfaces

## Intro

### What is Composition

We've looked at inheritance, and seen how we can create our programs by looking at what something ___IS___ e.g. a car ___IS A___ vehicle.

We can also think about what something ___HAS___ e.g. a car ___HAS AN__ engine, a car ___HAS A___ gearbox. In this sense we are seeing an object as being made up of, or ___composed___ of other objects. This is what we mean when we talk of composition in the object-oriented sense.

> Perhaps write this on the board.

```java

class Engine {
    private int capacity;
    public void rev() {

    }
}

class Gearbox {
    private String type;
    private int numberOfGears;
}

class Car {
    private String make;
    private String model;
    private Engine engine;
    private GearBox engine;
}

```

## Composition and ownership

One important thing to know about composition is that it is also about ownership. When we assign an object to be part of the composition of another object e.g. when we assign an `Engine` object to our  `Car` class, then we are handing ownership of our `Engine` object over to the `Car` object of which it is now a part.

The consequence of this is that when the `Car` object is destroyed, all objects that it `owns`, or composed of, are also destroyed i.e. the `Engine` object is also destroyed.

### Composition and Behaviours

In terms of what a `Car` does, i.e. its behaviour, we can think about what it HAS to carry our that behaviour i.e. an `Engine`, rather than what it IS that gives us that behaviour e.g. a `drive()` method in an `Vehicle` superclass.

We compose objects from other objects in order to get us to the functionality we need. We've already been doing this for a while without actually calling it Composition

> Ask the class if they can think of any examples.

Thinking back to the weekend homework, we had `Hotel` objects composed of `Room` objects.



### Composition over Inheritance

Inheritance can be useful, but it needs to be used with caution. We can very easily get into a nightmare of tangled classes and overriden methods. We also can only inherit from ONE thing and one thing only. An object can't be both a Car and a Motorcycle. It can be one or the other.

In programming we have the saying favour composition over inheritance. We should compose our classes from other classes that implement the behaviours we need.

So we're going to look at an example where our inheritance is starting to weigh us down and we can't get the behaviour we need without breaking our hierarchy or making things ugly. And how we can use composition over inheritance to solve this problem.

We're also going to use interfaces to help us with this solution.

> Give out starter code.

Get the students to read it for 15 mins to half an hour.

### Code Structure

The students should:
- draw a diagram of the classes and how they are related.

> draw the diagram on the board

## The problem

Key point:

We want the computer to output data using a printer. Or a speaker. Or anything that outputs data.

- Pair up and discuss it

Possible solutions:
- Common superclass for types which output data? Nope, already existing class hierarchy so it doesn't make sense.
- Ancestor for all objects? We don't want everything to outputs data!
- Multiple inheritance? It's not supported and there's all sorts of issues. If two superclasses have the same method, which does it use?

We want a common set of abilities that our things can do without polluting their class hierarchy which things that don't concern it.

More than that, we don't want this thing to have any clue about that behaviour, just to make sure that it exists on our object. A printer NEEDS to output data, a monitor NEEDS to output data but we don't want our structure to care HOW they output data.


## Changing our code to use interfaces

To solve our problem we are going to

- Add an `IOutput` interface
- Printer, Monitor, Speaker all implement it
- Change to IOutput in the computer

> perhaps modify the diagram on the board to show this

First things first, let's add the `IOutput` interface. We're going to put this in a new package, called 'behaviours'

```
#IntelliJ

> right click on java folder and select New > package
> Call the new package behaviours. (Need to do this so that behaviours and device_management are in same folder.)

> Right click behaviours folder and create an IOutput interface
```


``` java
//IOutput.java
package behaviours;

public interface IOutput {
    String outputData(String data);
}
```

Now, we need to make our Printer and Monitor implement it.

``` java
//Printer.java
package device_management;
import behaviours.IOutput; //NEW

public class Printer extends PrintingDevice implements IOutput { /* UPDATED */ }
```

```java
//Monitor.java
package device_management;
import behaviours.IOutput; //NEW

public class Monitor extends VideoDevice implements IOutput { /*UPDATED */ }
```

You will notice that IntelliJ automatically imports the IOutput interface from the behaviours package for us.

If it doesn't then type the following above the class declaration:

```java

import behaviours.IOutput; //NEW
```

We already have tests to see if these things outputData, so if we run them they should all still pass.

Let's now add the test for outputting data using the printer.

``` java
//ComputerTest.java

@Test
public void canOutputDataViaPrinter(){
  Printer printer = new Printer("Epson", "Stylus", 120, 4);
  computer = new Computer(8, 512, printer);
  assertEquals("printing: space invaders", computer.outputData("space invaders"));
}
```

If we build this, we will see an error because the parameters being passed to the constructor of our `Computer` class do not match. This is quite correct, a `Printer` and `Monitor` are completely unrelated and we are passing a `Printer` to a method which is expecting a `Monitor`. We need to change this to be `IOutput` in the method signature.

```java
//Computer.java
package device_management;
import behaviours.IOutput;

public class Computer {
    private int ram;
    private int hddSize;

    private IOutput outputDevice;  //UPDATED

    public Computer(int ram, int hddSize, IOutput outputDevice) { //UPDATED
        this.ram = ram;
        this.hddSize = hddSize;
        this.outputDevice = outputDevice;
    }

    public int getRam() {
        return this.ram;
    }

    public int getHddSize() {
        return this.hddSize;
    }

    public IOutput getOutputDevice() {  //UPDATED
        return this.outputDevice;
    }

    public String outputData(String data) {
        return this.outputDevice.outputData(data);  //UPDATED
    }
}


```

Since we have changed the name of getMonitor to getOutputDevice, we need to go update our test.

```java
//ComputerTest.java

    @Test  //DELETED
    public void hasMonitor() {
        assertEquals(22, computer.getMonitor().getScreenSize());
        assertEquals(786432, computer.getMonitor().getPixels());
    }

    @Test
    public void hasOutputDevice() {
        IOutput outputDevice = computer.getOutputDevice();
        assertNotNull(outputDevice);
    }
```

We have successfully output data using a printer. Let's see if we can output data using a speaker:

```java
//ComputerTest.java

    @Test
    public void canOutputDataViaSpeaker(){
        Speaker speaker = new Speaker(100);
        Computer computer = new Computer(8, 512, speaker);
        assertEquals("playing: Beep!", computer.outputData("Beep!"));
    }
```

This doesn't compile, since Speaker does not implement IOutput. Let's go fix that!

```java
//Speaker.java
package device_management;
import behaviours.IOutput;

public class Speaker extends SoundDevice implements IOutput  { /*UPDATED */ }

```



## Strategy Pattern

Wouldn't it be nice if we could set the output device on the computer? Then on the same instance of a computer we could swap out the monitor for a printer and vice versa. We are no longer tied to one output device for the life of the computer object.

``` java
//ComputerTest
@Test
public void canSetOutputDevice(){
  Printer printer = new Printer("Epson", "Stylus", 120, 4);
  computer.setOutputDevice(printer);
  assertEquals("printing: space invaders", computer.outputData("space invaders"));
}
```

This is a fairly easy change.

``` java
//Computer.java
public void setOutputDevice(IOutput outputDevice){
  this.outputDevice = outputDevice;
}
```

This ability to set the behaviour of the computer's outputData method (using `setOutputDevice`) is an example of an architectural pattern. In this case, it's the Strategy Pattern. That is, we know our computer can `outputData` and by setting the `IOutput` object that they output data with, we can change the 'strategy' they use to do so.

e.g. `save` method, with `Storage` interface, so can either `save` to cloud or to hard drive, by using a `setStorage` method.

## SOLID: Dependency Inversion

You will notice that we are passing in an instance of `IOutput` into our computer class.

This is adhering to the dependency inversion principle.

Most instincts will tell you to new up an outputDevice in the constructor of the computer but this would be the wrong way to do it.

So for example:

```java
public class Computer {
    private int ram;
    private int hddSize;

    private IOutput outputDevice;  //UPDATED

    public Computer(int ram, int hddSize) { //UPDATED
        this.ram = ram;
        this.hddSize = hddSize;
        this.outputDevice = new Printer();
    }
  }
```

Would be the wrong way to go about this as the computer now depends on the instance of the printer already created.

Whereas the original way means that as long as there is an `IOutput` ready to pass in we can create a computer with no issue.

> Instructors: Write up Dependance Inversion under SOLID headings on board.

# Recap

* Composition refers to a ___has-a___ relationship where an object is made up of one or more other objects.

* Composition allows a class to use behaviour from a group of other classes, and makes it possible for that behaviour to change at runtime.

* In composition, the object composed of other behaviours ___owns___ those behaviours. This means that when the object is destroyed ___all___ of its behaviours are also destroyed.
