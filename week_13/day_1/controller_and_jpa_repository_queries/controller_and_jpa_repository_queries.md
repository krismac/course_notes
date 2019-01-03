# RestController and JpaRepository Queries

**Lesson Duration: 30 - 40 minutes**

## Learning Outcomes

- Know how to create controllers with Spring and dependency injection
- Be able to create a RESTful endpoint using Spring

## Introduction

**Why are we learning this?** We are creating a RESTFUL api, so we want to be be able to make requests (GET, POST, PUT, DELETE) to a set of API endpoints, that allows us to perform CRUD operations on our database.

**What are we building?** A web app for tracking Pirates with Spring and Hibernate that will allow us to call API endpoints to perform CRUD operations and persist the pirate data into a Postgres database.

**You will be able to:** enable `RestController` on routes to GET JSON data back for all Pirates we create.




**RESTful** typically has the front-end being hosted from a different location on the web from the back-end.
Data is passed between back-end and front-end by HTTP request/responses. The front-end application makes these HTTP requests and renders the data when it's received.

We will be implementing a set of RESTful routes, using the RESTFUL Controller, exposing an index routes that returns all the pirate data.

## Creating the `PirateController`

1. Create a new package called 'controllers' inside `com.example.codeclan.pirateservice`
2. Inside 'controllers' create a new Java class called `PirateController`

To tell Spring this is a RestController, we use the annotation `@RestController`.

We use the annotation `@RequestMapping` to specify the base URL for the controllers endpoints.

```java
@RestController // NEW
@RequestMapping(value = "/pirates") // NEW
public class PirateController {    
}
```

This means that all routes in this class will be accessible within `/pirates`.

### Inject PirateRepository

Like before, we ask Spring to simply inject an instance of our `PirateRepository` into our controller so we can use it:

```java
public class PirateController {
  @Autowired // NEW
  PirateRepository pirateRepository; // NEW
}
```

### Find all Pirates
We will define the method that will return the data we want to serve up on the route. As we are creating the index route, we will return a list of all the `Pirate`s from the database.

```java
public class PirateController {
  // ...

  public List<Pirate> getAllPirates() { // NEW
      return pirateRepository.findAll();
  }
}
```

We use the `@GetMapping` annotation to map a route to a method. We are going map `getAllPirates` and because we are not going to pass the annotation a path, it will use the base route path defined in `@RequestMapping`.

```java
public class PirateController {
  // ...

  @GetMapping // NEW
  public List<Pirate> getAllPirates() { // NEW
      return pirateRepository.findAll();
  }
}
```

> Note: `@GetMapping` is simply a version of the commonly used `@RequestMapping` with the method already set to GET

We can also give `@GetMapping` arguments for sub routes as is common practice.  

> TASK: Try changing the routes values in the annotation to: `@GetMapping(value = "/")` or `@GetMapping(value = "/getallpirates")`

We will keep the getAllPirates just with no mapping, meaning it will be called only on `/pirates` but `/pirates/` with the trailing slash will work, too.


### Find one Pirate

We can get a single pirate by id on the `/pirates/id` route by grabbing the `id` from the route using the `@PathVariable` annotation.

Since we are unsure if `findById` on the repository will return a `Pirate` or `null` we should return an `Optional`. Optional is a container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.



```java
// PirateController.java
@GetMapping("{id}")
public Optional<Pirate> getPirate(@PathVariable Long id){
    return pirateRepository.findById(id);
}

```

To make better use of `Optional` the checks should be done to check the contained value and handle appropriately. Fortunately `Optional` can be serialised to the value it contains.

## Run it
Run the application runner (`PirateserviceApplication`) and go to `http://localhost:8080/pirates` where some JSON output of the pirates should be shown.

# Summary

We've seen how to build a RESTful controller easily with spring and have it return a JSON version of our object

# Next Lessons

**Now: Lab** - [Lab - Bootstrap a new Spring Project](../lab_bootstrap_new_spring_project/lab_bootstrap_new_spring_project.md)

**Later: Homework** - Learn about Many to One and Many to Many database relationships with Spring with these flipped lessons:

* [Learn Many to One](../homework_relationships/hw_one_to_many.md)
* [Learn Many to Many ](../homework_relationships/hw_many_to_many.md)



### Thinking in Spring

With Spring, it's a common pattern to create classes, annotate them (which means to add little code snippets to give them some functionality) and then never actually directly instantiate them ourselves. This is something that will seem strange at first, but after time will make sense and seem natural.
