# Interfaces

**Lesson Duration: 90 minutes**

### Learning Objectives

* Know what an interface is in Java
* Know why and when you would use an interface (interface as a contract)
* Be able to create an interface
* Be able to implement an interface in a class
* Understand that a class can implement multiple interfaces

## Intro

Sometimes we want a number of classes to implement similar type of functionality, but we do not want then to inherit from the same parent. In such a situation, classes can make a promise to implement certain methods - we call a promise like that an **Interface**.

An interface is implemented as a class, but it only contains descriptions of methods, not their implementation - like an abstract method in an abstract class.

Once an interface is defined, all classes that **implement** it promise to contain bodies of all the methods specified in the interface. 

> Use start code. It has an simple `Runner` class, and the tests for the getters. 


### How to declare an interface

Let's start with running. At first we will make sure that the `Runner`  promises to be able to run. It will implement an interface called `IRun`.

> A note on interface naming conventions
> 
> The naming convention we are going to use for our interfaces is an old one. We are going to put an 'I' before for the interface name. We are going to create an interface for a 'Runner', so our interface will be called `IRun`.

Let's create a new interface called `IRun` in the main package.

 
> NOTE: another naming convention that is commonly used is, rather than putting an 'I' at the start of the interface name, is to put the word 'able' at the end e.g. in our example the interface name would be `Runnable ` - a bit of a mouthful. This means that we can end up with weird looking words.


```
#IntelliJ
Create a new class called IRun.java and set its type to Interface from drop down. 
Right click > new > Java Class.
name class IRun and in drop down change to Interface.

```

This will give us the following:

```java
//IRun.java
public interface IRun {

}
```

Let's add a method to this interface called `run` that takes an `int distance` which does not return anything.

Note that we are not providing an implementation for the method. We are leaving this up to the classes which use the interface (just like with abstract methods in abstract classes)  

```java
//IRun.java
public interface IRun {
  public void run(int distance); // MODIFIED
}

```

> NOTE: later versions of Java do allow us to provide default implementations of methods which can be overriden in the classes using the interface. We won't be doing this on this course.

We use this interface with the **implements** keyword. So let's get our `Runner` class to use this interface:

```java
//Runner.java

public class Runner implements IRun { // MODIFIED
  //...
}
```

Now our code won't compile. WHY?

> we now get the following error:
> Error:(1, 8) java: Runner is not abstract and does not override abstract method run() in IRun

## Interface as a Contract

An interface forms a contract. Any class which implements an interface must implement **ALL** the methods in that interface.

If any are missing then we'll get a compiler error as the class is not fulfilling the contract. The contract doesn't say **HOW** these methods will be implemented, just that they **ARE** implemented.

Perhaps think of a Bank Account example. I may have accounts at several banks, but I expect that for each account, I should be able to pay-in money and withdraw money - that is the 'contract' I have with each bank. Each bank may do things differently, and to be honest, I don't care how, but they all do the things I expect them to do. We could say that all banks promise to implement an interface for paying-in and withdrawing money.

So what we are saying in our example is that the `Runner` class, since it implements the `IRun` interface **MUST** have a method called `run(int distance)` which does not return anything.

In fact **ANY** class which implements the `IRun` interface must have a method called `run(int distance)` which does not return anything.

### How to implement an interface

So we now need to get our `Runner` class to fulfil the contract i.e. we need to add a `run(int distance)` method, which does not return anything.

We'll write the test first:

```java
//RunnerTest.java

	@Test
	public void canRun() { // NEW TEST
	    runner.run(10);
	    assertEquals(10, runner.getDistanceTravelled());
	}

```

Ans then implement the method:

```java
//Runner.java

public class Runner implements IRun {

  //...

    public void run(int distance){
        distanceTravelled += distance;
    }
}

```

### Interface becomes even more useful when many classes implement it

Let's create another class that will also implement the `IRun` interface: a `Triathlete`.

> Task:
> 
> make the `Triathlete` class also implement `IRun` interface and all functions that it promises. Write your tests first.

> UML: connect `IRun` with `Triathlete`. Add `run(int)` to `Triathlete`


Solution:

```java
//TriathleteTest.java

public class TriathleteTest {

    @Test
    public void canRun() { //NEW TEST
        triathlete.run(10);
        assertEquals(10, triathlete.getDistanceTravelled());
    }

}
```

```java
//Triathlete.java

public class Triathlete extends Athlete implements IRun {

    public void run(int distance){ // MODIFIED
        distanceTravelled += distance;
    }
}
```

> Note: in this class, all the implementations of `run()`, `swim()` etc will be very similar, but thanks to separating them we are able to add to them class-specific behaviours. Like `bike()` could check if you actually have a bike, but in triathlon it would also check if you already swam (in triathlon cycling comes after swimming).
> But in this simple example, all the sport methods, will only increase the distance for now.


## Implementing Multiple Interfaces

### Unique advantage of interfaces

