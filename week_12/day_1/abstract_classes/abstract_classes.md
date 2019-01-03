# Abstract Classes

Lesson Duration: 60-75 minutes

### Learning Objectives

- Understand what an abstract class is
- Be able to create an abstract class
- Understand that abstract classes cannot be instantiated
- Understand what an abstract method is
- Understand how abstract classes can be used as a type
- Understand that in inheritance parent classes can be abstract, but don't have to

## Intro

### What are abstract classes for?

You learned that classes are blueprints for creating objects. But sometimes we want to have a class that we will never create an object of, because it is too vague, too abstract.

Some examples of that would be: 

- a `Person` class could be a superclass of `Student` and `Instructor` but we never really want to create an instance of `Person` in itself.
- a `Shape` class could be a superclass of `Square` and `Circle` but we never really want to create an instance of `Shape ` in itself.  

This is where the idea of an `Abstract` class type comes in. On a practical level an abstract class is a class that is never instantiated  - we will never create an object of that class's type. However, we will often use abstract classes as a parents for other classes (via inheritance).

> Open the starter code and read it for 2-5ish minutes and maybe draw class diagrams 

### Starting Code

We have a class of `Car` and `Motorbike` classes that inherit from a parent `Vehicle` class.

- `Vehicle` has `numberOfWheels` and a getter for it
- `Vehicle` has `String drivingInstructions()` which gives some instructions, but these are very simple and could be not enough.
- `Vehicle` has `String startEngine()` which makes a sound of starting an engine.

- `Car` and `Motorbike` extend `Vehicle`
- Because all vehicles share certain behaviour in terms of driving instructions, `Car` and `Motorbike` override `Vehicle`'s method `drivingInstructions`. Both classes use parent's implementation (with `super.drivingInstructions()`) as well as add their own specific information.

- `Car` has `numberOfDoors` and a getter for it
- `Car` has `String openDoors()` method

> optional: below is a note on how child constructors use parent constructors:

Note that parent class `Vehicle` has a constructor with model and number of wheels, that is used by subclasses `Car` and `Motorbike` in such way that they provide default value for `numberOfWheels`. `Car` and `Motorbike` have their own constructors, which take other attributes (eg. `numberOfDoors`) but do not take `numberOfWheels` for which they will provide defaults.

Also note that `new Car("Audi",2)` calls `Car`'s constructor, not `Vehicle`'s, so the number 2 is number of doors, not of wheels.

All three classes have test files to accompany them.

### What If Classes Are Too 'Abstract' To Be Instantiated?

Notice that at the moment we can create a new instance of `Vehicle` class (eg. in `VehicleTest`). But unfortunately in our scenario the driving instructions are not quite detailed enough - they do not tell us how to steer something that is a `Vehicle`.

Like above, it happens sometimes in our code that a parent class is `Abstract` when it would not make much sense for it to be instantiated on its own.

For example in a graphical application you could have an abstract `Shape` class extended by `Square`, `Triangle` and `Circle`. While we can create these three shapes and add it to our drawing, it would make no sense to add a `Shape`. Same as you can create and interact with a `Chicken` running around in your game, but its parent class `Animal` is too abstract to have it instantiated.

It's the same with `Vehicle` and its children.

We have two needs that will be fulfilled by two OO methods:

- we want to have the ability to implement common code in `Vehicle` that can be then used in subclasses using `super.` calls (by other classes inheriting `Vehicle`)
- we want to make sure that we can't instantiate the `Vehicle` class (by making `Vehicle` abstract)


### Making a class abstract

As described above `Vehicle` should be abstract. We can make a class abstract by using the `abstract` keyword,

> UML: In class diagrams the notation for abstract classes is putting their name in italics (eg. *`Vehicle`*). Since this is very hard to distinguish in handwriting, you can also put `<<ABSTRACT>>` marker next to your class name. 
> It is up to you what method you use, as long as the diagrams help you to plan and communicate with your team

```java
//Vehicle.java

public abstract class Vehicle { //MODIFIED

    public String drivingInstructions(){
        return "Turn the key to start.";
    }
}

```

Notice that IntelliJ now complains that we can't create in instance of the `Vehicle` class inside of out `VehicleTest`:

> Error:(14, 29) java: Vehicle is abstract; cannot be instantiated

### Can we test abstract classes?

Since it is not possible to create new instances of an abstract class, it is literally impossible to test if they work. This is why we do not write test files for abstract classes, but instead we test their behaviours in non-abstract child classes that extend these abstract parent classes.

In our example we'll need to comment out the whole `VehicleTest` class. We'll come back to it later.

> Comment out all tests in `VehicleTest` class.

> Note: While there exist special ways to test some behaviours of abstract classes (like creating a dummy for-testing-only implementation class `VehicleImplementation`), we do not teach that on this course.

## Abstract Methods

### Non-abstract Methods

Note that abstract classes still benefit from all benefits of inheritance. All methods and variable of parent classes are still available to abstract class' children. In your starting code, there are two methods defined by the parent class `Vehicle`:

- `drivingInstructions()` is defined in parent and overridden by subclasses and it's functionality is extended by using `super` calls.
- `startEngine()` is is defined in parent and not modified by subclasses, but can be still used by the, 

When extending abstract classes we get all the normal "benefits" of inheritance still apply. We can share properties across all of our objects, e.g. type of fuel, color and other information that every vehicle has.

### Abstract Methods as Promises

You already know that a class can be abstract - it cannot be initialised and serves as a blueprint for other classes. You can follow a similar pattern for methods.

The new concept is an abstract method: it is a 'promise' of a method, that all subclasses need to implement. It is used when the parent needs to ensure that all children can do something, but parent does not want to provide a default way to do it.

- abstract method *HAS TO* be defined in every subclass
- abstract methods have no method body (default implementation) - body will be defined in all subclasses.

What's method body? Have a look at this method: (just write this on a whiteboard)
 
```
//method with method body
public double divide(double divident, double divisor) { 
	return  divident / divisor;
} 

//abstract method with no method body
public double divide(double divident, double divisor);
```
 
> - `public` - Scope
> - `double` - Return value
> - `divide` - function name
> - `(double divident, double divisor)` - arguments' types and names
> - `{ ... }` - method body, the actual code that this method will run
> - `;` - if your method does not have a body, it can end with a `;`. It means that this method will have a body defined elsewhere. You'll see this in Abstract methods and later in Interfaces. 

### Using Abstract Methods

> UML diagram: add boardingInstructions() to Vehicle class

Let's add an abstract method `boardingInstructions()` to our `Vehicle` class:

```java
//Vehicle.java

public abstract class Vehicle {

    public String drivingInstructions(){
        return "Turn the key to start.";
    }

    public String boardingInstructions(); //MODIFIED
}

```

Note that this method does not contain any body. What we are basically saying is that any class which inherits from `Vehicle` must implement a `boardingInstructions()` method which takes no parameters and returns a string. It doesn't matter what the method does but it must be called `boardingInstructions()`, take the declared number and type of parameters and return a the declared return type. In our example it takes no parameters and returns a `String`.

If we were to try an compile our code now we will get an error saying that the subclasses of `Vehicle` do not implement the `boardingInstructions()` method. So lets's go and fix this now.

> UML diagram: add boardingInstructions() to Car and Motorbike classes

Now that we have our class diagram, let's write the tests:

> Note that when we write tests IntelliJ's auto complete will already suggest us the abstract method `boardingInstructions()` on a class `Car` even thou it was not implemented yet. That's because it will have to be implemented at some point.

```java
//CarTest.java

    @Test
    public void hasBoardingInstructions() {
        assertEquals("Enter via one of the 4 doors.", car.boardingInstructions());
    }

//MotorbikeTest.java

    @Test
    public void hasBoardingInstructions() {
        assertEquals("Just hop on.", motorbike.boardingInstructions());
    }
```

Now let's add the implementation of this method in the `Car` and `Motorbike` classes to remove `method not implemented error`.

```java
//Car.java

public class Car extends Vehicle {

    public String boardingInstructions(){
        return "Enter via one of the " + numberOfDoors + " doors.";
    }
}
```
Now let's fix the `Motorbike` class so it compiles and the test passes

> Task for students: Fix the `Motorbike` class so it compiles and the test passes

SOLUTION:

```java
//Motorbike.java

public class Motorbike extends Vehicle {

    public String boardingInstructions(){
        return "Just hop on.";
    }
}
```

## Using Abstract Class as a Type

### Keeping benefits of inheritance

Abstract parent class is still a parent class. We get all the useful things that came with inheritance. Let's come back to our `VehicleTest.java` and let's uncomment these tests that still make sense when the parent class is abstract.

> Go into `VehicleTest.java` and uncomment bottom 5 tests (all below the ` //BELOW: Inheritance related tests:` marker)
>  
> 
>    ``` 
>     UNCOMMENT
>     private Vehicle vehicle;
> 
>     LEAVE COMMENTED:
>     // public void before()
>     // public void vehicleHasNumberOfWheels()
>     // public void vehicleHasModel()  
>     // public void hasDrivingInstructions()     
> 
>     UNCOMMENT:
>     public void carAsVehicle() //UNCOMMENT
>     public void motorbikeAsVehicle() //UNCOMMENT
>     public void changeTypeOfVehicle()//UNCOMMENT
>     public void collectionOfParentClassObjects() //UNCOMMENT
>     public void objectRemembersItsType() //UNCOMMENT
> ```

### Using the type of abstract parent as a variable type

As you remember, with inheritance we could declare a variable of a parent type, and put an object of a child object in there.

Although we cannot create an instance of an abstract class, we are allowed to declare a variable of its type. When assigning a value to that variable we have to assign it with an instance of one of its subclasses.

> Scroll to this code in VehicleTest.java. Code is already in start code, no need to type it:
> There will be an error, but we'll get to it in a minute

We can: 

