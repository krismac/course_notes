# MVC

## Objectives
- Understand what the role of M,V and C is in MVC

## Duration 5 mins

# Intro

When we are dealing with web apps, there are many ways we can structure the code.  In the past, there have been many ways to do this e.g. the flat structure of PHP or the front end - back end code files of ASP.NET which tie a given piece of C# to a front end html file. The problem with these patterns is that they often result in clunky, long code files and messy html littered with logic. To address this problem, MVC came along.

## Principles

We always want to:
- Keep our logic separate from our html/rendering layer
- Be able to reuse our code
- Separate concerns, try to keep to the 'Single Responsiblity Principle' so that components in our code are not doing to much

MVC helps us address this.

## Flow

With MVC, the client inputs a url which is picked up by our application and handled by a Controller. The controller is responsible for deciding what to do when a given 'route' is matched (a route being a pairing of a HTTP VERB and a path '/cats' etc). Next, the controller may create / fetch whichever Model it needs to bundle up the data / logic which is necessary for the page to be rendered. Lastly, this Model is passed to a View where the model is accessed to render the information to the page.

### Example

- User inputs /localhost:4567/cats
- CatsController picks up the request on the GET -> 'cats' route
- CatsController grabs a Cat model
- CatsController sends the Cat model to the view

