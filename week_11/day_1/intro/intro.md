# Introduction

## Learning Objectives
 - Install IntelliJ IDE
 - Create a Java project in IntelliJ
 - Know what a statically typed language is
 - Understand how compiled languages differ from interpreted languages
 - Be able to write, compile and run a Java program.

## Introduction

So we have looked at Object Orientated programming in Ruby so far. This is fine as Ruby does lend itself well to OO programming for lightweight applications.

Imagine you are a developer working on a large enterprise code base where there are tens to hundreds of classes and millions of lines of code.  

Ruby is a Dynamically Typed language though and this means that, while it can be forgiving, it can sometimes lead to mistakes at a more enterprise level of programming.

No type declaration on a method means you do not have any type information coming in or going out of it. Now the question is, can you consume this function without any documentation or going through/understanding the code completely?

Also when you are creating instances can you be sure that you are creating an instance of the right thing? And that it can't be changed later.

For example...

## Dynamically Typed

```bash
#terminal

touch ruby_play.rb
```

```ruby
#ruby_play.rb

class Cat
end

class Dog
end

myCat = Cat.new
myCat = Dog.new
```

```bash
#terminal

ruby ruby_play
```

The variable myCat has been assigned to first a Cat object and then a dog object.
Ruby has no problem with this.
Variables are just variables they don't care what type of object they refer to.
Ruby is chill.

## Statically Typed

Statically types languages are much more uptight.
Variables need to know what kind of thing they are referring to, and always have to refer to that type of thing.

## Intro to Java

> Give out starter code and open in Atom

In Java unlike Ruby, we can't just run any java files directly from the terminal. We need to have an entry point for the program to start from.

Look at Runner.java. In here we have a Main method. Every java console program needs this method in order to run in the console. (Unless we are just using tests in a TDD fashion which we will cover later).

> Don't worry about the void/static etc as we will understand what all those words mean over the week.

``` bash
#terminal

cd intro_start_point
java Runner

```
 > Note we don't need to specify the file type i.e. Runner.java as java will look for a specific file type.

We get an error if we do this telling us
`Error: Could not find or load main class Runner `

What needs to happen first is that we need to compile the java files into something that the computer can use. These are called class files.

We do this by typing the word `javac`.  This stands for java compiler.  Most statically typed languages involve a compilation step.  It is here that the type checking happens, among other checks.  Remember those 'no method errors' in Ruby.  All these errors will be caught at compile time in a statically typed compiled language. It also gives us the ability for much more powerful tooling as our editor/IDE can tell us when something is of the wrong type immediately.  We will see this later on.

Using `*.java` runs `javac` on all the files with a `.java` extension, saving us having to type out each file separately.

``` bash
#terminal

javac *.java
```

Our compilation succeeds.  The compiler is happy that the code is free from any syntax errors that may have otherwise caused compilation to fail.  The compiler produces 'not for humans' files, which can now be executed.

``` bash
#terminal

java Runner
```

Yay we have some output.

So this is all good and well but there are a lot of problems you can face if you are trying to write larger java applications using a text editor.

If there are any errors which may cause a compilation error you won't find out until you run `javac` on the files. These can be mainly things like syntax errors and missing methods etc. The kind of things that we would maybe not notice until compilation time. Also there are a lot of extra things that we may need to do in order to get our application up and running such as importing libraries to use,

Wouldn't it be nice if we had an environment where any errors are highlighted straight away so we can fix them and where the majority of our imports are done for us to make sure we don't forget?

Enter the IDE.....

## IntelliJ

We are going to be using an IDE called IntelliJ for the next 2 weeks.

An integrated development environment (IDE) is an application that facilitates application development. IDEs offer a central interface featuring all the tools a developer needs, including the following:

- Code editor: This feature is a text editor designed for writing and editing source code. Source code editors are distinguished from text editors because they enhance or simplify the writing and editing of code.
- Compiler: This tool transforms source code written in a human readable/writable language into a form executable by a computer.
- Debugger: This tool is used during testing to help debug application programs.

So first off we need to install IntelliJ.

```bash
#terminal

brew cask install intellij-idea-ce
```

Open up IntelliJ and lets start a new Java project.

```
#IntelliJ

Create New Project

```

We are going to use a tool called Gradle to help us with our applications.

Gradle is a dependancy management tool that will allow us to add libraries to our application that we will need to use. Remember in ruby we did all those gem install commands to add libraries to our programs? Gradle does a similar thing.

We will explore Gradle in more depth as we go through this course.  

```
# IntelliJ

Click on Gradle in the left hand pane
Make sure java is checked in right hand pane
Next

GroupId: com.codeclan.example
ArtifactId:  IntroToJava (Our application name)
Version: Leave as it is.
Next

Check Use auto-import
Leave all other settings as they are
Next

Change project location to your codeclan_work/week_6/day_1 folder
Finish
```

