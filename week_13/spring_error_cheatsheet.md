
## Forgetting the @Transactional annotation on a custom query method

### Problem
```
org.springframework.dao.InvalidDataAccessApiUsageException: 
No transactional EntityManager available; 
nested exception is java.lang.IllegalStateException:
No transactional EntityManager available
```

### Solution

You've created a custom query in a RepositoryImpl class, but neglected to add the `@Transactional` annotation to the method that implements that query

## Missing @JsonIgnore

### Problem

```
Cannot render error page for request [/api/pirates] and exception [Could not write JSON: Infinite recursion (StackOverflowError);
```

### Solution

A model property that's being used for relationships needs to be annotated with `@JsonIgnore`



## I got a null pointer exception

### Solution

Did you remember to `new` up your list in the model constructor?
### Still have an NPE?
 Are you sure you're giving your model what it needs in terms of passing related models via the constructor?
 

## Invocation of init method failed
### Problem
 ```
 Error creating bean with name 'restaurantRepository': Invocation of init method failed; nested exception is java.lang.IllegalArgumentException
 ```
 
Did you annotate you repository with `@Repository` ??

 
## org.hibernate.TransientPropertyValueException
### Problem
```
org.hibernate.TransientPropertyValueException: Not-null property references a transient value - transient instance must be saved before current operation
``` 
### Solution

You've likely tried to create a class, but forgotten to saved the instance of it to the database before using it in a related object.


## PropertyReferenceException: No property  found for type <Class>

### Problem
```
Caused by: org.springframework.data.mapping.PropertyReferenceException: No property getRestaurantsForStarRating found for type Restaurant!
```
When making a new query method in your RepositoryImpl class, the method prototypes need to be moved across to the the Repositor and RepositoryCustom interfaces. 

Make sure they match the method defined in the Impl

## Unable to POST to collection with relation
When posting something like:

```
{
	"firstName": "Jimmy",
	"lastName": "Nail",
	"age": 32,
	"ship": "http://localhost:8080/ships/1"
}
```

You will have errors if the `ship` property still as a `@JsonIgnore`.

## Name your repositories consistently.
if you ever get an odd error similar to:


```
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'dataLoader': Unsatisfied dependency expressed through field 'shipRepository';
 nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'shipRepository': Invocation of init method failed;
  nested exception is java.lang.IllegalArgumentException: Failed to create query for method public abstract java.util.List com.example.codeclan.pirateservice.repository.ShipRepoCustom.getPiratesForShip(com.example.codeclan.pirateservice.models.Ship)! 
  No property getPiratesForShip found for type Ship!
```

This possibly means you've not correctly named your custom repository classes.

If you’ve added a `ThingRepository`.. Spring will look for the `ThingRepositoryImpl`. Check the naming if your repository classes and interfaces!