Did you notice that what we've built up until now could have been just as well implemented with inheritance? **Theoretically `Runner` and `Triathlete` could have inherited the running bevaviour from the same parent class**. This is where unique advantage of interfaces comes into play: a class can implement multiple interfaces at the same time.

- When we use inheritance, our **class can only inherit from ONE superclass**. 
- When we use interfaces, our **class can implement as many interfaces as it wants**.

### Interface segregation

Let's consider a following task:

Just like we had our `Runner` and `Triathlete` promise that they will implement a `run(int distance)` method, let's have our `Swimmer` and `Triathlete` promise that they will implement a `swim(int distance)` method.

There are two bad ways to do it, and I would like you to tell me why these are not the best:

1. We could add a `swim(int distance)` method on the `Athlete` parent class
2. We could add a `swim(int distance)` method to the `IRun` interface,

> Why would these solutions not work?

Neither of these really makes much sense.

Why? This would mean that every class which inherits form `Athlete` of implements `IRun`, like our `Runner` would now also need to have a `swim(int distance)` method. One thing about using inheritance or interfaces is that we shouldn't force methods onto classes that they don't need.

In real life, it should be possible to be a runner without having to be able to swim.

When creating an interface we should think about the classes which are going to implement it. We might add a lot of methods to an interface, but we need to ask ourselves "Do we really want to have to implement every method of this interface in every class that implements it?". Keeping things simple is often a good idea.


### Implementing another interface

Let's instead add a new interface `ISwim` which will promise that classes which implement it will have a `swim(int distance)` method. This interface will be implemented by `Swimmer` but also by `Triathlete`.


TASK: 
Create two interfaces: a `ISwim` (promising `swim(int distance)`) and `ICycle` (`cycle(int distance)`) interfaces.

`Swimmer` and `Triathlete` should implement `ISwim`

`Cyclist` and `Triathlete` should implement `ICycle`. Implement methods these interfaces promise, so that your code compiles.

Write your tests first.


As mentioned above it is a good practice, to have smaller highly cohesive interfaces rather than larger less specific ones.

```java
//TriathleteTest.java

    @Test
    public void canSwim() {//NEW TEST
        triathlete.swim(10);
        assertEquals(10, triathlete.getDistanceTravelled());
    }
    
    @Test
    public void canCycle() {//NEW TEST
        triathlete.cycle(10);
        assertEquals(10, triathlete.getDistanceTravelled());
    }

//SwimmerTest.java

    @Test
    public void canSwim() {//NEW TEST
        swimmer.swim(10);
        assertEquals(10, swimmer.getDistanceTravelled());
    }
    
//CyclistTest.java

    @Test
    public void canCycle() {//NEW TEST
        cyclist.cycle(10);
        assertEquals(10, cyclist.getDistanceTravelled());
    }
    
```

```java
//Triathlete.java

public class Triathlete extends Athlete implements IRun, ISwim, ICycle { //AMMENDED

    @Override
    public void run(int distance){
        distanceTravelled += distance;
    }

    @Override
    public void swim(int distance) { //AMENDED
                distanceTravelled += distance;
    }
    
    @Override
    public void cycle(int distance) { //AMENDED
                distanceTravelled += distance;
    }
}

//Swimmer.java
public class Swimmer extends Athlete implements ISwim {

    public void swim(int distance){
        distanceTravelled += distance;
    }
}

//Cyclist.java
public class Swimmer extends Athlete implements ISwim {

    public void cycle(int distance){
        distanceTravelled += distance;
    }
}

```

### SOLID: Interface segregation

Notice what we've done - we separated sport activities into three small interfaces `IRun`, `ISwim` and `ICycle`. This way classes that want to be able to swim, promise that they will be able to swim. But classes who do not want to swim, do not promise swimming.

The Interface Segregation rules basically states that classes should not implement methods that they do not need.

1. **When an interface is large and complicated, try to separate it into smaller interfaces**:
	
	> Just explain, or show in code, but ask students to NOT code along and show this in IntelliJ:

	Imagine we did not have `IRun`, `ISwim` and `ICycle` but instead we had just one large generic interface `ICanDoTriathlon`. `ICanDoTriathlon` would promise `run()`, `swim()` and `cycle()`

	Now imagine each of `Runner`, `Cyclist` and `Swimmer` implemented that interface. To make the compiler happy, you'd probably need to implement the required methods and have them do nothing interesting (since normal Runner cannot really swim or cycle). The same thing would happen if `Athlete` implemented that interface - each of `Athlete`'s subclasses would need to implement all these redundant methods. 

Which takes us to the second important part of interface segregation:

2. **Classes should not implement interfaces that are not needed or are too generic**, because you will have to write empty methods to satisfy these interfaces:
	
So with Interface Segregation we need to ensure that no class should be forced to depend on methods it does not use. We should split interfaces that are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them.

When creating an interface we should think about the classes which are going to implement it. We might add a lot of methods, but we need to ask ourselves "Do we want to have to implement every method in our class?"

## Interface as a Type

