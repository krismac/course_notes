# Pizza Shop Web App

## Objectives

- Learn the RESTful routes pattern
- Make a functioning CRUD app for one resource
- Which HTTP verbs apply to which actions
- Understand HTML form posting and ERB

## Recap

To recap the last few days, we have built CRUD apps to access entries in a database, or make changes...

> Write CRUD actions on board for reference

...and we've seen that we have HTTP verbs which can request resources from a server, or make changes.

> Write HTTP verbs on board

We've also seen yesterday that we can build _routes_ that a browser can use to tell our web server what resources to serve up.

So logically, there must be some way of connecting these. There must be a way of pulling database entries down from a remote server so that we can play with them. There must be a way of collecting user input from the browser and storing it to a database. Because that's how the web works, right?

## Start code

> Give out `start.zip` on Slack. Give the class a few minutes to unzip it and look through the code to familiarise themselves with it.

The code we're starting with should look familiar. It's the pizza shop from last week. Someone has been kind enough to write the CRUD methods for us in our `pizza_order` model, as well as a few class helper methods like `PizzaOrder.all()`. They've been so nice to us, they've even given us a basic `layout.erb`.

## CRUD model

So, thinking about our CRUD model, let's think about all the things we might want to do with our pizza orders, and how that might work in the browser, starting with the easy ones...

> Put **bold** words as comments in `pizza_controller.rb` as we go

### *R*ead orders

There's no point in having the data about our orders, if we can't read the data back. But there's two ways we might want to do this. We probably want to see _all_ the orders, which we'll call an **index**. But we probably want to have a look at them one at a time as well; we want the browser to **show** just one order.

### *C*reate new orders

It wouldn't be much of a shop if we didn't take new orders! Before we could just make a new Ruby object and then store it to the database, but we can't expect our users to make new Ruby objects! We'll have to give them a form to make **new** pizza orders, and then take the data they enter and use that to **create** a new database entry.

### *U*pdate existing orders

Because we can't be expected to get our orders right first time, every time. We're only human. Just like when we create orders, this is a two-step process. We have to let our users **edit** the relevant entry in the database, then we use that new data to **update** the database.

### *D*elete orders

Nothing lasts forever. Deleting our entries is nothing fancy, we just **delete** them and they're gone.

## RESTful Routes

We've decided that we need to write these 7 routes in order to give a browser user access to our CRUD actions. In fact, these 7 routes make up a pretty handy _design pattern_ or convention for designing apps which access a database through a browser, called REST.

REST stands for **RE**-presentational **S**-tate **T**-ransfer, but no one really cares. You are much more likely to run into the phrase 'RESTful APIs'. An API is just the way in which one application expects to be talked to by another application; in this case, it's how a database application talks to a web browser. And by following the RESTful convention, we make our application more useable. The convention is so widespread that the actions we can perform are predictable. Developers like when things are predictable!

## Writing the 'index' route

So let's actually make these routes work, rather than just talking about them. Again, we'll start with the easy one, but before we do anything, if we want to do _anything_ with pizza orders, we'll have to `require` the model. We should also make sure that Sinatra reloads if we change our model:

```ruby
# pizza_controller.rb
require_relative( './models/pizza_order' )
also_reload( './models/*' )
```

> Ask class what HTTP verb should be used for `index`

```ruby
get '/pizza-orders' do # index
  erb( :index )
end
```

This will ask the server for a file called `index.erb`, which it will add to our `layout.erb` and send back to us. So we better `touch views/index.erb` and write the view:

```html
<!-- views/index.erb -->
<p>All the pizzas!</p>
```

> Hit this route in Chrome

That's cool. We ask the server for all the pizza orders and it gives us, literally, "All the pizzas!" But we can make this better. Let's actually get the orders back.

> The class should be able to find `PizzaOrder.all()` on their own. Maybe.

```ruby
# pizza_controller.rb

# index
get '/pizza-orders' do
  @orders = PizzaOrder.all()
  erb( :index )
end
```

We know from last week, and from looking at the start code, that `PizzaOrder.all()` gives us an array of pizza order objects. By storing the result of `PizzaOrder.all()` in an instance variable, we get access to it within the `.erb` file as well. So since we have an array of objects, we can map them to a bunch of HTML elements:

> **!!!** Do one of these, depending on whether the class are more comfortable with enumerable methods or straight up loops. Either way, talk through every line. Slowly. It's the first time they've seen a loop in erb, `<%=` and `<%` may be confusing.

