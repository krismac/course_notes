# Multiple Classes

### Learning Objectives
- Be able to create multiple classes.
- Be able to create a class with a collection of another class type.
- Be able to create collections of different classes.

## Intro

In this lesson we are going to have a look at creating multiple classes and allowing one class to store a collection of the second class in an ArrayList.

## Declaring an Array List

First we need to tell our code that we want to use the ArrayList class, in a similar way that we use require in Ruby.

``` java
//Bear.java
import java.util.ArrayList;

public class Bear {
  private String name;
  private ArrayList<Salmon> belly; //UPDATED

  public Bear(String name){
    this.belly = new ArrayList<Salmon>(); //UPDATED
    this.name = name;
  }
}
```

So now we have given our bear an ArrayList belly that can hold instances of our Salmon objects.

### Counting the items

We want to see how much food is in the bear's belly - initially it should be zero.

Let's write the test

```java
//BearTest.java

@Test
public void bellyStartsEmpty(){
  assertEquals(0, bear.foodCount());
}
```

And now we will write a method in the Bear class to return an `int` value with the size of the belly.

``` java
//Bear.java
public int foodCount(){
  return belly.size();
}
```

### Eating a salmon

Let's try to get our bear to eat a salmon. First, let's add a test salmon to our test file.

```java
//BearTest.java
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BearTest {
  Bear bear;
  Salmon salmon; //NEW

  @Before
  public void before(){
    bear = new Bear("Baloo");
    salmon = new Salmon(); //NEW
  }
  //same as before
 }
 ```

 Cool, now we can use this salmon in our tests.

```java
 //BearTest.java

 @Test
 public void canEatSalmon(){
   bear.eat(salmon);
   assertEquals(1, bear.foodCount());
 }
 ```

 Let's add the eat() method. For this we will use the `add()` method from the ArrayList class to add a salmon to the belly.


``` java
//Bear.java

public void eat(Salmon salmon){
  belly.add(salmon);
}
```

### Resetting the array

Lastly, let's add a way for our Bear to go to sleep and let his belly settle. What we want to happen here is that when the bear sleeps the belly will empty.

```java
//BearTest.java

@Test
public void shouldEmptyBellyAfterSleeping(){
  bear.eat(salmon);
  assertEquals(bear.foodCount(), 1);
  bear.sleep();
  assertEquals(bear.foodCount(), 0);
}
```

And lets add the sleep method in the bear class. For this we can use the `clear()` method from the ArrayList class to empty the list.

```java
//Bear.java

public void sleep(){
  belly.clear();
}
```

Cool our Bear is a happy little chappy now.

### Adding a third class

So lets extend this out a bit more now and add a third class of River to interact with the other two.

```
#Intellij

Create a new class called River and a test called TestRiver
```

Our River is going to contain the salmon and when a bear eats we will get it to take a salmon from the river.

```java
// River.java

import java.util.ArrayList;

public class River {

    ArrayList<Salmon> fish;

    public River() {
        this.fish = new ArrayList<>();
    }
  }  

```

Lets write some tests for our River. Lets start by adding some Salmon to the river.

```java
// RiverTest.java

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RiverTest {

    River river;
    Salmon salmon;

    @Before
    public void before(){
        river = new River();
        salmon = new Salmon();
    }

    @Test
    public void canAddSalmon(){
        river.addFish(salmon);
        assertEquals(1, river.fishCount());
    }

}

```

Now lets get the test to pass.

```java
// River.java

  //As Before

  public void addFish(Salmon salmon){
       this.fish.add(salmon);
   }

   public int fishCount() {
       return this.fish.size();
   }
```

Now lets test that we can remove and get a Salmon back out of the River.

```java
// RiverTest.java

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RiverTest {

  //As Before

  @Test
   public void canGetSalmon(){
       river.addFish(salmon);
       assertEquals(1, river.fishCount());
       river.removeFish();
       assertEquals(0, river.fishCount());
   }

}
```

```java
// River.java

  //As Before

  public Salmon removeFish() {
      return this.fish.remove(0);
  }
```

Cool so we can get a Salmon back from the River. So how do we get the Bear to get this salmon from the River?

> Discuss with the students and hope they get to the below solution

So when the bear eats now we will pass in a river for it to eat from.

To make what is happening clear we will change the name of our `eat()` method in `Bear` to something more explicit. So we will now call it `eatFishFromRiver()`.

Lets amend our bear test to set this up.

```java
// BearTest.java

public class BearTest {

    Bear bear;
    Salmon salmon;
    River river; //ADDED
    @Before
    public void before(){
        bear = new Bear("Baloo");
        salmon = new Salmon();
        river = new River();
        river.addFish(salmon);
    }

    @Test
    public void bellyStartsEmpty(){
        assertEquals(0, bear.foodCount());
    }

    @Test
    public void canEatSalmon(){
        bear.eatFishFromRiver(river); //AMENDED
        assertEquals(1, bear.foodCount());
        assertEquals(0, river.fishCount());
    }


    @Test
    public void shouldEmptyBellyAfterSleeping(){
        bear.eatFishFromRiver(river); //AMENDED
        assertEquals(bear.foodCount(), 1);
        bear.sleep();
        assertEquals(bear.foodCount(), 0);
    }
}
```

> Task: Amend the Bears eat function to be called eatFishFromRiver and make it so that it takes in a river and adds a salmon from the river to its belly.

```java
// Bear.java

//As Before

    public void eatFishFromRiver(River river){ //AMENDED
        Salmon salmon = river.removeFish(); //ADDED
        belly.add(salmon);
    }
```


Great stuff! So now our bear gets the salmon from the River and the river deals with removing and returning the salmon.

The way that we have done this works well as the bear doesn't have access to the rivers collection of salmon directly to amend it.

So the River should be the only class responsible for removing a fish from its ArrayList of fish. The river is responsible for amending its collection of salmon and not the bear. The `Bear` class shouldn't directly manipulate any of the properties in the `River`, like its fish count.

## SOLID: Single Responsibility

In our example, `Bear` should be only responsible for Bear related information and actions. Just as the `River` should be only responsible for river related information and actions.

**Single Responsibility principle states that one class or method should do just one simple job**. 

To achieve Single Responsibility we require `decoupling` where classes are not closely entangled and only depend on each other when they need to. Another important part of Single Responsibility is `encapsulation` where all classes have their inner variables set to `private` and only enable editing them via `public` methods, such as getters and setters. These two practices enable exact definition of which class is responsible for which functionality.

Lack of Single Responsibility complicates: 

- **maintenance of code** - especially where different functionality is programmed by different departments. Programmers can accidentally break other people's code.
- **deployment** - if a class has many responsibilities, it is more often changed, so needs more frequent releases and updates. Which complicates maintenance of other code that depend on this class.
- **testing** - in a multi-responsibility class there are more possible fringe scenarios that that will need testing.


Look at the below method in the `Bear` class:

```java
public void eatFishFromRiver(River river){
    Salmon salmon = river.removeFish();
    belly.add(salmon);
}
```

The bear object is communicating with other objects, but only for the purposes of bear-related actions, like eating a fish. And it's the river is responsible for amending its collection of salmon and not the bear. 

This depicts a correct **decoupling** of classes (separating of Bear and River functionality) and **encapsulation** of class variables (only River being able to change River's own array of fish). These combined produce a correct example of **Simple responsibility**.

## Summary

We have seen how to

- Create multiple classes in Java.
- Create a class with a collection of another class type.
- Create ArrayLists, and add and remove items from them.
- What the Single Responsibility principle is.