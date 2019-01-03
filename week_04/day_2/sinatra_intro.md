# Sinatra Intro 

### objectives


# Http Recap

We are about to look at our first adventure into HTTP requests. If you recall, HTTP is a way that a client (browser) can communicate to a server.

There are many kinds of HTTP request we can make that have different behaviours, but for today we are going to look at the GET method.

You probably didn't know it at the time, but you have been using get requests all the time when you use your browser.

http://google.com -> get request
http://amazon.co.uk -> get request

GET is a method which a client can communicate to a server and ask for some resource. The important thing about a GET is that it has no side effects - nothing should be updated or change. It simply "gets" something - a file, a web page, an image etc.

> Optional exercise
	- Ask students to use the analogy of a customer, waiter and cook in a restaurant to describe the request response cycle. 

## What is a web framework?

A web application framework, or web framework, supports the development of software which is used on the internet. Every time we wanted to create a web app we would need to setup a server. This is time consuming and having a framework that sets this up and is tested is hugely efficient.

Then we need work out some system where we could handle requests. This is known as routing.

When we go to www.bbc.co.uk/news this request responds with all the latest news. If we then go to /sport we get the latest sport. These are two seperate routes that GET different information/resources. 

You can imagine the pages and routes underneath these sections on the BBC website and so on. How do we deal with these routing issues? A good framework will be able to handle this which allows us to really focus on creating solid programs that are well tested.

There are other advantages which we will touch on as we go through the course.

# Sinatra

Sinatra is a light-weight Ruby web framework. There are many other web frameworks out there that use different languages.

> Ask the class to name some

These include Django(Python), ASP.Net MVC (C#) and Rails(Ruby) which we will look at in much greater detail later. These all allow us to achieve the same basic goal - serving pages for requests.

[http://www.sinatrarb.com](http://www.sinatrarb.com)

Sinatra is a Gem, so to install it is simple.

```
  gem install sinatra sinatra-contrib
```

We've also installed the "[sinatra-contrib](https://github.com/sinatra/sinatra/tree/master/sinatra-contrib)" gem, for some common extensions to Sinatra we might find useful.

## Our first application

To get running, we'll make a "Hello World" with Sinatra.

Create a Ruby file, and populate it with the following code.

```zsh
#terminal

  touch app.rb
```

```ruby  
  #app.rb
  require 'sinatra'

  get '/hi' do
    puts "Hello world!"
  end
```

Then run it from the terminal, using Ruby like we did before.


```zsh
#terminal

  ruby app.rb
```

Make a request to http://localhost:4567/hi and look in your terminal. 

Let's change it to send something back to the broswer.

```ruby
#app.rb

  get '/hi' do
    "Hello world!"
  end
```

Visit [http://localhost:4567/hi] and see Sinatra in action.

> in case they ask - Note that localhost is a special url we can use to run applications on our local machine. It's not visible to the outside world. The ip address resolves to 127.0.0.1.

> You'll see that http://127.0.0.1:4567/hi works as well.

> The port number allows us to run multiple applications on our machine if we assign them different ports. It's a specific id which your application uses to listen for inbound requests. Port 443 and Port 80 are generally reserved so that your machine can talk to the Internet for example.

Let's try changing the text - we should see the update on the page.

It's going to get tedious restarting every time we make a change so let's add this line to make it refresh on change 

```ruby
#app.rb

require 'sinatra/contrib/all' if development? #ADDED
```

# What does it all mean

Let's have a look at the four lines of code we wrote. 

Firstly, we require the Sinatra functionality into our app.

Then, we use a keyword `get`... now, that's not a Ruby keyword... so what's going on?

> Take suggestions from the class about what it might be, where it might come from? If it's an undefined variable or method there would be an error - so it *must* be defined. Where? What does it look like?

This is a method provided by Sinatra's DSL to describe routes. This makes the definition of Sinatra apps a bit more "natural language" (ubiquitous).

If we look at it, it's not actually that different to what we have seen before.

  - the method name is get
  - it takes one parameter - the "route" (more on this in a sec)
  - it then takes a block of code to run if any `GET` HTTP requests match the path.

The return value of the block becomes the content (at least) of the response sent back to the client.

Note that /hi is NOT the same as /hi/1. Have a look and see what happens.

We use routing to match a path and a http method to one or more handlers. You can see that in our case, we have one route which looks for the resource "/hi" with the GET method, and will execute our "hello" response.

The pattern is:

```
verb path do
	#Do something
end
```

We could write any Ruby code we want inside the do/end block. 

[TASK:] Make a get route called "roll-die" and use Ruby code to return a random number between 1 and 6

```ruby
#app.rb

get "/roll-die" do
	"Rolling the die ... #{rand(1...7)}"
end
```


# Status Codes

Everytime we make a web request, the server sends a response to say if it has been successful or not. 200 is the code that everything is ok, 404 is the code for when it doesn't find something and 500 is when there has been an error. There are loads of these, but these three are the most important to get to grips with right now.

We can use "inspect element" on the Chrome browser to view the network tab, and see the status codes for our app.

> Just demo this, the class shouldn't follow along.

Let's try going to /hi again and see the 200 code.

## Getting dynamic input

While interacting with a web site, users need to be able to provide information. One of the ways we can get this is to capture parameters from the path in the URL.

We do this by defining the path with placeholder strings with colons in front of them (which makes them look like a symbol). This string is used as the key in a hash returned when we call `params`, and the value associated with it is whatever value was in the path.

Sinatra allows us to add url "parameters" to the path using a special syntax. We use the name of the parameter prefixed with a colon, and these values are passed to us in a hash called 'params'. e.g.


```ruby
#app.rb

  # capture parameters from the path
get '/name/:first/:last' do 
  return params.to_s
end
 
```

If we look at the result of this in the browser we can see the params hash, where each of the sections of the URL that start with a colon are then represented as key-value pairs in the hash - the key is the placeholder we set in the get method, and the value is what we typed in the browser bar. E.g. `{"splat"=>[], "captures"=>["beth", "fraser"], "first"=>"beth", "last"=>"fraser"}` - ignore the 'splat' and 'captures' part.

We can now use these values in what we return to the user. Note the params hash is special in that it lets you access its keys with either strings or symbols. We can have as many parameters as we like.

```ruby
#app.rb

  # capture parameters from the path
get '/name/:first/:last' do 
  return "Your name is #{params[:first]} #{params[:last]}"
end
 
```

> Ask the students to talk through the structure of the method. What is the name, the parameter, the http method type, what the return value does, what the status code will be.
  
## Using params to request data

One common use of these URL parameters is to specify a certain piece of data we want to get back. For example, I could have an array of people's names, and want to get a certain name back each time - putting 1 for the first name, 2 for the second, etc.

```ruby
#app.rb

get '/friends/:number' do
  friends = ["Joey", "Phoebe", "Monica", "Chandler", "Rachel", "Ross"]
  index = params["number"].to_i - 1
  return friends[index]
end
```

As you see we can use the number param to find an indexed item in an array. More often we will pass in an ID that relates to an item in a database.

## Beware of the type in params hash

If we were to create a route that squares a number, beware! We have to turn the value in the params hash to an integer. It will always be a string in the params hash.

```ruby
#app.rb

get "/square/:num" do
  num = params[:num].to_i
  return "Number squared = #{num * num}"
end
```

## Beware of identical routes

If we have two routes that have the same pattern e.g.

```ruby
get "/pet/:hello" do
	"Hello pet"
end

get "/pet/:name" do
	"Hello #{params[:name]}"
end
```

The first one will always be triggered. The second one will never be triggered.