```html
<!--index.erb -->

<% @orders.each do |order| %>
  <p>Name: <%= order.pretty_name() %></p>
  <p>Order: <%= order.quantity %> x <%= order.topping %></p>
  <hr />
<% end %>
```

```html
<!--index.erb -->

<% for order in @orders %>
  <p>Name: <%= order.pretty_name() %></p>
  <p>Order: <%= order.quantity %> x <%= order.topping %></p>
  <hr />
<% end %>
```

> Look at it in Chrome

Now let's add a wee nav item that we can use to get back to this index page.

```html
<!-- layout.erb -->
<nav>
  <ul>
    <li><!-- NEW  -->
      <a href="/pizza-orders">Pizza Orders</a>
    </li>
  </ul>
</nav>
```

Notice where that `href` is pointing. To our route! So wherever we end up in our app, we will always have a link back to this list of every pizza order.

## Writing the 'show' route

As we said earlier, seeing all the pizza orders is cool and everything, but we'd also like to be able to see just one at a time. If we have a look at our pizza order model, we can see that we've been given `PizzaOrder.find()`, a class method that takes in an `id` and returns a single pizza order object. Awesome! We can use that!

But how do we get the `id` to pass into this awesome method? We saw yesterday that parameters can be passed to our routes in the URL itself by giving the parameter a name starting with `:`. We can then pull them out of a hash object called `params`. So we can start writing the route:

```ruby
# pizza_controller.rb
get '/pizza-orders/:id' do # show

end
```

Now we can use `params[:id]` in the block that defines our route. So let's pass it into `PizzaOrder.find()` and store the order we get back in an instance variable again, so that we can use it in a `show.erb` view we'll write in a second:

```ruby
# pizza_controller.rb
get '/pizza-orders/:id' do # show
  @order = PizzaOrder.find( params[:id] )
  erb( :show )
end
```

Awesome. Well, we don't know it's awesome until we write that `show.erb`:

```zsh
# terminal
touch views/show.erb
```
> Actually, get them to try this themselves

```html
<!--show.erb -->

<p>First Name: <%= @order.first_name %></p>
<p>Last Name: <%= @order.last_name %></p>
<p>Topping: <%= @order.topping %></p>
<p>Quantity: <%= @order.quantity %></p>
```

> Look at it in Chrome. You might have to look in PSQL to find an actual ID.

Awesome! And we can click our nav link back to our list of all pizza orders!

But we can't really expect our users to type IDs straight into the browser's address bar. How can we make this more useable? Wouldn't it be cool if each entry in the list of all pizza orders linked to its own `show` view? Let's add that now:

```html
<!-- index.erb -->

<% for order in @orders %>
  <p>Name: <%= order.pretty_name() %></p>
  <p>Order: <%= order.quantity %> x <%= order.topping %></p>
  <p><a href="/pizza-orders/<%= order.id %>">Show Order</a></p>  <!-- NEW -->
  <hr />
<% end %>
```

> Look in Chrome

## Writing the 'new' route

Let's start the 'new' route by first making sure a sensible URL points to it:

```ruby
# pizza_controller.rb
get '/pizza-orders/new' do # new

end
```

Looks good, but there's a problem. Earlier we set up our `show` route at the URL `/pizza-orders/:id`, where the `:id` would become a parameter within the route block. If we now send users to `/pizza-orders/new`, then our `show` route will pick this up, and treat the string `new` from the URL as an `:id`. Then it will try to find an order with the id `'new'` in the database, and won't find it (obviously), so our `show` route will display a blank page. Basically, we just broke our web app.

But there's an easy fix! All we have to do is move this `new` route to _above_ the `show` route. Since Ruby reads from the top down, a user heading to `/pizza-orders/new` will hit the `new` route _before_ hitting the `show` route. Our `pizza_controller.rb` should therefore look like:

```ruby
#pizza_controller.erb

get '/pizza-orders' do # index
  @orders = PizzaOrder.all()
  erb( :index )
end

get '/pizza-orders/new' do # new

end

get '/pizza-orders/:id' do # show
  @order = PizzaOrder.find( params['id'] )
  erb( :show )
end
```

So as we said, making a new pizza order is a two-step process. First we get data about the pizza order from the user, then we add this new data to the database. So to get data from the user in a browser, it probably makes sense to give them an HTML form to fill in. So let's send them to a view, then we'll write a form in that view:

