# Relationships via APIs - Spring Data REST

**Lesson Duration: 30 minutes**

### Learning Objectives

- Understand how to create restful routes for associated collections
- Understand the basics of HATEOAS (Hypermedia as the Engine of Application State)

## Introduction

**Why are we learning this?** When there's a relationship between two or more models, it is valuable to be able to access that data via RESTful routes

**By the end of this lesson you will be able to**
Setup routing to be able to access the collections of raids in pirates and pirates in ships

### Spring Data REST

Working with REST using Spring is as simple as using the "Spring Data REST" project. [Spring Data REST](https://projects.spring.io/spring-data-rest/) is one part of the Spring Data project which allows REST webservices to be very easily built on top of Spring Data repositories.

> Hand out start point

We have a project with the models `Pirate`, `Ship` and `Raids`, with annotations that map their relationships. Now we can add Spring Data Rest and it will create the RESTful routes for those relationships.

### Seeding the Database

When doing both integration and unit testing, we will need a way to seed the database. Doing this will allow us to check relationships are setup correctly and that the data we expect is coming back. This will become especially valueable when testing custom queries.

With Spring, we can tap into Spring Boot's `ApplicationRunner`. By creating a class that inherits from `ApplicationRunner` we can override the `run` method which is called implicitly on Spring startup. It will be picked up by Spring and run if we use the `@Component` annotation.

Making use of the fact that this is run each time our Spring application starts. Create a package called `components` a new class `DataLoader` in it.

```java

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PirateRepository pirateRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    RaidRepository raidRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Ship dutchman = new Ship("The Flying Dutchman");
        shipRepository.save(dutchman);

        Ship pearl = new Ship("The Black Pearl");
        shipRepository.save(pearl);
        
        Pirate jack = new Pirate("jack", "sparrow", 32, pearl);
        pirateRepository.save(jack);

        Pirate john = new Pirate("John", "Silver", 55, dutchman);
        pirateRepository.save(john);

        Raid raid1 = new Raid("Tortuga", 100);
        raidRepository.save(raid1);

        Raid raid2 = new Raid("Tresure Island", 690);
        raidRepository.save(raid2);

        jack.addRaid(raid1);
        jack.addRaid(raid2);
        pirateRepository.save(jack);

        raid2.addPirate(john);
        raidRepository.save(raid2);
        
    }
}

```

### Now use create-drop setting

Since, we're now seeding the database, the `spring.jpa.hibernate.ddl-auto = update` setting should be set to `create-drop`.

```
spring.jpa.hibernate.ddl-auto = create-drop
```

This drops the db including it's schema every time the application is terminated. It's then created every time the application starts.


### Enabling Spring Data REST

Enabling Spring Data REST is as simple as adding the dependency to the `pom.xml`.

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```

Now run the application's `main()` in src / main / java / com.example.codeclan.pirateservice / PirateServiceApplication.java and visit the index route for the pirates resource ('http://localhost:8080/pirates') to see the pirates currently in the database.

### How does Spring Data REST work

Since we're using Spring JPA already and we've used standard annotations for creating model entities; Spring Data REST finds these resources and maps them to what it believes to be the best REST endpoints.

This means we can do all of the following:

* Get all pirates/raids/ships
  * GET `/pirates`
  * GET `/raids`
  * GET `/ships`
* Get one pirate / raid /ship
   * GET `/pirates/{id}`
   * GET `/raids/{id}`
   * GET `/ships/{id}`
* Get a pirate's raids
   * GET `/pirates/{id}/raids`
* Get a specific raid from a pirate
   * GET `/pirates/{id}/raids/{id}`

## HATEOAS (Hypermedia as the Engine of Application State)

Looking at [http://localhost:8080/pirates/](http://localhost:8080/pirates/) we should see:

```json
{
  "_embedded" : {
    "pirates" : [ {
      "firstName" : "jack",
      "lastName" : "sparrow",
      "age" : 32,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/pirates/1"
        },
        "pirate" : {
          "href" : "http://localhost:8080/pirates/1"
        },
        "ship" : {
          "href" : "http://localhost:8080/pirates/1/ship"
        },
        "raids" : {
          "href" : "http://localhost:8080/pirates/1/raids"
        }
      }
    } ]
	}
}
```

The JSON returned from `/pirates`. At a glance we can see some data that's expected, but on closer inspection there are some other pieces of data within that JSON we've not seen before.

What's new to us here is the way in which Spring represents the relationships that pirate has in it's "serialized" JSON form. The `_links` object within the single pirate has 4 other properties within it.

It's farily common to represent some meta-data (that's data about our data) in properties that begin with underscores. This is a REST practice called **[HATEOAS ⤴️](https://spring.io/understanding/HATEOAS)** which is a way to represent data links in RESTful responses and give other useful ways to navigate a services interfaces.

### `_links`

Looking individually at the properties inside the `_link` object above:

* **self** - Metadata simply linking to this same URL, and presumably this same data. Arguably not that useful, since we should hopefully know where we're looking already.
* **pirate** - Since we're already looking at a pirate object, this is much the same as `self`.
* **ship** - Many pirates can have one ship, as instructed by our `@ManyToOne` annotation on the `ship` property of `Pirate`. This `ship` link in the JSON for a pirate represents this. Notice that the value for `ship` is actually a link to the related ship.
* **raids** - Many pirates can be part of many raids. Setup by annotating the `raids` property inside `Pirate`. Spring Data REST sees this and gives us a link to the relating `raids` collection.

## Checking REST routes JSON responses

### Remove custom `/pirates` `getAllPirates()`

Should now be able to remove the the custom route for getting all pirates.
Remove: 

```java
//PirateController.java
   @GetMapping
    public List<Pirate> getAllPirates(){
        return pirateRepository.findAll();
    }
    
