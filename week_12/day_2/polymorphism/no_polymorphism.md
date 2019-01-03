# A World Without Polymorphism

### Learning Objectives

- Understand method overloading
- Understand the need for polymorphism

## Intro

> Open start code and read through it for a few minutes

Basically we're modelling a simple computer network. We've got a class `Network` which has a collection of `Desktop` items, stored in an ArrayList.

But now we've decided that we don't just want our network to contain desktops. We also want to be able to add printers to the network.

At the moment our printer is going to be a bit boring and can do nothing but print the data it is sent.

Lets create a new `Printer` class in main package.

```
#IntelliJ

Open the Network program and create a new Java class called Printer in the 'main' package. 
Also, in the 'test' pack create a class called 'PrinterTest'
```


```java
//PrinterTest.java

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrinterTest {
    Printer printer;

    @Before
    public void before() {
        printer = new Printer();
    }

    @Test
    public void canPrint(){
        assertEquals("printing: Hello World", printer.print("Hello World"));
    }
}
```

```java
//Printer.java

public class Printer {

	public String print(String data){
    	return "printing: " + data;
  	}
}
```

## Method overloading

Now, we have a bit of a problem. Our network can only hold `Desktop`, and we want to add Printers. Also, our `connect` method can only take a `Desktop`.

[TASK:] Have a go at finding a solution to the problem. 15 mins.

Cool, so let's have a look at a really crude solution to this problem.

```java
//NetworkTest.java

  Network network;
  Desktop Desktop;
  Printer printer; //NEW

  @Before
  public void before() {
      network = new Network("CodeClan");
      desktop = new Desktop("Keith's Desktop", "Apple", "Macbook Pro");
      printer = new Printer();
  }

  @Test  
  public void canConnectPrinter() {  //NEW TEST
      network.connect(printer);
      assertEquals(1, network.deviceCount());
  }
```

So we currently have a compiler error, since we can't pass a Printer type to a method which is expecting a Desktop. The easiest way to fix this is `method overloading`. This is where we can define a method with the same name, but different parameters.

```java
//Network.java

  public void connect(Printer printer){
    devices.add(printer);
  }
```

We have a new problem, since our devices only accepts Printer! The easiest way to fix this is to declare a new ArrayList to hold printers and to change our old ArrayList's name to reflect that it is, indeed, a deviceList for Desktops.

We'll have to change all our references to `devices` to `devicesDesktop` in order for it to compile.

```java
//Network.java

public class Network {
    private String name;
    private ArrayList<Desktop> devicesDesktop;  //UPDATED
    private ArrayList<Printer> devicesPrinter;  //NEW

    public Network(String name){
        this.devicesDesktop = new ArrayList<Desktop>(); //UPDATED
        this.devicesPrinter = new ArrayList<Printer>(); //NEW
        this.name = name;
    }

    //...

    public void connect(Desktop desktop){
        devices.add(desktop);
    }

    public void connect(Printer printer){
        devices.add(printer);
    }

    //...
}
```

In order to make all our test pass, we have to change our deviceCount method, so it adds up the amount of food in the devicesDesktop and devicesPrinter.

```java
//Network.java

public int deviceCount(){
  return devicesDesktop.size() + devicesPrinter.size(); //UPDATE
}
```

Now our test should pass. If we slightly modify our test for emptying the devices list after a disconnecting everything from the network, we have a wee problem to fix.

```java
//NetworkTest.java

  @Test
  public void shouldEmptyDeviceListAfterDisconnectingAll(){
    network.connect(desktop);
    network.connect(printer);
    network.disconnectAll();
    assertEquals(0, network.deviceCount());
  }
```

The device still has 1 item in it! Let's go fix this.
Lastly, we need to fix the sleep method.

```java
//Network.java

  public void disconnectAll(){
      devicesDesktop.clear();  //UPDATED
      devicesPrinter.clear();  //UPDATED
  }
```

Now our tests should pass. Phew! That was a LOT of work.

## It's a bit stinky

So this has indeed solved our problem. But now we have 2 separate collections for different device. What happens if want to add other network devices like servers, laptops, mobile phones?? Are we going to make new collections and new method overloads every time?

Luckily, there is a better way. Polymorphism to the rescue!!
