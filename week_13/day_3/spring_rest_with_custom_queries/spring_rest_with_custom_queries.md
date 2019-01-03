# Spring Data REST with custom Queries

**Lesson Duration: 30 minutes**

### Learning Objectives
- Be able to build robust REST APIs that make use of Spring Data REST as well as custom queries


# Introduction
**Why are we learning this?** A higher level of API sophistication is easily achievable by combining Spring Data REST for all CRUD and and RESTful endpoint construction along with carefully planned custom endpoints which use custom queries.

**What problem are we trying to solve?** **By the end of this lesson you will be able to**

By the end of the lesson we will be able to connect custom endpoints not already created for us with Spring Data REST into custom queries written with Criteria Queries.

**Let's connect the `findAllPiratesOver(int age)` query to a route to improve the functionality of our pirate service.**

##  Custom Routes

Looking into `PirateController` we have a single endpoint. This is our only customised end-point. The others are generated for us with Spring Data REST.

Firstly, change the the `@RequestMapping("/api")` over to `/pirates`, as this class is the one place for custom pirate endpoints.

Let's create a route that doesn't step on the ones generated for us, but also provides functionality. We should create a route on `/older/{age}` to give us the pirates older than the given `age`.

We will take the age from the path as a variable using the `@PathVariable` annotation which works as follows:

```java
 @GetMapping(value = "/older/{age}")
public List<Pirate> findAllPiratesOver( @PathVariable int age){
    return pirateRepository.findAllPiratesOver(age);
}
```

`@PathVariable` makes the annotated variable's value that of the one provided in `{age}`. We can then simply pass the age into our already created custom query.