```
as this will now be handled by Spring Data REST and provided to us by that.


We can now use our understanding of HATEOAS and relationships between our models to check that the RESTful routes and JSON data generated by *Spring Data Rest* look correct for our needs.

### `/pirates/`
As expected, there is a route for all pirates which returns an array of pirates. Spring Data REST was able to work out that since we have many pirates in the database, a collection endpoint is needed. We know this is fairly standard REST practice.



### `/pirates/1`
Gives us the pirate with an `id` or `1`

### `/pirates/1/raids`
Gives back a list of raids for the pirate with `id` of `1`

### `/pirates/1/raids/1`
Gives back a raid with the `id` of `1` for a pirate with an `id` of `1`

## Manipulating HATEOAS - Projections

Why would we want to manipulate the data that RESTful HATEOAS gives us?

```json
"pirates" : {
      "href" : "http://localhost:8080/ships/1/pirates"
    }
```
**Links to related resources can make things more difficult on the front end as we will need to do sub API calls**

For example, once we have the data for a ship, then to get related pirates, we need to do a subsiquent call on the front-end. This can be cumbersome and difficult to work with.

The solution here is to use a **projection** in the back-end to customise what's returned for an API request. This will allow us to embed related objects inside each other rather than having links. For example to show `pirates` in a `raid` like:

```json
{
"pirates" : [
			{
			...
			},
			{
			...
			}
    ]
}
```

### Setting up a projection
We want to get on `/pirates` and get a list of pirates with their related ship **embedded** rather than through a link.

We need to create a new package called `projections` and an interface in that called `EmbedShip`

This interface with the annotation `@Projection` will be used to tell Spring Data REST which properties should be returned when using a specific projection with the query string on that collection. For example: `/pirates?projection=embedShip`

```java
// EmbedShip.java

@Projection(name = "embedShip", types = Pirate.class)
public interface EmbedShip {
    String getFirstName();
    String getLastName();
    int getAge();
    Ship getShip();
}
```

If a projection has only one getter for a property, then when that projection is triggered with the query string (`?projection=embedShip`) then only that property will be returned in the resulting JSON.

In our case, we specifically want to include all properties incliding the `Ship` which is exactly what we want. Thus the ship will be embedded into the returned JSON.

To make that newly created projection work, we need to tell the `JpaRepository` to use it.

```java
@RepositoryRestResource(excerptProjection = EmbedShip.class)
```
Replace the `@Repository` annotation in the relevant Repository interface. We're doing this on `Pirate` objects, so will change `PirateRepository`.

This annotation points to the `EmbedShip` custom projection we've created.


### Try it out

We now have nicely embedded data for related classes that our front-end will be able to use easily.

> TASK: create projections for other classes and consider the other two routes and how the related data should be embedded.


## Conclusion

We now understand how to create restful routes for associated collections using Spring Data REST. We have seen how HATEOAS are used as a way of representing links within our data and it still be RESTful.

We have setup routing to be able to access the collections of raids in pirates and pirates in ships creating a RESTful API.

## Addition Resources

Further reading on HATEOAS:
- [Spring Documentation - Understanding HATEOAS](https://spring.io/understanding/HATEOAS)
- [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)
- [HATEOAS Wikipedia Page](https://en.wikipedia.org/wiki/HATEOAS)