A class implementing an interface also takes on the type of that interface. This means that once a Java class implements a Java interface you can use an instance of that class as an instance of that interface. Let's add a new test to show this

```java
//RunnerTest.java

    @Test
    public void canBeReferedToAsInterfaceType() // NEW TEST {
        IRun somethingThatRuns = new Runner();
        somethingThatRuns.run(10);

        assertEquals(10, somethingThatRuns.getDistanceTravelled()); 
        //OH NO! When you try to run this, you will get below error
    }

```

We're getting the following error:

```
Error:(44, 53) java: cannot find symbol
  symbol:   method getDistanceTravelled()
  location: variable somethingThatRuns of type IRun
```


Note that when we use an interface as a type (eg. `IRun`), we can only access those methods which are listed as part of the interface. If a class which implements the interface has other methods that are not a part of that interface (eg. `getDistanceTravelled()`), then we cannot access these methods when simply using the type of the interface.

In our example, if we create an variable of type `IRun` and put a `Runner` object in it. We cannot access `Runner`'s method `getDistanceTravelled()` because it's not in `IRun`. This is because compiler only knows about methods relevant to the variable type, which in our example is `IRun`.

One possible solution is to cast the object back into it's original object type. But that approach can be error prone and dangerous, so you will rarely use it for things other than testing.

> change assertEquals line into:

```java
	//RunnerTest.java
	
	 @Test
    public void canBeReferedToAsInterfaceType() {
        IRun somethingThatRuns = new Runner();
        somethingThatRuns.run(10);
        assertEquals(10, ((Runner) somethingThatRuns.getDistanceTravelled())); //MODIFIED, added casting
    }
    
```

> Why could casting be dangerous? 

Answer: imagine what would happen if you try to cast `somethingThatRuns` into a `Runner` but actually it is a `Triathlete`?

> Change the line below and try to run the program (you'll get an error)
> java.lang.ClassCastException: Triathlete cannot be cast to Runner
> at RunnerTest.canBeReferedToAsInterfaceType(RunnerTest.java:30)

```java
//RunnerTest.java

    @Test
    public void canBeReferedToAsInterfaceType() {
        IRun somethingThatRuns = new Triathlete(); //MODIFIED
        somethingThatRuns.run(10);
        assertEquals(10, ((Runner) somethingThatRuns.getDistanceTravelled())); 
    }

```

We'll talk more about this when we talk about polymorphism


## Abstract classes and superclasses can implement interfaces

### Superclasses implementing an interface 

One thing to note is that abstract classes and superclasses can also implement interfaces.

If we created an interface `ITravelDistance` which promise a method `getDistanceTravelled()` this interface could be implemented by `Atlhete` class. This would mean that `Athlete` needs to implement above method, but also it would mean that all subclasses of `Atlhete` can be referred to using `ITravelDistance` as type (eg. `Runner`, `Swimmer`), because they would also inherit implementation of that interface.

### Abstract classes implementing an interface

Abstract classes can also implement interfaces. Let's imaging an abstract class `Shape` which has two non abstract children `Square` and `Circle`. Let's have `Shape` implement an interface `IHasArea` which promises a method `double area()`.

There are two options whenever an abstract class implements an interface:

1. Provide a full implementation of the `area()` method in the abstract class. That implementation will cascade to all subclasses. 

	This is not the best solution for the `Shape`, because each shape has a different formula for its area, hence it's hard to come up with a default formula for the area.


2. Make the `area()` method and abstract inside of `Shape` class and provide full implementations of it in each of the sub-classes (`Square`, `Circle`).

### Interfaces inheriting other Interfaces

Java classes can only inherit one super class. But fortunately interfaces are not exactly Java classes, so as an exception they can inherit from many other interfaces.

Let's imagine two scenarios:

1. Interface extending another interface

	> in IntelliJ Create a new Java class called `ICanDoHurdles ` and write:
	
```java
	public interface ICanDoHurdles extends IRun {
	    public void jump();
	}
```
	
    A class that implements interface `IHurdles` needs to have all methods promissd by `IHurdles` and its parent `IRun`, so both `jump()` and `run(int distance)`.

2. Interface combining multiple other interfaces

	> in IntelliJ Create a new Java class called `ICanDoTriathlon` and write:

```java
	public interface ICanDoTriathlon extends IRun, ISwim, ICycle{
	}
```

	Now if we'd like some class to implement all 3 interfaces (`IRun`, `ISwim`, `ICycle`) we could simply have that class implement `ICanDoTriathlon`.

3. A combination of both of these approaches (where you both add new methods and combine many other interfaces).

As we mentioned above in the SOLID section. It is good to separate interfaces into small ones which promise just a few methods each.

# Recap

* An interface is a bit like a class except that it only contains descriptions of methods, not their full implementations.

* Interfaces are implemented by classes and form a contract in that, if a class implements an interface, then it must implement *ALL* the methods declared by that interface.

* Classes can implement multiple interfaces

* It is better to implement multiple, smaller interfaces, than larger less specific ones.
