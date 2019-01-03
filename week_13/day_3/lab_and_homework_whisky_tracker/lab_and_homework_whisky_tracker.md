# Lab + Homework

Given the basic code for classes and JpaRepositories for a whisky tracker, your task for this lab + homework is to complete the custom queries and connected them to appropriate RESTful endpoints.



**Whisky**

- `name` - the name of that individual whisky often uses the name of the distillery. An example is "The Glendronach - Revival" which is from "Glendronach" distillery
- `distillery` - the distillery object that it's related to
- `year` - the year edition that the whisky was released/ bottled. The year is not a way of determining the age.
- `age` - how long the whisky in the bottle was matured for before bottling

**Distillery**

- `name` - The name of the whisky distillery.
- `region` - The region of scotland where the whisky is from. These are one of either {**Lowlands**, **Speyside**, **Highlands**, **Islay**, **Campbelltown**, **Island** }
- `whiskys` - the list of related whiskies tracked against that distillery

## MVP

* **Custom Queries + REST** Write each of the following queries and connect them to an appropriate controller:
  * get all the whiskies for a particular year
  * get all the whisky from a particular region 
  * get all the distilleries for a particular region
  * get all the whisky from a particular distillery that's a specific age (if the whisky has a specific age)
  * Get distilleries that have whiskies that are 12 years old 



## Tips
* Use the code provided. You're **not** writing this from scratch. Your job is just to implement the queries.
* Use packages for each repository type. For example, all Distillery repositories (Custom, Impl and actual) should go in the same package called DistilleryRepository
* remember to create the DB!