IntelliJ now creates our project for us and installs what we need to get started.

Expand `IntroToJava` folder and then expand `src` folder.

You will see that we have two folders in here.
There is one called `main` where all our java files will go and another called `test` where our test files will go.

There are a lot of other folders in here but we don't need to worry about those for just now.

So lets start off by creating some Java classes

```
#IntelliJ

Expand main folder
Right click on java folder.
New > Java Class
Name: Cat
Kind: Class
Ok
```

So now IntelliJ creates our new class called `Cat` and pre-populates it for us with a basic class structure.

Please note that in Java the class names are always capitalised and that the file name has to match the class name in the same way. If the file name wasn't capitalised we would get an error.

#### Task

Create 2 more java classes in this folder. One called `Dog` and one called `Runner`.

``` java
//Cat.java

class Cat{
}
```

``` java
//Dog.java

class Dog{
}
```

Open the Runner class and lets add a main method so we can start our application.

``` java
// Runner.java

class Runner{
  public static void main(String[] args){ //added
    Cat myCat = new Cat(); //added
    myCat = new Dog(); //added
  }
}
```

Let's focus on lines 4 and 5 in Runner.java. IntelliJ is being helpful and showing us that there is an error on line 5 by showing a red underscore.

>Hover over it and you will see an error message.

## Compile time vs Runtime errors

This is an example of a Compile time error.

There are two types of errors we may see. Compile time means any error that will cause compilation to fail. These can be things like trying to call missing methods, syntax errors, passing wrong number of arguments to methods.

The other type of error is a runtime error. These won't fail compilation as they look fine but when the program tries to run it will fail. These can be things like trying to divide by 0, accessing a file that is missing, accessing an index of an array that isn't there. More on these later.

In Ruby because there is no compilation stage all errors are highlighted when you try and run the script.

In above example we are creating a myCat variable and assigning it to a Cat object.  What's different here from the Ruby version?  The variable has been given a type Cat.  Because this variable is for this type and this type only, we can't assign it to a Dog object.

[Expected q:  Why would a language ask for this]

Statically typed languages give us an extra level of protection.  We can be sure that the type we are given is what we expect.  This will come more apparent when we are creating functions/methods.

Let's remove line 5 as we can't do this now.

```java
//Runner.java

class Runner{
  public static void main(String args[]){
    Cat myCat = new Cat();
    // deleted line 5
  }
}
```
## Running the Program in IntelliJ

Ok so how do we run this program?

```
#IntelliJ

Right click on the Runner file in the project pane.
Select Run Runner.main()
```

> You may see a warning about JavLaunchHelper being implemented in 2 places. We can ignore this warning.

We have run our first program.  No output!  Let's give the cat a little meow method.

``` java
//Cat.java

  class Cat{
    public void meow(){
      System.out.println("Hello Meooooow");
    }
  }
```

System.out is just like puts (ruby) or console (JS).
Let's ask our cat to meow!

>Notice that when you start to type in cat in runner it will show suggestions for autocomplete listing available methods in the cat class.

``` java
//Runner.java

  class Runner{
    public static void main(String args[]){
      Cat myCat = new Cat();
      myCat.meow();
    }
  }
```

Because we have already run our Runner file that at the top right of IntelliJ there is a green arrow and the drop down now says Runner. This means we can now re run the program by simply clicking on the arrow.

Yay our cat now Meows.


## SOLID and 4 Pillars of OOP

As we go through the next few weeks you will get to see more and more features of the IDE and understand how it can be a very powerful tool for developers.
We will also delve further into the structure, keywords and syntax of Java to see how it all comes together to create type-checked applications and the benefits this can bring.

There are 2 concepts we will be covering throughout the next 2 weeks. SOLID and the 4 pillars of object orientated programming.

These concepts are not really anything new as, so far, we have already been adhering to most of these.

SOLID is a set of 5 principles to adhere to when writing code. They make it easy to maintain your applications and make them more robust.

In order to manage so many classes and to reduce the complexity, system designers use several techniques which can be grouped under four main concepts. These are the 4 pillars of OOP.

We won't go into any depth about these just now but we will fill in the blanks for each as we go along.

> Instructor: Write SOLID and 4 pillars as headings on board
> 
> For Reference. SOLID stands for:
> 
> - **S**ingle responsibility principle
> - **O**pen/closed principle
> - **L**iskov substitution principle
> - **I**nterface segregation principle
> - **D**ependency inversion principle
> 
> 4 Pilars are:
> 
> - Abstraction,
> - Encapsulation,
> - Polymorphism,
> - Inheritance


## Summary

We've seen:
 - How to install IntelliJ IDE
 - How to create a Java project in IntelliJ
 - What a statically typed language is
 - How compiled languages differ from interpreted languages
 - How to write, compile and run a Java program.
