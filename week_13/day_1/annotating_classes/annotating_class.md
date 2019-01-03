# Annotating Classes for Persistence

**Lesson Duration: 60 - 90 minutes**

### Learning Outcomes

- Know what an ORM (Object-relational mapping) is and how it is useful
- Be able to map classes to a database with Hibernate (via Spring and Spring Boot)
- Be able to use some basic JPA Annotations

## Introduction

**Why are we learning this?** When building a Java back end web applications, being able to use interact with databases is crucial. Using an ORM (Object-relational mapping), such as Hibernate, helps us by handling the common mapping functionality.

Previously we have had to map our objects to database tables manually, creating the SQL statements that insert the objects, by mapping an object's properties as column names. This is something developers often want to do in the same way, so an ORM implements this default functionality so we can use it out of the box.

**What are we building?** A web app for managing `Pirate` objects with Spring and Hibernate, with an API index end point, that gets all the pirates.

**You will be able to:** perform CRUD operations and persist the data into a Postgres database, as well as having creating API end points.

- Persist objects to Postgres via Spring + Hibernate
- Enable `RestController` on routes to GET JSON data back

> Note: We are using the Spring Boot code from the last lesson. There is also a starting point project available.

## Part 1: Mapping our Pirate class

### Add a new model class Pirate

We will start by creating a `Pirate` class which will be our "model" for pirates in the database. In general terms 'Model' is a term used for an entity (in this case a Java class) that acts as the template or schema for a table in a database.

Since we want to keep all models together, we start by creating a package for all models:

1. Create a new package in `com.example.codeclan.pirateservice` by right clicking on `com.example.codeclan.pirateservice` - new > package. Give it the name 'models'.
2. In 'models', create a new Java class called `Pirate`.

### Task: (5 minutes)

1. Create the `Pirate` class properties:
  - `firstName` (String)
  - `lastName` (String)
  - `age` (int)
2. The `Pirate` constructor should take the above arguments
3. Add getters and setters for each of the properties

<details>
<summary>Solution</summary>

```java
// Pirate.java

public class Pirate {

  private String firstName;
  private String lastName;
  private int age;

  public Pirate(String firstName, String lastName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
  }

  public String getFirstName() {
      return firstName;
  }

  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  public String getLastName() {
      return lastName;
  }

  public void setLastName(String lastName) {
      this.lastName = lastName;
  }

  public int getAge() {
      return age;
  }

  public void setAge(int age) {
      this.age = age;
  }
}

```

</details>

### POJO

In order to save instances of a class to a database with Java when using an ORM, the class must follow the POJO (Plain Old Java Object) rules:

- All attributes that you want to save to the database should be private and have getter and setter methods.
- All Java classes that will be mapped need a default constructor (an empty constructor that takes no arguments), in additional to any required constructors that take arguments.
- All classes need a `id` of type `Long` (a very big Integer) in order to allow Hibernate to map the property to the primary key column of a database table.

So we will first of all change our `Pirate` class to match these rules.

```java
// Pirate.java

public class Pirate {

  private Long id; // NEW
  private String firstName;
  private String lastName;
  private int age;

  public Pirate(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public Pirate() { // NEW

  }

  public Long getId() { // NEW
    return id;		
  }

  public void setId(Long id) { // NEW
    this.id = id;
  }

  // ...

}

```

Ok, so now our class is ready to be mapped to a database table using Hibernate.

## Hibernate + JPA Annotations

JPA stands for Javax Persistance API. Hibernate + JPA annotations are a way to define how classes are mapped to tables in a database.

We have already seen the use of annotations in our test files. `@Before`, `@Test`, etc that allows JUnit to identify specific actions we want to perform. Annotations for Hibernate + JPA are added to the Java classes in the same way. This way we can quickly understand the database table structure relating to the class, as it will be visible in the class itself.

Hibernate + JPA annotations come from a set of standards known as EJB 3 (Enterprise Java Beans). Following these standards allows you to transfer your application from one database type to another (for example, PSQL to mySQL).

### Mapping a Class to a Table

We are going to add come annotations that let Hibernate know how to map our class to a database table. The EJB 3 standard annotations are located in a package called `javax.persistence`, so we need to import what we need from this package.

- The `@Entity` annotation lets Hibernate know that we want to map this class to a database table.
- The `@Table` annotation tells Hibernate the name of the table we want to map to.

```java
// Pirate.java

import javax.persistence.Entity; // NEW
import javax.persistence.Table; // NEW

@Entity // NEW
@Table(name="pirates") // NEW
public class Pirate {
  // ...
}
```

> Note: If we left the name blank Hibernate would create a table with the same name as the class (`pirate`), but convention says that our table name should be plural.

### Mapping the ID to a Primary Key

Each database table will have a primary key, and we tell hibernate which property we want it to use for the primary key by using the `@Id` annotation. We are going to use the `id`property.

We are also going to tell it to generate the value for the `id` primary key using the `IDENTITY` strategy. This uses an auto-incremented value generated by the database.

```java
@Id // NEW
@GeneratedValue(strategy = GenerationType.IDENTITY) // NEW
private Long id;
```

So at the point the object is instantiated, its `id` property is `null`. When it is saved into the database, the value for the `id` is generated and used as the primary key.

### Mapping Properties to Columns

The `@Column` annotation is used to map the object's property to a column. There are a set of values we can give `@Column` to specify the details of the column.

- `name` specifies the name of the column. (Left blank Hibernate will use the property name)
- `length` specifies the size of the column.
- `nullable` when set to true, allows `null` values in the column. When set to false Hibernate marks the column as `NOT NULL` and disallows 'null' values.
- `unique` specifies that the column should contain only unique values.

