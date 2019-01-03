# Pizza Shop Lab

We're about halfway finished on our RESTful pizza shop web app. We still need to add routes for `edit`, `update` and `destroy` actions.

Funnily enough, that's exactly what we're doing in this lab! Go ahead and write these routes and finish our app.

Annoyingly, we can't use DELETE or PUT requests in the browser, we just use POST for them.

Our REST table should then look like this:

|VERB  |PATH                    |ACTION |
|:----:|:----------------------:|:-----:|
|GET   |/pizza-orders           |index  |
|GET   |/pizza-orders/:id       |show   |
|GET   |/pizza-orders/new       |new    |
|POST  |/pizza-orders           |create |
|GET   |/pizza-orders/:id/edit  |edit   |
|POST  |/pizza-orders/:id       |update |
|POST  |/pizza-orders/:id/delete|destroy|

All POST routes must be sent from `<form>`s.

## Hints

* Start with the `delete` route. It is the easiest one, as it only does one thing. You can either make it an instance method, and delete the current object. Or add a `self.delete(id)` method which uses the id in the URL to identify which order to delete.
* Although the `delete` route is easy, it relies on a POST request, because it is changing the resource on the server. Unfortunately we can't make a hyperlink to a POST request, we have to use a button inside a `<form>` with its method and action properly set. You saw how to do this in the `new` form!
* After deleting a pizza, it might be sensible to send the user back to the list of all pizzas, which is called a _redirect_. Find out how to make this happen with Sinatra.
* Your `edit` route will probably take users to a form, just like the `new` route. Only this time, the form should be populated with the correct data for the order we want to edit.
* Your `update` route will probably look a lot like the `create` route!
* Remember to add links where appropriate! These might be on the nav bar so they are always visible, or they might be on every item in the `index`, or might be on the `show` view... It's up to you!