```ruby
#pizza_controller.erb

get '/pizza-orders/new' do # new
  erb( :new )
end
```

Now let's add a wee nav item that we can use to get back to this index page.

```html
<!-- layout.erb -->
<nav>
  <ul>
    <li><!-- NEW  -->
      <a href="/pizza-orders/new">Create an Order</a>
    </li>
  </ul>
</nav>
```

```zsh
#terminal

touch views/new.erb
```

```html
<!-- new.erb-->

<form>
  <label for="first-name">First Name:</label>
    <input id="first-name" type="text" name="first_name" />


  <label for="last-name">Last Name:</label>
    <input id="last-name" type="text" name="last_name">


  <label for="pizza-select">Select a pizza:</label>
    <select id="pizza-select" name="topping">
      <option value="Margherita">Margherita</option>
      <option value="Calzone">Calzone</option>
    </select>


  <label for="quantity">Quantity:</label>
    <input id="quantity" type="number" name="quantity"/>


  <input type='submit' value="Order Pizza"/>
</form>
```

The `name` properties on the `<input>`s and the `<select>` should match the keys that we look for on our options hash in the PizzaOrder model's initialize method.

The `for` properties on the `<label>`s should match the `id` property on the relevant `<input>` or `<select>`. This is important for accessibility to allow screen readers to read our website correctly.

Looks good! If we look at it in Chrome, we can fill out the form and click submit and... nothing happens. We have to tell the form what to do in its opening tag:

```html
<!-- new.erb -->

<form method="post" action="/pizza-orders">
```

This HTML tells the form what to do when the Submit button is clicked. It actually sends a new HTTP Request to the server, which we can view in the Chrome Dev Tools:

- [cmd + alt + J] to open Dev Tools
- Go to Network tab
- Fill out form and hit submit
- Select document that pops up in Network tab (404?) and look at Headers tab

The submit button is sending an HTTP POST request to `/pizza-orders`, which is what we put in the HTML `<form>` method and action. Actually this is why we used a form in the first place. An HTML form can send any HTTP request type we want, but the address bar of a browser can only send GET requests. This is a security feature. It means that users can't just POST any stuff they want to our server. We get to control the data they POST with our form inputs.

If we scroll to the bottom of that Headers tab, we can see our form data! So not only is the form making an HTTP POST request, it is sending our form data back to the server. Next we will see how to create a new database entry on the server with that data.

## Writing the 'create' route

So now that our form is sending data back to our server, we have to define the route to accept it:

```ruby
# pizza_controller.rb
post '/pizza-orders' do # create

end
```

Previously, we had access to a `params` hash which contained the `:id` which we passed through the URL. This `params` hash also contains the data which we passed from our form. For example, we can access the entry for the 'First Name' field by calling `params['first_name']`. We were very clever developers, and we made sure that our form inputs' `name` attributes matched the names of the keys in the options hash we pass to `PizzaOrder.new()`.

> This bit is already written, just show it:

```ruby
# models/pizza_order.rb
def initialize( options )
  @id = options['id'].to_i
  @first_name = options['first_name']
  @last_name = options['last_name']
  @topping = options['topping']
  @quantity = options['quantity'].to_i
end
```

So we've made life really easy for ourselves. All we need to do in our `create` route is pass this `params` hash to `PizzaOrder.new()`, and save that new pizza order:

```ruby
# pizza_controller.rb
post '/pizza-orders' do # create
  order = PizzaOrder.new( params )
  order.save()
end
```

That would be fine, but let's give our users some visual feedback. Usually the user would expect confirmation that a new _thing_ has been created, so let's give them that confirmation:

```ruby
# pizza_controller.rb

post '/pizza-orders' do # create
  @order = PizzaOrder.new( params )
  @order.save()
  erb( :create )
end
```

Note that we changed `order` to an instance variable. We want to access it in our `create` view:

```bash
touch views/create.rb
```

```html
<!-- create.erb -->
<p>Your order was successful!</p>
<p>Total: £<%= @order.total() %></p>
<p>Please call 0131 290 2600 to pay.</p>
```

And that's us!

We still have more to do, though. We have to write routes to `edit`, `update` and `delete` our pizza orders. But now that we've seen the basics, these will be easy! So easy, in fact, that you guys can write them yourselves!

> To Lab
