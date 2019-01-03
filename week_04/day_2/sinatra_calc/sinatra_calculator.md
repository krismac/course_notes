# Sinatra Calculator

### Learning Objectives

- Utilise dynamic paths and explore routing
- Understand controllers and why we use them
- serve up content in HTML

## Introduction

Let's build a Sinatra calculator. The point of this app is to put into practice the basics of using Sinatra, and introduce serving content types.

> Give out start code.

```zsh
  # top level of folders

  touch controller.rb
```

What routes are we going to make for a calculator? We could use one for all the functionality of our calculator. So add, subtract, multiply and divide. Let's just start with add.

We need to take a couple of inputs dynamically. We can setup a path with two dynamic values

```ruby
  # controller.rb

  require( 'sinatra' )
  require( 'sinatra/contrib/all' )
  require( 'pry-byebug' )
  
  require_relative( './models/calculator' )
  also_reload( './models/*' )

  get '/add/:num1/:num2' do

  end
```

Notice that we now have to tell Sinatra to reload if any files in the `models` directory change, with the line `also_reload( './models/*' )`. 

What do you think will happen if we go to the "/add" route? A blank page. We need to new up a calculator to use!

```ruby
  # controller.rb

  require_relative( './models/calculator' )

  get '/add/:num1/:num2' do
    num1 = params[:num1].to_i 
    num2 = params[:num2].to_i
    return "#{Calculator.add(num1, num2)}"
  end
```

If we refresh the browser - we should get 6!

> [TASK: 30 MINS] Add the other routes we want, for: subtract, multiply, divide

```ruby
# controller.rb

get '/subtract/:num1/:num2' do
  num1 = params[:num1].to_i 
  num2 = params[:num2].to_i
  return "#{Calculator.subtract(num1, num2)}"
end

get '/multiply/:num1/:num2' do
  return "#{Calculator.multiply(params[:num1].to_i, params[:num2].to_i)}"
end

get '/divide/:num1/:num2' do
  return "#{Calculator.divide(params[:num1].to_i, params[:num2].to_i)}"
end
```

## Serving content

Cool, we have created a functional app which works brilliantly as a calculator. But what are we actually sending to the view?

We are actually sending a string down just now. If we `cmd-alt-u` and view the source of our page you will notice there is no HTML. As we are in control of what we send we dictate what we send to the client.  As mentioned, servers can send down loads of types of data. On the web, one particular type of data is more common than any other.

### HTML

Everyday, we will all be requesting this file type without probably even knowing we are. HTML is sent back from servers to users to display and structure content. So, it's important we know how to send HTML.

There are many ways to create HTML. We could create a `.html` file and send this but because we are building dynamic apps we probably want to add content to our pages dynamically. We can use templates.

> DRAW -  request comes in - processes request and gets data and then generates HTML and sends down:

1. Request comes in
2. Grab resource (data from database/process information)
3. Inject to html
4. Page sent down as HTML. Not ERB.

In Sinatra & Ruby frameworks we can use ERB. This stands for embedded Ruby. This allows us to write and reference Ruby and inject dynamic content. Let's give this a go.

```zsh
  # terminal

  mkdir views
  touch views/result.erb
```

Sinatra is lightweight and unopinionated which means that we have to do a lot of setup ourselves and we decide how our app is structured. The one assumption it does make though is that our `.erb` HTML templates live in a folder called `views`.

```html
  # views/result.erb
  <h1>the result is <%= @calculation %></h1>
```

We need to be careful with equals sign. If we take the equals away what happens? Nothing is rendered!

This becomes very important when we are using `if` statements etc.

```html

  <% if true %>
  <%= "cats" %>
  <% else %>
  <%= "dogs" %>
  <% end %>
```

Anything to be rendered needs an `=` sign, and everything to be evaluated must not. If we put an `=` beside the `end` tag, what happens? We need to be careful with this.

We now need to use our result template and send in our dynamic content. In our add route:

```ruby
  # controller.rb

  # remove return...
  @calculation = Calculator.add(num1, num2)
  erb( :result )

```

