# HashMaps

Duration - 30 minutes

## Learning Objectives

- Describe the purpose of a HashMap
- Use some important HashMap methods
- Use a HashMap in your projects

### Intro

When we were learning Ruby, we saw how useful it was to store keys and values in a structured way - using hashes:

```ruby
  db_details = { dbname: "pizza_shop", host: "localhost" }
```

It allowed us to store and retrieve data without having to worry about the _order_ of the data.

Most languages have a similar construct, and in Java, these are called HashMaps. (In other languages they might be called hashes, dictionaries, or associative arrays.)

Let's look at how we would initialise a HashMap in Java.

Create a new project and call it HashMapDemo.

Create a new Java class in the main package again called HashMapDemo.

```java
  // HashMapDemo.java
  import java.util.HashMap;

  public class HashMapDemo {
    public static void main(String[] args) {
      HashMap favouriteFruits = new HashMap();

      favouriteFruits.put("Alice", "Apple");
      favouriteFruits.put("Sarah", "Banana");
      favouriteFruits.put("Bob", "Strawberry");

      System.out.println(favouriteFruits.get("Alice"));
    }
  }
```

So this works. The program outputs Alice's favourite fruit as expected.

Notice that we're initialising the HashMap as being empty, then using the `.put()` method to add keys and values.

However, if we build our project, rather than just running it, you might notice that the compiler is giving us a warning.

```
Choose Build > Build Project (`cmd` + `F9`)
Open the Gradle Console pane (`cmd` + `0` )
```

The warning:

```
Information: file/path/HashMapDemo.java uses unchecked or unsafe operations.
```

The compiler is warning us that we haven't specified the _types_ of the keys and values we are putting into the HashMap. We should tell the HashMap what to expect, that way we (and the compiler) can be sure that the objects we add to the HashMap are of the right type.

```java
  // HashMapDemo.java
  import java.util.HashMap;

  public class HashMapDemo {
    public static void main(String[] args) {
      HashMap<String, String> favouriteFruits = new HashMap<String, String>();

      favouriteFruits.put("Alice", "Apple");
      favouriteFruits.put("Sarah", "Banana");
      favouriteFruits.put("Bob", "Strawberry");

      System.out.println(favouriteFruits.get("Alice"));
    }
  }
```

Much better! Now Java will complain loudly if we try to set the key or value to anything other than a String.

## Keys

A note about HashMap keys: you can use any class as a key, provided that it implements the `.equals()` and `.hashCode()` methods. In the example above, `String` fits the bill, but we can use any class that implements these two methods.

## Values

When you store a value in a HashMap, it will always store an object, rather than a primitive type. Take a look at the following code.

```java
import java.util.HashMap;

public class HashMapDemo {
  public static void main(String[] args) {
    HashMap<String, Integer> ages = new HashMap<String, Integer>();

    ages.put("Alice", 52);
    ages.put("Bob", 24);

    Integer aliceAge = ages.get("Alice");

    String output = "Alice's age is " + aliceAge.toString();
    System.out.println(output);
  }
}
```

Because the value of Alice's age is a full integer object, we can call `toString()` on it. (We couldn't do this if it was a primitive type!)

## Methods

Let's take a look at some of the most common methods we can call on our HashMap:

```java
  favouriteFruits.put(key, value) // inserts a new entry into the HashMap
  favouriteFruits.get(key) // gets the value for the given key
  favouriteFruits.size() // returns the number of key-value pairs (or entries) in the HashMap as an integer
  favouriteFruits.clear() // clears all entries from the HashMap
  favouriteFruits.containsValue(value) // returns true if the HashMap contains the given value, false if not
  favouriteFruits.remove(key) //removes the entry with the given key
```

### Task

1. Create a HashMap of keys and values for the populations of some countries. Here is some sample data

```
UK: 64,100,000
Germany: 80,620,000
France: 66,030,000
Japan: 127,300,000
```

2. Output some values from the HashMap using `.get(key)` and `System.out.println()`.
3. Investigate the use of the `.values()` and `.keySet()` methods on your HashMap.
