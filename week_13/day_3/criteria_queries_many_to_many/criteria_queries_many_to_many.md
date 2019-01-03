# Criteria Queries on Relationships - Many to Many

**Lesson Duration: 45 minutes**

### Learning Objectives

- Be able to build criteria queries for Many to Many



# Introduction
The motivations behind querying many to many are the same as one to many.



## Building A Criteria Query

Lets put together a query to get a list of pirates back for a given raid.






### Know what data you have and want back.

We have a `Raid` and want to get the `Pirate`s for that `Raid`. Our starting point is a raid, but technically we're doing a query on the `Pirate` model.

This means we should expect to get a `List` of `Pirate` back.

We can start to build a skeleton for the query we want to create since we know what we want back, and what we're putting in. Since this is an implementation, i.e, the method has a body, this will go in `RaidRepositoryImpl.java`


```java
public List<Pirate> getPiratesForRaid(Raid raid) {
	List<Pirate> results = null;
	
 	return results;
}
```






### EntityManager and Session to create Critera

Since we're building a `Criteria` query the same way as with the one-to-many query, the `EntityManager` and `Session` objects are needed.

```java
@Autowired                     // NEW
EntityManager entityManager;   // NEW

@Transactional         // NEW
public static List<Pirate> getPiratesForRaid(Raid raid) {
	List<Pirate> results = null;
	Session session = entityManager.unwrap(Session.class); //NEW
	Criteria cr = session.createCriteria(Pirate.class); //NEW
	
}

```

Since the `EntityManager` is being used in this query, the method must be annotated with `@Transactional` - this tells the EntityManager to treat this method something which will use a transaction to query the database.

### Aliases
 
When we have a class on the many side of a relationship and wish to get some results from the other side we can create an alias that allows "looping" through each element of the list on the many side.
We can then make use of that alias to add restrictions on that element.

An alias can be created for a list property with:

```java
    cr.createAlias("raids", "raid");
```
where `raids` is the name of the property in that class that is a `Collection` or `List`. `raid` is the newly created alias that represents an element of that list. `raid` can then be used in subsiquent restrictions within that criteria query.

For example


```java
    cr.createAlias("raids", "raid"); // Create a new alias 'raid' for each element of raids
    cr.add(Restrictions.eq("raid.id", raid.getId()));  // use the 'raid' alias to check a property of the element and do some comparison.
 
```
The alias `raid` is used in the line after it's created to go into that element and then access the id with `raid.id`.

Imagine the alias is like a variable created for a loop body that represents one element of the structure being looped over. Much like the varible `item` in `for (String item: items){}`.

We can use this to get access to elements within the list and compare them. We need to find all the `Pirate`s for a given raid.

Putting this together, along with a try/catch to make us aware of any issues, the query to get pirates for a given raid using aliases looks like the following:

```java
// RaidRepository.java

@Autowired
EntityManager entityManager;

@Transactional
public static List<Pirate> getPiratesForRaid(Raid raid){
  List<Pirate> results = null;
	Session session = entityManager.unwrap(Session.class); //NEW
  try {
    Criteria cr = session.createCriteria(Pirate.class);
    cr.createAlias("raids", "raid"); // ADDED
    cr.add(Restrictions.eq("raid.id", raid.getId())); // ADDED
    results = cr.list();
  } catch (HibernateException ex){
    ex.printStackTrace();
  } finally {
    session.close();
  }
  return results;

}

```

Finally, put the method signature `public List<Pirate> getPiratesForRaid(Raid raid);` into the `RaidRepository` and `RaidRepositoryCustom` interfaces. Then check that `RaidRepository` extends `RaidRepositoryCustom`.

# Summary

- We now know build criteria queries for Many to Many
- We learned how to use aliases in criteria queries