For now, we will set the name of each column, using the property name with snake case syntax.

```java
@Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  @Column(name = "id") // NEW
  private Long id;

  @Column(name = "first_name") // NEW
  private String firstName;

  @Column(name = "last_name") // NEW
  private String lastName;

  @Column(name = "age") // NEW
  private int age;
```

## JPA Repository

The JPA (Javax Persistence API) Repository sits between the models and the database to allow you do operations (like CRUD) on the database from the program logic. We use Spring's JPA Repository interface to do this.

We will create our own repository for any model we wish to do database operations with. In this case we have one, our `Pirate` model, so the repository will be called `PirateRepository`. It will borrow functionality from the `JpaRepository` by inheriting from it. As we don't want to override all the functionality of `JpaRepository`, our `PirateRepository` should be created as an interface.

Note: An interface can inherit one or more interfaces.

## Creating a `PirateRepository`

- Create a new package inside `com.example.codeclan.pirateservice` called `repositories`
Note: all repositories we create will live in here
- Inside the 'repositories' directory create an interface called `PirateRepository`

We now need to extend the JpaRepository interface to borrow its behaviours. We also need to tell the `JpaRepository` the type of object we are creating the repository for (`Pirate`). Lastly we need to specify the indexing system (`Long`). The indexing system limits the maximum number of entries we can do queries on.

```java
package com.example.pirateservice.repositories;
import com.example.pirateservice.models.Pirate; // NEW
import org.springframework.data.jpa.repository.JpaRepository; // NEW

public interface PirateRepository extends JpaRepository<Pirate, Long> { // MODIFIED
}

```

This is a perfect example of Interfaces and Inheritance in real applications. This pattern allows us to use some of the parent interface's functionality, whilst still giving the opportunity to add our own. For now, we only want what's provided by `JpaRepository`.

### Annotating the Repository

In Spring, a Repository is a general way of accessing some external resource (often a database) and performing actions on it. We need to tell Spring that this interface is a Repository. We will use the `@Repository` annotation and place it above the interface declaration to do this.

```java
@Repository //NEW
public interface PirateRepository extends JpaRepository<Pirate, Long> {
}
```

> Note: Make sure `Repository` is brought in via the `org.springframework.stereotype.Repository` dependency.

Nothing will be put into this interface yet. For now, we will use the methods provided to it by `JpaRepository`.

## Saving a `Pirate` into the Database

We are going to use a test to instantiate a `Pirate` and save it into the database using the repository we have just created.

### Task: (5 minutes)

Inside test / Java / com.codeclan.pirateservice / PirateserviceApplicationTests create a test called `createPirate` that instantiates a `Pirate` object with the following properties:
- first name: "Jack"
- last name: "Sparrow"
- age: 32

> Note: The text doesn't need to assert anything at the moment.

<details>
<summary>Example solution</summary>

```java
@Test
	public void contextLoads() {
}

@Test // NEW
public void createPirate(){ // NEW
	Pirate jack = new Pirate("jack", "sparrow", 32);
}
```

</details>

We know that we want to use our `PirateRepository` to save our `Pirate` object into the database, so we need it available to use in the test. To do this we are going to use Dependency Injection.

## Dependency Injection

Dependency Injection is where an object is instantiated somewhere else and then given to you; the instance is 'injected' as a dependency. In Spring we can use the annotation `@Autowired` on a class property to ask the framework for an instance of a class to be provided as the dependency.

Looking inside `PirateserviceApplicationTests.java`, we wish to **Dependency Inject** the `PirateRepository`. We can give the test class and instance of `PirateRepository` using `@Autowired` annotation.

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceApplicationTests {

@Autowired // NEW
PirateRepository pirateRepository; // NEW

// ...

}
```

## Save the Object to the Database

Now we've dependency injected `PirateRepository`, it can be used to save the newly created pirate to the database.

```java
Pirate jack = new Employee("Jack", "Sparrow", 30);
pirateRepository.save(jack);
```

## Spring application.properties

We've already told Spring where our database is, but now we are going to set a couple more settings to specify how we want Spring to handle database schema updates and queries with relationships.

Open up `application.properties` and add:

```
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
```

#### DDL-auto setting

`spring.jpa.hibernate.ddl-auto = update` is a setting that tells Hibernate + Spring that when we make changes to the database schema (the structure), the changes should be applied to the database.

There are some other value options for various situations. They are:

- **validate**: validate the schema, makes no changes to the database.
- **update**: update the schema.
- **create**: creates the schema, destroying previous data.
- **create-drop**: drop the schema when the application is stopped, then re-create the schema when it's started again.

#### Enable Lazy Load

`spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true` allows the option to do "lazy loading". This simply means that when querying data on models with relationships, Hibernate will not bring back every single element for both sides of the relationship. This is good for not bringing back unnecessary data.

Let's run the test to save the object to the database and then use the postgres shell to check it has been inserted.

1. Run the test
2. Check the table:

```sh
psql -d pirateservice -U postgres
SELECT * FROM pirates;
```

It show show:

```
pirateservice=> select * from pirates;
 id | age | first_name | last_name
----+-----+------------+-----------
  1 |  32 | Jack       | Sparrow

```

## Conclusion

We've seen how to map classes to a database using the ORM, Hibernate, (via Spring and Spring Boot) with JPA Annotations.

We also learned how to use dependency injection to inject the `PirateRepository` interface we created into where we need instances of it.

# Next Lesson

[Controller and JPA Repository Queries](../controller_and_jpa_repository_queries/controller_and_jpa_repository_queries.md)
