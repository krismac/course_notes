# Ruby Classes - Part 2

## Getters

In order to access our properties, we need to create "getter" methods. This allows us to give people access to the properties, but they cannot update them. Let's add a getter for the name.

```ruby
# bank_account.rb
def holder_name
  return @holder_name
end
```

Now our test will pass, since we have allowed access to our object's name. Let's do the same for a bank account's balance and type:

> [Task:] Write getters for the balance and the type of account, with tests first.

```ruby
# bank_account_spec.rb
def test_account_balance
  account = BankAccount.new('Alice', 5000, 'business')
  assert_equal(5000, account.balance)
end

def test_account_type
  account = BankAccount.new('Alice', 5000, 'business')
  assert_equal('business', account.type)
end
```

```ruby
# bank_account.rb
def balance
  return @balance
end

def type
  return @type
end
```

## Setters

Equally, we can write methods to set the value of our properties. We call these "setters". Let's add a setter.

```ruby
# bank_account_spec.rb
def test_set_account_name
  account = BankAccount.new('Alice', 5000, 'business')
  account.set_holder_name('Bob')
  assert_equal('Bob', account.holder_name)
end
```

If we run this, we will get a "No method" error since we have not allowed access to set the value of the name. We can read it, but we can't set it. Let's sort that.

```ruby
# bank_account.rb
def set_holder_name(name)
  @holder_name = name
end
```

And we can write setters for the account balance and type:

> [Task:] Make setters for the value and type.

```ruby
#bank_account_spec.rb
def test_set_account_balance
  account = BankAccount.new('Alice', 5000, 'business')
  account.set_balance(10000)
  assert_equal(10000, account.balance)
end

def test_set_account_type
  account = BankAccount.new('Alice', 5000, 'business')
  account.set_type('personal')
  assert_equal('personal', account.type)
end
```

```ruby
# bank_account.rb
def set_balance(value)
  @balance = value
end

def set_type(type)
  @type = type
end
```

## Getter / Setter Method Shortcuts

I'm sure you will agree that it is getting a bit tedious by now, adding the methods for getting and setting properties. The good news is there is a few shortcuts we can use - `attr_reader` for getters, `attr_writer` for setting and `attr_accessor` for both.

We can delete all of our getters, and replace them with this at the top of the file.

```ruby
# bank-account.rb
attr_reader :type, :balance, :holder_name
```

Running our tests shows that we didn't have to change a single thing, they still pass.

attr_reader is creating methods for us to return the attributes of our objects. Under the hood, Ruby writes the same method as we did before with

```ruby
def holder_name()
  return @holder_name
end
```

but this way we can write all of our getters on a single line. Easy to read and DRY solution for our getters.

We can do the same with our setters, using our attr_writer

```ruby
attr_writer :name, :type, :holder_name
```

However, this behaves a bit differently compared to our previous set_type, set_balance and set_holder_name methods.
These will not take in arguments, instead we can use the `=` sign to assign a new value to our attributes, like such:

```ruby
account.balance = 1000
```

Therefore we have to update our test file to accomodate to these changes:

```ruby
# bank_account_spec.rb
def test_set_account_name
  account = BankAccount.new('Alice', 5000, 'business')
  account.holder_name=('Bob') # UPDATED
  assert_equal('Bob', account.holder_name)
end
```

Because we have written unit tests, we can run them and see if our code is still okay. This is the beauty of writing tests!

Let's do the same for all our properties

> [Task:] Convert the other properties to use `attr_writer`. Hint - you can separate the property names with commas.

```ruby
#bank_account_spec.rb
def test_set_account_balance
  account = BankAccount.new('Alice', 5000, 'business')
  account.balance=(10000) # UPDATE
  assert_equal(10000, account.balance)
end

def test_set_account_type
  account = BankAccount.new('Alice', 5000, 'business')
  account.type('personal') # UPDATE
  assert_equal('personal', account.type)
end
```

Amazing, isn't it?

Lastly, to make our code even cleaner, we can combine both attr_reader and attr_writer on a single line in case we need both - `attr_accessor`

```ruby
# bank_account.rb
class BankAccount
  attr_accessor :name, :balance, :type
  def initialize(holder_name, balance, type)
    @holder_name = holder_name
    @type = type
    @balance = balance
  end
end
```

Isn't that much neater??

## IMPORTANT!

Please note that generally you shouldn't immediately add an attr_accessor for every attribute you have. We will let you know when it is necessary or not advised to add one or the other as we go along, but as a rule of thumb, do not add attr_readers or attr_writers until you need to.

## Further Behaviour - Not a Setter

Let's define some further behaviour on the BankAccount, where we can update the value of the account.

```ruby
# bank_account_spec.rb
def test_pay_into_account
  account = BankAccount.new('Alice', 5000, 'business')
  account.pay_in(1000)
  assert_equal(6000, account.balance)
end
```

If we run this, the test will fail and say it can't find the method pay_in. Which is correct, we need to go and add this to our class.

```ruby
# bank_account.rb
def pay_in(value)
  @balance += value
end
```

This is not a setter or a getter, it's not simply updating the value or retrieving the value. It's modifying it with some logic.

## Conditional State

We sometimes want instances to behave slightly differently depending on their state (instance variables). Let's make a little pay monthly method, which subtracts 50 off the value of the account.

> [Task:] Make a pay_monthly_fee method, which reduces the value of the account by 50. Write the test first.

```ruby
# bank_account_spec.rb
def test_monthly_fee
  account = BankAccount.new('Alice', 5000, 'business')
  account.pay_monthly_fee
  assert_equal(4950, account.balance)
end
```

```ruby
# bank_account.rb
def pay_monthly_fee
  @balance -= 50
end
```

Our bank account currently isn't very fair, since personal users pay the same fee as a business user. Change the monthly fee method to deduct only 10 for a personal account, and 50 for a business account. You will need to update the tests.

> [Task:] Take a few minutes to do this

```ruby
# bank_account_spec.rb
def test_monthly_fee_business
  account = BankAccount.new('Alice', 5000, 'business')
  account.pay_monthly_fee
  assert_equal(4950, account.balance)
end

def test_monthly_fee_personal
  account = BankAccount.new('darren', 5000, 'personal')
  account.pay_monthly_fee
  assert_equal(4990, account.balance)
end
```

```ruby
# bank_account.rb
def pay_monthly_fee
  @balance -= 10 if @type == 'personal'
  @balance -= 50 if @type == 'business'
end
```

```ruby
# bank_account.rb
# Alternative solution
def pay_monthly_fee
  charges = {
    'business' => 50,
    'personal' => 10
  }
  @balance -= charges[@type]
end
```
