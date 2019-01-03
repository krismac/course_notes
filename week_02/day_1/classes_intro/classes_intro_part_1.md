# Ruby Classes - Part 1

### Learning Objectives

1.  Understand the basic idea of Object Orientation
2.  Create a class
3.  Create an instance of a class
4.  Understand the difference between a class and an object
5.  Add properties to class
6.  Add methods to class
7.  Understand the difference between a function and a method
8.  Understand getters
9.  Understand setters
10. Explain how OO Encapsulates our program.

### Duration

2.5 hours

## Intro

We have been creating objects from the 'out the box' classes Ruby provides for us.

Let's recap some of these classes.

```ruby
# irb
a = []
s = ""
h = {}
```

This is equivalent to:

```ruby
a = Array.new()
s = String.new()
h = Hash.new()
```

We have been calling methods on these objects also.

```ruby
a.push(1)
a.length
```

Today we are going to see how we can create our own objects, with their own methods.

**Fundamentally, object-oriented programming sees the world as data, modelled in code by "objects."** Coupled together with their behaviour - methods.

**In OOP, the programmer focuses on designing 'classes'** that define the properties and behaviours of 'objects' that will be instantiated from our classes.

> Draw a house being cobbled together from lots of components

## Function Recap

We have been writing functions to achieve the behaviour we desire. Passing in the data we want to be updated and getting the function to return the result we want back.

Our programs have thus far have had our data, often in arrays and hashes, and functions

Let's make a spec file to run this.

```bash
# terminal
mkdir specs
touch specs/bank_account_spec.rb
```

```ruby
# bank_account_spec.rb
require('minitest/autorun')
require('minitest/rg')
require_relative('./bank_account')

class TestBankAccount < MiniTest::Test
  def test_account_name
    account = {
      holder_name: "John",
      balance: 500,
      type: "business"
    }
    assert_equal("John", get_account_name(account))
  end
end
```

```bash
# terminal
touch bank_account.rb
```

```ruby
# bank_account.rb
def get_account_name(account)
  return account[:holder_name]
end
```

You can see here the data hash and function are coupled in their behaviour. However, our account name function is sort of just floating around in the middle of nowhere - the hash and the function are not linked in anyway even though we know they are used together.

Object orientated programming takes the step of grouping the behaviour and the data together in an object. This way, we can have nicely bundled pieces of related code that can be reused.

Often, we don't just want one object but many of that type. Think about Strings, Arrays, Integers and in this case Bank Accounts. It is for this reason that when defining the behaviour, we don't do it for a single object, but for a class of objects.

## Real World Example - Person

This might sound a bit scary, but it's really not. Let's think about a real life example.

In the classroom, we have many people. We all have different names, hair colour and favourite colours. However, we all have a name, we all have hair and we all have favourite colours. We know that a person has these traits, and that since we are all people we have our own instances of these things.

In Ruby, we could say that a Person is a class, a template, a blueprint and that John is an instance - he has specific implementations of the properties we know that a person has. I have brown hair, my name is John and my favourite colours are black and gold.

Similarly, we know that all people can walk, talk and sleep. We all do this, in our own way. You walk differently to your neighbour, and they talk differently to their mum. But we all walk and talk because we are People.

We can also represent this in our code, by attaching "behaviours" to classes as well as properties. These are represented by functions, or "methods". More on this later.

## Object Orientated Code

Let's have a look at this in the context of a bank account example.

To make a class, we need the "class" keyword in Ruby. This is going to be our template where we define the properties and behaviours that our bank account objects will have.

```ruby
# bank_account_spec.rb
class TestBankAccount < MiniTest::Test
  def test_account_name
    bank_account = BankAccount.new()
  end
end
```

Cool, now we need to actually create a bank account class, so that we can create object instances of it.

```ruby
# bank_account.rb
class BankAccount

end
```

Our test isn't actually doing anything, but at least there are no errors.

We can see that we create an instance of an object, a concrete implementation, using the "new" keyword after the class name. This will make a lot more sense as we add properties to our bank account.

> Make sure everyone is on par here.

## Initializing State

The bank account object we created it was pretty empty. If you remember, our bank account needs a holder name, balance and a type.

We want to pass this to the object when we create it, since these are properties every bank account needs to have. It turns out that "new" is just a special function we can use to pass initial data to our object - defining the initial state that our object has.

```ruby
# bank_account_spec.rb

account = BankAccount.new('John', 500, 'business')
```

If we run this, we will see an error. We have not actually told our class to expect a name, value or type so it doesn't know what to do with it. Let's go add them.

All classes have a special function called initialize that we can use to set the state of our object. This is the code that is run when we call "new" which is a little confusing! This is just the way Ruby handles initializing state, don't worry about it too much. All you need to remember is that when we use `.new` it is the `initialize` method which is called. What we pass `new` and what we expect to get in `initialize` must match up, just like with a normal function.

```ruby
# bank_account.rb
class BankAccount
  def initialize(input_holder_name, input_balance, input_type)
  end
end
```

Cool, so now our test is passing. Note that we can replace the name, value and type of our object with anything we want. This is just one instance of a bank account.

> Do a quick demo of making another bank account then delete it.

However, we are not actually doing anything with the data. It is passed to the initialize method, then is lost.

> Break here

## Initialize Instance Variables

Okay, so we probably want to be able to access our name, value and type after we have first initialized them. The value of the bank is likely to change a lot for sure, so we definitely need to be able to get to it and update it.

We call properties of a class which are available during the entire life of an object "instance variables". As long as our bank account exists in memory, these values will be stored and remembered. This is the object's state.

This is different to the "local" variables we saw before in functions, which live as the function executes then are lost.

Instance variables are defined with an @ sign. This is how we setup the data on an object, and it does not get lost after initialization.

```ruby
class BankAccount
  def initialize(input_holder_name, input_balance, input_type)
    @holder_name = input_holder_name
    @balance = input_balance
    @type = input_type
  end
end
```

Note that the instance variable names can be the same, or different to those that are passed in from the parameters.

```ruby
class BankAccount
  def initialize(holder_name, balance, type)
    @holder_name = holder_name
    @balance = balance
    @type = type
  end
end
```

We now have successfully stored the data in the object. But how do we get it back out?

## Behaviour

While it's cool that we have state, we can't easily get it from our object. This is because in Ruby (as they should probably be in all languages), instance variables are private - not accessible from outside the object.

### Instance Variables are Private

This brings us on to defining the behaviour of our object - ways which we can interact with it. We do this by defining methods - these are functions which are attached to an object. We can call these methods using the . notation on the object. From now on we'll be writing all of our functions in classes, allowing them to be methods on an object. Let's see an example to allow us to access the holder name of the account.

Why is this important? Well the properties we set on our object are "private". The outside world can't access them, only our object knows about them. This is important since we might use these properties to calculate things inside of our object or do interesting things, but we don't want people to be able to change them willy nilly.

Let's try and access our name of our account.

```ruby
# bank_account_spec.rb
class TestBankAccount < MiniTest::Test
  def test_account_name
    account = BankAccount.new('john', 5000, 'business')
    assert_equal('john', account.holder_name)
  end
end
```

When we run this, we get an error. The outside world (us) has no access to this property of the object. It's locked away and guarded.
