# Polymorphism to the rescue

### Learning Objectives

- Understand the power of polymorphism
- Use polymorphic methods and collections

# Intro

So we saw a solution to add both Desktops and Printers to our network. However, we weren't very happy with it since it wasn't very DRY and or scaleable.

We can solve all of our problems with "polymorphism". This isn't as scary as it sounds, it just means we can wrap our objects up in an enclosing type that defines a contract between them all.

## What is polymorphism?

The term polymorphism comes from two Greek words: 'poly' meaning 'many' and "morph" meaning 'change'. When we talk of something being 'polymorphic' we mean that it can have 'many forms'. 

I know... let's look at a real world example - a person. A person can have many 'hats' or 'roles', but they are not all who that person is. For example, Wilma is a person. She is married to Fred and they have one child, Pebbles. Wilma also works as a brain surgeon, and at weekends follows the Bedrock baseball team. Thus we can look at Wilma in many ways:
    * Wilma the wife(of Fred)
    * Wilma the parent(of Pebbles)
    * Wilma the brain surgeon
    * Wilma the baseball fan

When Wilma is at home she is Wilma the wife and/or Wilma the parent, but not Wilma the brain surgeon or baseball fan. When at work she is Wilma the brain surgeon etc. 

We can do the same thing in programming. We can treat an instance of a class as if it is also another class/type at the same time. 

## How to implement polymorphism in Java

Polymorphism can be implemented using both abstract classes and interfaces. Remember that all classes which inherit from a class can take the type of the superclass. To use an abstract class we create a superclass which all the classes we want to treat as being the same can inherit from. But, inheritance is fraught with problems and we can quickly get into a mess. We can also just have one superclass.

Interfaces also allow us to treat a class as being of another type.  When a class implements an interface it gains the type of the interface without having a horrible inheritance chain. We can have as many interfaces as we like, too. Rather than just one super class.

## Modify our example to be polymorphic

What we want to do in our `Network` class is to be able to just create a single ArrayList for `devices` and be able to add different things e.g. Desktops and Printers to the ArrayList, but to do this they need to be of the same type. This is where polymorphism comes in. We need to be able to treat anything we add to the ArrayList as being of the one type. We can do this using an interface. We can create an interface which both `Desktop` and `Printer` inherit, and then have a single ArrayList where the type is the interface that we implement. 

Let's have an interface, IConnect that both of our connectable types implement from. Both a `Desktop` and a `Printer` are connectable. Once we have created our interface and made our classes implement it, we can than create an ArrayList of `IConnect` which means that it can contain both `Desktop` and `Printer` objects.

> Use starter code.

Lets create a new interface called IConnect in the main package. This interface will have one method `connect` which will take a single String parameter, and return a String.

```
#IntelliJ

Create a new interface in the main package called IConnect. 
```

```java
//IConnect.java
public interface IConnect {
  public String connect(String data);
}
```

> TASK: get the `Desktop` and `Printer` classes to implement this interface. Remember to write tests.

```java
//ComputerTest.java

  @Test
  public void canConnect(){
    assertEquals("connecting to network: CodeClan", desktop.connect("CodeClan"));
  }
```

```java
//Desktop.java
public class Desktop implements IConnect {
    // AS BEFORE
    public String connect(String data) {
      return "connecting to network: " + data;
    }
}

```


```java
//PrinterTest.java

    @Test
    public void canConnect(){
        assertEquals("connecting to CodeClan network", printer.connect("CodeClan"));
    }
```

```java
//Printer.java

  public class Printer implements IConnect{

      //AS BEFORE

      public String connect(String data) {
        return "connecting to " + data + " network";
      }
  }

  
```


Great. Now, in Ruby this didn't really mean much since we could pass anything to any method, and put anything we wanted into Arrays. In Java, this concept is extremely important. Our `Desktop` is both a `Desktop` AND an `IConnect`. Our `Printer` is both a `Printer` AND an `IConnect`.

What does this mean for us though? Let's revist our networks device list.

## Polymorphic collections

We can now delete some of our stinky code!

```java
//Network.java

public class Network {
    private String name;
    private ArrayList<Desktop> devicesDesktop;  //DELETED
    private ArrayList<Printer> devicesPrinter;

    public Network(String name){
        this.devicesDesktop = new ArrayList<Desktop>(); //DELETED LINE
        this.devicesPrinter = new ArrayList<Printer>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int deviceCount(){
        return devicesDesktop.size() + devicesPrinter.size();
    }

    public void connect(Desktop desktop){  //DELETED FULL METHOD
        devicesDesktop.add(desktop);
    }

    public void connect(Printer printer){
        devicesPrinter.add(printer);
    }

    public void disconnectAll(){
        devicesDesktop.clear();  // DELETED LINE
        devicesPrinter.clear();
    }
}
```


After deletion:

```java
//Network.java

public class Network {
    private String name;
    private ArrayList<Printer> devicesPrinter;

    public Network(String name){
        this.devicesPrinter = new ArrayList<Printer>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int deviceCount(){
        return devicesDesktop.size() + devicesPrinter.size();
    }

    public void connect(Printer printer){
        devicesPrinter.add(printer);
    }

    public void disconnectAll(){
        devicesPrinter.clear();
    }
}

```

Didn't that feel good?? Now we can fix our code to be nice and polymorphic. Our ArrayList can just be devices again.

```java
//Network.java

public class Network {
    private String name;
    private ArrayList<Printer> devices; //UPDATED

    public Network(String name){
        this.devices = new ArrayList<Printer>();  //UPDATED
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int deviceCount(){
        return devicesDesktop.size() + devicesPrinter.size();
    }

    public void connect(Printer printer){ 
        devices.add(printer);  //UPDATED
    }

    public void disconnectAll(){
        devices.clear();  //UPDATED
    }
}

```

Our deviceCount() method can go back to just returning the size of the devices ArrayList.

```java
//Network.java

  public int deviceCount(){
    return devices.size();
  }
```

We are going to do something controversial - we are going to make our ArrayList contain `IConnect`, NOT Desktops or Printers.

```java
//Network.java

  private ArrayList<IConnect> devices;  //UPDATED

    public Network(String name){
        this.devices = new ArrayList<IConnect>();  //UPDATED
        this.name = name;
    }

```

Similarly, our connect() method is going to accept `IConnect`.

```java
//Network.java

    public void connect(IConnect device){ //UPDATED
        devices.add(device);  //UPDATED
    }
```

Believe or not, all of our tests still pass!!!!

How can this be?

## Magic

The beauty of "polymorphism" is that any type can behave as if it is any of it's super class types as well as it own. Our Desktop can be both a Desktop and an IConnect, like we mentioned earlier. So anything accepting IConnect can accept a Desktop.

However, it does NOT apply the other way round. Anything accepting a Desktop does NOT accept an IConnect. Not every IConnect is a Desktop! But every Desktop is an IConnect.


