# Junit with Gradle

## Junit

JUnit is a unit testing framework for the Java programming language. JUnit has been important in the development of test-driven development.

JUnit is included in IntelliJ and is installed through Gradle.

JUnit, along with other libraries is available as a JAR (Java ARchive) file.

A JAR  is a package file format typically used to combine many Java class files and associated resources (text, images, etc.) into one file for distribution.

## Gradle

Gradle is an advanced general purpose build management system based on Groovy and Kotlin. Gradle supports the automatic download and configuration of dependencies or other libraries.

```
# IntelliJ

Open build.gradle
```

In build.gradle you will see the following:

```
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

IntelliJ has added JUnit as a dependencies for our project for us.

This means we now have access to the classes and methods included in JUnit. Similar to how we used MiniTest.

We can create functions marked as tests to run, create a setup method to be ran before each test and use assertEqual methods to check our results.  

This is one of the powerful features of Gradle and it saves us having to download all the JAR's we may need for projects and adding them to our libraries manually.

You can add available packages through Gradle from SQL libraries through to other testing tools to make them available for use in your applications. 
