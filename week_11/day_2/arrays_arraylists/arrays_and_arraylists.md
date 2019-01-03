# Basic Arrays

### Learning Objectives

- Know how to create a basic array
- Understand `null`
- Be able to use arrays in Java
- Know how to create an ArrayList in Java
- Be able to use ArrayLists in Java
- Understand standard and enhanced for loops
- be able to use for loops with ArrayLists

## Intro

In this lesson we are going to have a look at two types of collections in Java. The most basic Java collection - the Array and a more enhanced collection - the ArrayList. We've encountered arrays before and now we are going to see how they work in Java. They are exactly the same in principle - a container to hold a set of items.

In Ruby and many other dynamically typed languages, we could put a mixture of things into an array:

``` ruby
# irb
myArray = [1,2,3,"banana", true];
```
In Java world, we can't do this. We're going to have a look at why this is the case in this lesson.

> Hand out start point

We need to declare the type of things that go into the array, followed by square brackets then the name of the array variable. This means that if we create an array of Strings then only Strings can be stored in the array.

The main concern with arrays is that we need to specify the number of items that can be stored in the array. This must be done when we initialise the array and can't be changed after.

```java
//WordCollection.java

class WordCollection {
   private String[] words;

   public WordCollection(){
     this.words = new String[5];
   }
}
```

So here we have an array of Strings that will only hold 5 string objects inside.

In the `WordCollectionTest` we have a test to get the word count back. Uncomment this and let's make it pass.

Arrays don't have many methods attached to them like we had in Ruby. It does however have a length property that we can use.

Let's write the method for this.

```java
//WordCollection.java

class WordCollection {
   private String[] words;

   public int getWordCount(){
     return this.words.length;
   }
}
```

Run the test and see what happens....


Expected 5?? WTF??

This is because we have specified the length as 5 so Java arrays will automatically store something in the 5 spaces.

So what is actually in the array is `[null, null, null, null, null]`

`null` is a special java type meaning nothing. (This is not the same as integer 0 or an empty string as these have a specific type. Nulls have no type.)

In Java, a variable is a reference to an object. A null value indicates an unset reference (i.e. a reference to nothing).

So this could be a problem when it comes to getting the size of the array accurately. We would need conditions for if the entry was null.

Not having methods on arrays has a big effect on how we manipulate them.

They have no add method so we would need to write this ourselves.... to do this we need to specify the index to add it to.

```java
//WordCollection

public class WordCollection {

    public void add(String word){
      this.words[0] = word; // Added
    }
}
```

Also when we add we are always setting the first element in the array so we would need some kind of counter to check if the entry was null and if so add it at that index. Messy!!

Also we don't have any methods so remove an item so we would have to write that ourselves as well.

The reason we are showing you this is that arrays are still used in some cases to store data where you know the exact size of the collection, but very rarely.

Some Java methods do return Arrays so it is likely that you will still encounter them. Such methods as Enum.values(), String.split(), main method all return arrays.

When we are creating a collection of our own though the more standard collection to use is an ArrayList.

> Comment out the test in WordCollectionTest so that it doesn't affect next section.

## ArrayLists

The ArrayList class is an out of the box Java class that implements the List interface so we can do a lot more with it. ArrayList supports dynamic arrays that can grow as needed.

Array lists are created with an initial size. When this size is exceeded, the collection is automatically enlarged. When objects are removed, the array may be shrunk.

Lets create another class to use these and a test.

```
#IntelliJ
Create a class called NumberList
Create a test called NumberListTest
```

When we create a new ArrayList we need to specify again what type is held in the ArrayList. This is done within angular brackets <>. Again only this type can be stored in here.

ArrayLists cannot hold primitive types so we couldn't do something like `ArrayList<int>`. However, as we looked at in Reference types, there is normally a class associated to primitive types. So `Integer` for ints, `Double` for double etc. So ArrayList<Integer> would be fine.

```java
//NumberList.java

import java.util.ArrayList;

public class NumberList {

    private ArrayList<Integer> numbers;

    public NumberList(){
        this.numbers = new ArrayList<>();
    }
}
```

Yep, ArrayLists live in the java.util "namespace". Namespaces are just a way of bundling up code, like Ruby modules. Util is indeed a shocking name and it should really be "collections" or something. Don't be like Java. Don't call stuff util, or utils. For me. Please.

In the constructor we have to create a new instance of the ArrayList. We can't simply say something like `numbers = []` like we could in Ruby because the ArrayList is a Class. Like any other class we write we have to create a new instance.  

Lets test getting the number of entries from the ArrayList.

We can do this using the size() method attached to ArrayList class.

```java
// NumberListTest

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberListTest {

    private NumberList myNumbers;

    @Before
    public void before(){
        myNumbers = new NumberList();
    }

    @Test
    public void hasNumberOfEntries(){
        assertEquals(0, myNumbers.getNumberCount());
    }
}
```

>Task Write the method so that the test passes.

```java
// NumberList

import java.util.ArrayList;

public class NumberList {

    private ArrayList<String> numbers;

    public NumberList(){
        this.numbers = new ArrayList<>();
    }

    public int getNumberCount() {
        return this.numbers.size();
    } // NEW
}
```

Sweet our test passes!

Lets add a number to the list.

```java
// NumberListTest

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberListTest {

    //AS Before

    @Test
    public void canAddNumberToList(){
      myNumbers.addNumber(12);
      assertEquals(1, myNumbers.getNumberCount());
    }
}
```

>Task: Write the method to add to the ArrayList.

Investigate the methods on the ArrayList class to see if there is anything to help you here.

```java
// NumberList

import java.util.ArrayList;

public class NumberList {

  //As Before

  public void addNumber(int number){
    this.numbers.add(number);
  }
}
```

