# Packages and Access Modifiers

## Learning Objectives

- Understand that you can organise your code in packages

## Introduction to packages.

Packages are essentially groups of classes in a folder. The purpose is to organise your classes in a structured way. You guys have already seen them when you created a new project. You had 3 packages, one to store your code, one to store your integration tests, one to store your unit tests.

Now we are going to work off a simple project that has a few packages.

```
    Hand out packages start point
```

> See table [here] (https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

Okay, we can see we have two packages, one for animals and one for humans. These packages will contain the respective code. A dog is inside the animal package and has a public string name and bark, and human class inside the human package and has a teach method that accepts a dog class.

So if we we were look at the folder structure of our codebase. It would look like this (each package name is its own folder):

```

    / - codeclan
        / - com
            / - packagesexample
                / - animal
                    / - Dog.java
                / - human
                    / - Trainer.java
```

So in Ruby, when we wanted Trainer to see Dog, we would write a require_relative(./../animal/dog). In java we need to be more explicit. So we say

```
import codeclan.com.packagesexample.animal.Dog;
```

We could say

```
import codeclan.com.packagesexample.animal.*;
```

Which will import all classes from that animal package, but its considered bad practice if we only needed one. So change the import back to Dog.

We can create subpackages in packages (they will just become subfolders).

Create a package called air inside animal. Create Bird class.

Inside Trainer, we can import the Bird like so

```
   import codeclan.com.packagesexample.animal.air.Bird;
```

Note we cannot say

```
    import codeclan.com.packagesexample.animal.*;     
```

To import the bird, this is because * is not recursive, only pulls it in from that folder and not subfolders.
