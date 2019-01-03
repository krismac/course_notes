# Inheritance

## Learning objectives

- Understand how inheritance works in Java
- Understand the super keyword usage
- Override methods from parent class
- Create an Inheritance chain

# Intro

When we were learning Ruby, we saw how useful it was to gather classes together when they share properties or functionality. We used *inheritance* to describe the relationship between superclasses and subclasses.

> Quick recap of inheritance in Ruby:

```ruby
class Vehicle
  ...
  def start_engine
    "Vrmmmm!"
  end
end

class Car < Vehicle

end
```

The same concept exists in Java, and although the syntax is a little different, the idea is much the same. We can use the 'extends' keyword to use inheritance.

Lets use inheritance to model a system to track CodeClan instructors and students.

> Use Starting point

So here we have a tested classes for an `Instructor` and `Student` at CodeClan

We can change both names and the cohort they are attached to.

All of this seems a bit wasteful though as we are having to code everything twice even though they are doing essentially the same thing.

A better way would be to have both of these classes inherit from a parent class of `Person`.

Create a `Person` class and a test file to go with it.

```java
//PersonTest.java

Person person;

    @Before
    public void before(){
        person = new Person("Darren", "E16");
    }


    @Test
    public void hasName(){
        assertEquals("Darren", person.getName());
    }

    @Test
    public void hasCohort(){
        assertEquals("E16", person.getCohort());
    }

    @Test
    public void canChangeName(){
        person.setName("Tony");
        assertEquals("Tony", person.getName());
    }
    @Test
    public void canChangeCohort(){
        person.setCohort("E19");
        assertEquals("E19", person.getCohort());
    }

    @Test
   public void canTalk(){
       assertEquals("I love Java", person.talk("Java"));
   }
```

> **Task:** Create the person class and get the tests to pass.

Ok so now we have a `Person` class we can change our `Instructor` and `Student` classes to inherit from it.

We can remove all the methods and move to the `Person` class.

To inherit in Java we use the `extends` keyword.

Lets start with the `Instructor`.

```java
// Instructor.java

public class Instructor extends Person {

    private String name;
    private String cohort;

    public Instructor(String name, String cohort) {
        this.name = name;
        this.cohort = cohort;
    }

}

```

Ok so we now get an error that there is no default constructor in `Person`.

What is happening here is that we have inherited from person and when we do that we need to take the arguments passed into the constructor in `Instructor` and pass them to the `Person` class to assign the details.

We do this using the `super()` keyword and pass the properties we want to use in to this.

We can also now remove the properties we defined at top of the class.

```java
// Instructor.java

public class Instructor extends Person {

    public Instructor(String name, String cohort) {
        super(name, cohort);
    }
}

```

So how does this work??

When we create a new instance of `Instructor` we pass in the name and cohort. As `Instructor` extends from `Person`, Java will try and make a new instance of `Person` to work with. As `Person`'s constructor expects the name and cohort we can simply pass those up the chain and assign to the new `Person` instance that is attached to our `Instructor`.

As `Instructor` extends from `Person` we can now access all of the properties and methods in the `Person` class from `Instructor`.

Don't believe me? Run the tests again.

What?? They still pass! Awesome.

> **Task:** Change the Student class to inherit from Person and re-run tests to make sure it all works.

```java
//Student.java

public class Student extends Person{

    public Student(String name, String cohort) {
        super(name, cohort);
    }
}
```

Cool. It doesn't just have to be Getters and Setters that the child classes can access. We could add any method into `Person` and it would become available to call from `Instructor` and `Student`.

Any methods written in `Instructor` or `Student` though will only be available to that class.

Ok so all good here. But what about if we wanted to add in an extra property just for the `Instructor`. Say a module team?

So we don't want to add this to `Person` as students wouldn't be members of the module team. We can add this to the `Instructor` class only.

```java
//Instructor.java

public class Instructor extends Person {

    private String moduleTeam;

    // As Before
}
```
And lets change the constructor to take this in and assign it.

To do this we need to ensure that we call `super` first before assigning the `moduleTeam` value.

```java
//Instructor.java

private String moduleTeam;

    public Instructor(String name, String cohort, String moduleTeam) {
       super(name, cohort);
       this.moduleTeam = moduleTeam;
    }

    //As Before

```

And change our test to pass in the team name.

```java
//InstructorTest.java

public class InstructorTest {

    Instructor instructor;

    @Before
    public void before(){
        instructor = new Instructor("Ally", "G3", "JavaScript");
    }
  }

    //As Before
```

> **Task:** Write tests for a getter and setter for moduleTeam in `Instructor` class.

## Overriding methods

We can also override any methods from the parent class.

Lets add in a talk method to the the `Student` class and override it.

```java
//Student.java

public class Student extends Person{

//As Before

    public String talk(String language){
        return "I love learning " + language;
    }
  }

```

When we do this you will notice a small o with an arrow next to the method. This indicates that we are now overriding the method from `Person`.

Now if we run the `StudentTest` you will see that the `canTalk()` test fails as it is expecting the string value that we have created in Student.

> **Task:** Change the test in `StudentTest` to make it pass.

```java
//StudentTest.java

@Test
   public void canTalk(){
       assertEquals("I love learning Java", student.talk("Java"));
   }
```

Neat huh? When we call `student.talk()` it will look in the Student class for a talk() method. If it doesn't find one there it will go to next level up the inheritance chain to Person and look there and call that if it's found.


## Types of inheritance

So far, we have been using single inheritance, where our Instructor class inherits from a single parent, `Person`. We can also create an *inheritance chain*, where a class inherits from more than one layer of parent classes. For example:

```java
//Person.java

public class Person {
  public Person(String name, String cohort){
    this.name = name;
    this.cohort = cohort;
  }
}
```


```java
//Instructor.java

public class Instructor extends Person {
  public Instructor(String name, String cohort, String moduleTeam){
    super(name, cohort);
    this.moduleTeam = moduleTeam;
  }
}
```

```java
//SeniorInstructor.java

public class SeniorInstructor extends Instructor {
    private String hiringTeam;

    public SeniorInstructor(String name, String cohort, String moduleTeam, String hiringTeam){
      super(name, cohort, moduleTeam);
      this.hiringTeam = hiringTeam;
    }
}
```

Because `SeniorInstructor` inherits from `Instructor` and `Instructor` inherits from `Person` this means that `SeniorInstructor` still has access to the properties and methods on `Person` through this inheritance chain.

However, we can never inherit directly from more than one parent class. This would be illegal:

```java
//SeniorInstructor.java

public class SeniorInstructor extends Instructor, Assessor {

}
```


## SOLID: Liskov Substitution

What we have just done adheres to the Liskov Substitution principle.

This principle states that if you substitute a parent class with a child class then it shouldn't break your application.

So in this instance we are able to replace an instance of Person with an instance of either Student or instructor and there are no issues.

If it broke the application then Liskov would be very unhappy!

> **Task:** (Optional) - 20 minutes

Create your own inheritance chain for modelling various types of animal.

- Your base class should be Animal, and should have methods for `eat()` and `breathe()`.
- Create a subclass of Animal called Mammal. Mammals should have a `talk()` method.
- Create two further subclasses of Mammal: Human and Chimpanzee. They should have a `walk()` method.

Make each method return a suitable string. Check that you can create a human and a chimpanzee object, and make sure that they can each eat, breathe, walk, and talk.