Awesome we can now add to the ArrayList.

Every time we add to the list it will always put the new number at the next index number.

Lets see if we can get the first number back out.

```java
// NumberListTest

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberListTest {

    //AS Before


    @Test
    public void canGetFirstNumber(){
      myNumbers.addNumber(12);
      assertEquals(12, myNumbers.getNumberAtIndex(0));
    }
}
```

>Task: Write the method to get the number from the ArrayList.

```java
// NumberList

import java.util.ArrayList;

public class NumberList {

  //As Before

  public int getNumberAtIndex(int index){
    return this.numbers.get(index);
  }
}
```

So we can get the number at a specific index.

There are numerous methods we can use on ArrayLists:

- clear(). Removes all of the elements from this list.
- contains(Object o). Returns true if this list contains the specified element.
- remove(int index). Removes and returns the element at the specified position in this list.

## Loops

A for loop is a repetition control structure that allows you to efficiently write a loop that needs to be executed a specific number of times.

A for loop is useful when you know how many times a task is to be repeated.

Let's say we wanted to get the total of all the numbers in our ArrayList.


```java
// NumberListTest

public class NumberListTest {

    //AS Before

    @Test
    public void canGetTotal(){
      myNumbers.addNumber(1);
      myNumbers.addNumber(2);
      myNumbers.addNumber(3);
      myNumbers.addNumber(4);
      assertEquals(10, myNumbers.getTotal());
    }
}
```

The first kind of loop to look at is a standard for loop.

The syntax of a for loop is −

```java
for(initialization; Boolean expression; update) {
  // Statements
}
```

So let's try using this loop to get the total.

```java
// NumberList.java

public class NumberList{

  // AS BEFORE

  public int getTotal(){
    int total = 0;
    for (int i = 0; i < getNumberCount(); i++){
      total += getNumberAtIndex(i);
    }
    return total;
  }
}
```

So here we are setting an initial counter `i` to 0. The loop will run as long as `i` is less than the number of entries in the list. After each loop runs the value of `i` is increased by 1.

`i` can now be used as our index for each item in the list.

Run the test....

Sweet it passes.

Is there maybe an easier way though?

Yes there is an enhanced for loop which will look more familiar to you.

The syntax for the enhanced for loop is as follows:

```java
for(type name : listName){

}
```

Looks similar to the Ruby loop doesn't it?

This is the most common type of loop used with collections.

Let's amend our `getTotal()` method.

```java

public class NumberList{

  // AS BEFORE

  public int getTotal(){
    int total = 0;
    for (int number : this.numbers){
      total += number;
    }
    return total;
  }
}
```

Ah, that's better.

## Passing lists into Constructors

Ok so before we created a new ArrayList in the constructor. But what if we wanted to create new instance of our NumberList class with a pre-populated list of numbers.

Well we can create a new ArrayList in our test and pass it to the NumberList when we create the new instance. Just like we did with the Bear and passed it a name, age and weight.

In the test class we will change the before method to do this.

```java
// NumberListTest.java

public class NumberListTest {

  private NumberList myNumbers;

  @Before
  public void before(){
    ArrayList<Integer> testNumbers = new ArrayList<>(); // NEW  
  }
}
```

Now let's add some numbers to this list.

```java
// NumberListTest.java

public class NumberListTest {

  private NumberList myNumbers;

  @Before
  public void before(){
    ArrayList<Integer> testNumbers = new ArrayList<>();
    testNumbers.add(1); // NEW
    testNumbers.add(2); // NEW
    testNumbers.add(3); // NEW
    testNumbers.add(4); // NEW
  }
}
```

And finally we will pass it to the NumberList class.

```java
// NumberListTest.java

public class NumberListTest {

  private NumberList myNumbers;

  @Before
  public void before(){
    ArrayList<Integer> testNumbers = new ArrayList<>();
    testNumbers.add(1);
    testNumbers.add(2);
    testNumbers.add(3);
    testNumbers.add(4);
    myNumbers = new NumberList(testNumbers);
  }
}
```

We will also need to amend some of our previous tests now as our list will now start with 4 numbers.

```java
// NumberListTest.java

public class NumberListTest {

  // AS BEFORE

  @Test
  public void hasNumberOfEntries(){
      assertEquals(4, myNumbers.getNumberCount()); // MODIFIED
  }

  @Test
  public void canAddNumberToList(){
    myNumbers.addNumber(12);
    assertEquals(5, myNumbers.getNumberCount()); // MODIFIED
  }

  @Test
  public void canGetFirstNumber(){
    // DELETED addNumber
    assertEquals(1, myNumbers.getNumberAtIndex(0)); // MODIFIED
  }

  @Test
  public void canGetTotal(){
    assertEquals(10, myNumbers.getTotal()); // MODIFIED
  }

}
```

Ok so we are good to go. Now we will go and change our class to take in the list and assign it to the instance variable.

```java
// NumberList.java

public class NumberList{

  private ArrayList<Integer> numbers;

  public NumberList(ArrayList<Integer> numbers){
    this.numbers = numbers;
  }
}
```

So we have created an ArrayList with the values `1,2,3,4` in it. Passed it to the `NumberList` class and then assigned that same list to the numbers property of the class.

Don't get confused by the fact that we are declaring `ArrayList<Integer>` in the constructor parameters. We need to let java know what kind of thing is being passed in.

Run the tests and we should now be all green!

## Summary

While arrays still have their place in Java and you may see them in use the preferred collection to use is ArrayList<>.

We can perform more functions on an ArrayList without having to write the specific methods ourselves.

ArrayLists also grow in size dynamically.

ArrayLists, like Array, can only hold one specific type of Object. (String, Integer, etc). But this can also include our own objects (e.g. Bear).