- Declare a variable of an abstract class (but we can't initialise an object of that class)

```java
	//VehicleTest.java
	
    Vehicle vehicle;
```
- Put an object of a subclass into that variable

```java

    @Test
    public void carAsVehicle() {
        vehicle = new Car("Audi A8", 2);
        assertEquals("Audi A8", vehicle.getModel());
    }

    @Test
    public void motorbikeAsVehicle() {
        vehicle = new Motorbike("Harley");
        assertEquals("Harley", vehicle.getModel());
    }
    
    @Test
    public void changeTypeOfVehicle() {
        vehicle = new Car("Audi A8", 2);
        vehicle = new Motorbike("Harley");
        assertEquals("Harley", vehicle.getModel());
    }
```

- Declare a collection of objects of the abstract class `Vehicle `, but we cannot create an object of `Vehicle` and put it in there.

Let's look at the last test `collectionOfParentClassObjects`

> to remove the error comment out the line:
> `// vehicles.add( new Vehicle("Mini Morris", 4));`

```java
    @Test
    public void collectionOfParentClassObjects() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add( new Car("Audi A8", 2));
        vehicles.add( new Motorbike("Harley"));
      //  vehicles.add( new Vehicle("Mini Morris", 4)); //MODIFIED
        assertEquals(3, vehicles.size());
    }
```

> optional: a quick note on casting. You can read up on it and we may talk about it later.
  
- Note that when we put a subclass object into a parent class variable, it does not lose any of the details that came from the subclass. But to access it's subclass specific information, you'll need to cast it (ensure the compiler that you know what you're doing). Syntax for casting is: put a subclass name in brackets just before the assignment like in below code. 

```java
    @Test
    public void objectRemembersItsType() {
        vehicle = new Car("Audi A8", 2);
        Car car  = (Car) vehicle; // Example of type casting Vehicle to Car
        assertEquals(2, car.getNumberOfDoors());
    }
```

Note that there is an error if you try to instantiate a `Vehicle` because it's abstract: `Error:(23, 28) java: Vehicle is abstract; cannot be instantiated.`. Yes, that is correct, we cannot instantiate an abstract class - let's comment this line out.


### Subclass objects as method parameters 

Just a quick note on this common usage of abstract classes. Like with any other parent class, we can use the abstract type as a parameter in a method, and then pass in an instance of the subclass to that method.

Let's imagine we have a `Garage` class. Which has a method `addVehicle(Vehicle vehicleToAdd)`. Note that this is possible, even thou we will never actually pass an instance of a Vehicle (because `Vehicle` is abstract), but rather instances of `Vehicle`'s children. 

## SOLID: Open Closed Principle

What we have seen here is how we adhere to the Open Closed principle from our SOLID list.

Now our classes should be Open for extension and Closed for modification.

This means that if we wanted to add in another type of vehicle, let's say `Truck`, we won't have to change our `Vehicle` class. We can simply create a new class for the `Truck` which extends the `Vehicle ` class.

## Disadvantages

There is a problem however. We are still constrained by the same problems as inheritance. We can only have one superclass, and all the methods and properties on that class bleed down to all of our children whether we want them or not.

## In Summary

- If a class is declared abstract, you cannot instantiate objects of its type. (in `VehicleTest`  you cannot have a `new Vehicle()` call)

- Other classes can be subclasses (children) of an abstract class, and it is possible to instantiate objects of these classes, as long as the child itself is not abstract  (`Car` and `Motorbike`)

- Abstract classes may or may not contain abstract methods, i.e., methods without body ( `boardingInstructions` in `Vehicle`)

- When you inherit from an abstract class, you need to provide implementations to its abstract methods in it.( `boardingInstructions` in `Car` and `Motorbike`)

- if a class has at least one abstract method, then the class must be declared abstract.

- You can declare variables and method parameters where the type is an abstract class, but they have to take the value of in instance of one its subclasses. (`Garage` class example)

## Task (Optional) - 20 minutes

Create your own inheritance chain for modelling various types of farm animals. Use Class diagrams and TDD to test all classes apart of the abstract ones.

Task: You will create 3 classes: `FarmAnimal`, `Sheep` and `Horse`. Animals will make noises and be able to introduce themselves.

- your base class should be abstract and called `FarmAnimal`.

	`FarmAnimal` should have the following:
    -  a species,
    -  a getter for the species
    -  a `introduceYourself()` method which returns the same `String` like `'Hi, I am a cow'`.
    -  an abstract method called `makeANoise` which returns a `String`. This method is abstract, because there is no 'default' sound that an animal makes.

- create a subclass of `FarmAnimal`: `Sheep`.

	`Sheep` should also have
	- in constructor, make species 'sheep'
	- an implementation of the `makeANoise` which returns an appropriate `String` (eg. `baa`)
	- override of `introduceYourself` returning `'Hi, I am a sheep, baa baa'`.  Note that species and noise should come from variable.
	
- create another subclass of `FarmAnimal` called `Horse`.
	
	`Horse` should have the following:
	 - in constructor, make species 'horse'
    - a breed e.g. `pony`
    - a getter for the breed
    - an implementation of the `makeANoise` which returns an appropriate `String` (eg. `neigh`)
	- override of `introduceYourself` returning `'Hi, I am a horse from pony family, neigh neigh'`. Note that species, noise and breed should come from variable.
