# OO Single Class

## Learning Objectives
  - Demonstrate create a class
  - Show creating instance Variables
  - Show creating methods.
  - Show defining parameters, and return type of methods.
  - Revise catching type errors at compile time.


## Creating a bear class

Our file name must match the class name.

Start a new IntelliJ project called SingleClasses.

```
#IntelliJ
Create two new Java Classes in main folder
Runner
Bear
```

```java
//Runner.java

  class Runner{
    public static void main(String[] args){
      Bear bear = new Bear("Balu");
      String name = bear.getName();
      System.out.println(name);
    }
  }
```

```java
//Bear.java

  class Bear{
  }
```

  Oh thank you compiler. You caught the problem, that there is no 'getName' method on a bear!

  What do we need to give our bear this functionality.
  - Constructor with one argument - the name
  - Instance Variable
  - Getter

## Instance Variables

Instance variable are the state of our object.  We want to give our bear a name instance variable.
How would we do this in Ruby?  (@name)

In Java, we put them at the top of our class.  Remember we need to define a type.

```java
// Bear.java

  class Bear{
    String name;
  }
```

When we create the bear, how can we we assign it a name? Yes! Constructor function.

## Constructor Function

>  Ruby, ```initialize```

In Java we define a constructor function by writing a method with the same name as the class.

```java
//Bear.java

  class Bear{
    String name;
    public Bear(String name){
      this.name = name;
    }
  }
```

Public allows this method to be accessed from outside the object.

### Getter

```java
//Bear.java

  class Bear{
    String name;
    public Bear(String name){
      this.name = name;
    }
    public String getName(){
      return this.name;
    }
  }
```

Cool, now the compiler is happy with us and we can see the bear's name.
The getter is a typical Java method.  We define the type of what a method returns. In this case a String.

### Setter

What if we want to update the bear's name after we have created the object? What do we need?

Yes! A setter!

```java
//Bear.java

class Bear{
  //same as above
  public void setName(String newName){
    this.name = newName;
  }
}
```
Void? Wtf? Even if a function doesn't return anything, Java still expects us to tell it this. Our one parameter "newName" needs to also have it's type defined, in this case a string.

[Task:]Alter bear's name to "Baloo" using the setter

```java
//Runner.java

  class Runner{
    public static void main(String[] args){
      Bear bear = new Bear("Balu");
      bear.setName("Baloo");
      String name = bear.getName();
      System.out.println(name);
    }
  }
```

## Public and Private
We are going to show you something terrifying and awful.

```java
//Runner.java

  class Runner{
    public static void main(String[] args){
      Bear bear = new Bear("Baloo");
      System.out.println(bear.name);
    }
  }
```

What!!  We directly access the name of the bear.  Even worse...

```java
//Runner.java

  class Runner{
    public static void main(String[] args){
      Bear bear = new Bear("Baloo");
      System.out.println(bear.name);
      bear.name = ""; // UPDATED
      System.out.println(bear.name);
    }
  }
```

Defining our instance variables as private protects against unwanted access from outside. Define all your instance variables as private and create public getters and setters when needed.  This allows for defensive programming.

```java
//Bear.java

  class Bear{
    private String name;
    //same
  }
```

## Encapsulation

What we have just gone through is one of the 4 key concepts of OO programming, Encapsulation.

Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through the methods of their current class. Therefore, it is also known as data hiding.

To achieve encapsulation in Java −

- Declare the variables of a class as private.

- Provide public setter and getter methods to modify and view the variables values.

### Benefits of Encapsulation

- The fields of a class can be made read-only or write-only.

- A class can have total control over what is stored in its fields.

- The users of a class do not know how the class stores its data. A class can change the data type of a field and users of the class do not need to change any of their code.