You can think of adding the `@` sign as creating a bridge between the controller and the view, so that the variable can be accessed.

We also need to change the return value of the method to tell Sinatra's `erb` method to use the `views/result.erb` view. Since we stuck to the convention and named the folder "views" we simply need to use the `erb` keyword and pass the name of the view as a symbol.

> TASK: Complete the multiply, subtract and divide routes sending down the same `result.erb`.

## Layouts (templates)

```html
  # views/result.erb
  <!DOCTYPE html>
  <html lang='en'>
    <head>
      <meta charset='utf-8'>
      <title>Sinatra Calculator</title>
    </head>
    <body>
      the result is <%= @calculation %>
    </body>
  </html>
```

But *all* of our `.erb` files will need that... and we want to be DRY.

So we'll put our `result.erb` back to what it was before, and create a new view with all of the HTML template code.

This is where _layout_ files come in - they allow us to share this scaffolding code across all our views.  Another convention is that we should call this `layout.erb` to allow Sinatra to do its magic.

```zsh
  # terminal

  touch views/layout.erb
```

```html
  # views/result.erb
  the result is <%= @calculation %>
```

```html
  # views/layout.erb
  <!DOCTYPE html>
  <html lang='en'>
    <head>
      <meta charset='utf-8'>
      <title>Calculator</title>
    </head>
    <body>
      <%= yield %>
    </body>
  </html>
```

Sinatra by default looks for this `layout.erb` file inside a `views` folder. When we call each page, it should render the layout pages as a sort of container, then when we use the special word `yield` it knows to call the entire contents of the child page using it.

`yield` is a built-in Ruby keyword, an instruction that says "take the code I've passed you, and run it right here." In our case, the code we've passed to the layout is the contents of `result.erb`. But now, instead of passing `result.erb` to the layout, we can pass in any code we want, from another `.erb` file.

## More than one view

What should we do if we want to add other pages to our app? If we want to have an "about us" page, or and "faq", what sorts of things will we need?

### Create a link

Let's put a menu in our layout. It will have two links - one for our root path (home page), and one for our new page.

```html
  # views/layout.erb

  <body>
    <nav>
      <ul>
        <li><a href="/">home</a></li>
        <li><a href="/about_us">about us</a></li>
      </ul>
    </nav>
    <%= yield %>
  </body>
```

If we refresh our browser, and click the "about us" link, we get an error about Sinatra not knowing this ditty, and some suggested code that might solve our problem.

> Ask the students if they remember how to make a homepage.

```ruby
  # controller.rb
  get '/' do
    erb (:home)
  end

  get '/about_us' do
    erb :about_us
  end
```

Now when we click the link we get an error about a missing template. We need to create a correctly-named view file, and put some content in it.

```zsh
  # terminal
  touch views/home.erb
  touch views/about_us.erb
```

```html
  #views/about_us.erb

  <h1>About Us</h1>
  <p>This page is all about us. We're great at making calculators!</p>
```

We can follow this process whenever we want a new route through our app:

1. Create a link for the new route you want to create - you'll get a routing error when you visit it
2. Add the route-handling code to the controller (the `controller.rb` file) - you'll get an error about a missing template/view
3. Make the view file and populate it with what you want the user to see
4. Go back to '1' for the next feature

This is a similar approach to the BDD stuff we were doing in the command line.  Create the behaviour you want, then follow the steps to make it happen.

# Customising the output

From this point on, the view files can be treated like HTML, and to customise the appearance of HTML, we need some CSS.

We'll create a "public" folder to store static assets. Sinatra looks for any matching path in the public folder before matching routes for requests.

```zsh
#terminal

  mkdir public
  touch public/style.css
```

```html

  # views/layout.erb (head tag)
  <link rel='stylesheet' href='/style.css'>
```

```css
/* public/style.css */

  body {
    background-color: green;
  }
```

## Summary

In this lesson we have:

- Served dynamic content, Ruby code injected into HTML via `.erb` files
- Built a controller, and seen how we can use it to direct a user around our web app
- Explored routing, and executed different Ruby code at different URLs