# Multiple Classes

Well done,  we have become object orientated programmers,  by creating a class and instantiating objects using it.

When object orientated programming becomes really powerful is when an object uses an other object to help it in a task.  Enough theory,  let's look at an example.

## Delegating To Other Objects

Let's model a musician that writes music using an instrument. The sound they make depends on the instrument's type.

First, we want to create tests for our musicians. In terminal:

```bash
#terminal

mkdir multiple_classes
cd multiple_classes
mkdir specs
touch specs/musician_spec.rb
```

Then open it up in atom!

```ruby
#specs/musician_spec.rb

require("minitest/autorun")
require('minitest/rg')
require_relative("../musician")

class MusicianTest < MiniTest::Test

  def setup
    @musician1 = Musician.new("Jimi Hendrix", "guitar")
  end

  def test_musician_has_name
    assert_equal("Jimi Hendrix", @musician1.name)
  end

end

```

Great! The first thing we want to test is if we can create a musician, and then access their name. Let's do it!

```bash
#terminal

touch musician.rb
```

```ruby
# musician.rb

class Musician

  attr_reader :name

  def initialize(name, instrument_type)
    @name = name
    @instrument_type = instrument_type
  end

end
```

Brilliant, test should pass no problem! Let's move on.

But musicians are not musicians without playing songs! Let's add the `play_song` behaviour to our `Musician` class! This method should take in the name of a song, and return to us a simple string representing the musician playing the song.

First, we write our test:

```ruby
# musician_spec.rb
# same

def test_musician_can_play_song
  assert_equal("I'm playing Hey Joe!", @musician.play_song("Hey Joe"))
end

```

Then we write the method to pass the test!

```ruby
# musician.rb
# as before

def play_song(title)
  return "I'm playing #{title}!"
end

```

Boom! Job's done. But then again, this is not really interactive. Let's do something with the instrument's type! If it's a piano, we'll return a special message, "Plink plonk..." in addition to to usual message:

First, we'll need another musician. Jimi Hendrix is equipped with a guitar, so we should create someone else having a piano.

```ruby
# musician_spec.rb
# as before

def setup
  @musician1 = Musician.new("Jimi Hendrix", "guitar")
  @musician2 = Musician.new("Freddie Mercury", "piano") # NEW
end
```

Then, let's write another test:

```ruby
# musician_spec.rb
# same

def test_musician_can_play_song_on_piano
  assert_equal("Plink plonk... I'm playing Bohemian Rhapsody!", @musician2.play_song("Bohemian Rhapsody"))
end
```

The test will fail. We were expecting `"Plink plonk... I'm playing Bohemian Rhapsody!"` and instead we got `"I'm playing Bohemian Rhapsody!"` We have to amend our `play_song` method to pass this test:


```ruby
# musician.rb

def play_song(title)
  if @instrument_type == "piano"
    return "Plink plonk... I'm playing #{title}!"
  else
    return "I'm playing #{title}!"
  end
end
```

Great!

But... something is not quite right. What if I want to give our musician a different instrument? The only thing I could do is set both the type of the instrument. This is not really clean. And is it really the musician's responsibility to know about the type of the instrument?

We want our classes to be responsible for only one thing. A musician is responsible for playing an instrument, but the instrument should be responsible for making the right sound.

Let's delegate the job of knowing instrument types and sounds to its own class!

In terminal:

```bash
#terminal

touch instrument.rb
touch specs/instrument_spec.rb
```

```ruby
# instrument_spec.rb

require("minitest/autorun")
require('minitest/rg')
require_relative("../instrument")

class InstrumentTest < MiniTest::Test

  def setup
    @instrument = Instrument.new("guitar")
  end

  def test_has_type
    assert_equal("guitar", @instrument.type)
  end

end
```

Let's make our tests pass!

```ruby
# instrument.rb
class Instrument

  attr_reader :type

  def initialize(type)
    @type = type
  end
end
```

Excellent!

Now here comes the magical part: From now on, we can instantiate an instrument, and instead of the musician being responsible for being aware of the instrument's name and type, the `Instrument` class can handle all this for us! Let's go back to our `musician.rb`, and refactor our code!

```ruby
# musician.rb
class Musician

  attr_reader :name

  def initialize(name, instrument) # UPDATE
    @name = name
    @instrument = instrument # UPDATE
  end

  def play_song(title)
    @instrument.make_sound(title) # UPDATE
  end

end
```

Since its the instrument's job to keep track of the type, we can give the responsibility of checking it to the instrument class!

First we write a couple of tests for our new `make_sound` method:

```ruby
# instrument_spec.rb

def test_can_make_sound
  assert_equal("I'm playing Stairway to Heaven!", @instrument.make_sound("Stairway to Heaven"))
end

def test_can_make_sound__piano
  piano = Instrument.new("piano")
  assert_equal("Plink plonk... I'm playing Ordinary People!", piano.make_sound("Ordinary People"))
end
```

And then we implement the `make_sound` method in our `Instrument` class:

```ruby
# instrument.rb

def make_sound(title)
  if @type == "piano"
    return "Plink plonk... I'm playing #{title}!"
  else
    return "I'm playing #{title}!"
  end
end

```

Dang, but then our tests are failing! Let's rework them to suit them to the changes we made!

```ruby
# musician_specs.rb
require("minitest/autorun")
require("minitest/rg")
require_relative("../musician")
require_relative("../instrument") # UPDATED

class MusicianTest < MiniTest::Test

  def setup
    strat = Instrument.new("guitar") # UPDATED
    grand_piano = Instrument.new("piano") # UPDATED
    @musician = Musician.new("Jimi Hendrix", strat) # UPDATED
    @musician2 = Musician.new("Freddie Mercury", grand_piano) # UPDATED
  end

  # ... AS BEFORE
```

Did we have to change anything with our actual tests? No, we did not. Everything passes just as fine as before. The musician here has delegated the behaviour of their instrument to the `Instrument` class.

What object is responsible for what is one of the major challenges of object orientated programming.  There are thousands of books of this, and we enter the realm of Object Orientated Design.  For now I would not worry too much about the design and focus on getting things working.  Make it work, make it right, make it fast.

## Collection Objects

We've already seen arrays and hashes. Objects whose role is to hold other objects.  Let's look at how we can use these to create our own collections.

1. Create a new class `Band`
2. `Band` should have a name and an array of `Musician`s in its constructor
3. `Band` should have a `perform(song_title)` method that creates a new array, calls the `play_song(title)` on every musician in its `musicians` array, then passes the strings the method returns into the new array. (Hint: Use a loop)

Remember to use TDD!

### Putting the Ol' Band Back Together

```bash
# terminal
touch band.rb specs/band_spec.rb
```

```ruby
# band_spec.rb

require("minitest/autorun")
require("minitest/rg")

require_relative("../band")
require_relative("../musician")
require_relative("../instrument")

class BandTest < MiniTest::Test

  def setup
    piano = Instrument.new("piano")
    bass = Instrument.new("bass guitar")
    guitar = Instrument.new("guitar")
    drums = Instrument.new("drums")

    john = Musician.new("John Lennon", piano)
    paul = Musician.new("Paul McCartney", bass)
    george = Musician.new("George Harrison", guitar)
    ringo = Musician.new("Ringo Starr", drums)

    @beatles = Band.new("The Beatles", [john, paul, george, ringo])
  end

  def test_band_has_name
    assert_equal("The Beatles", @beatles.name)
  end

  def test_band_can_play_song
    expected = [
      "Plink plonk... I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
    ]
    assert_equal(expected, @beatles.perform("Hey Jude"))
  end

end
```

```ruby
#band.rb

class Band

  attr_reader :name

    def initialize(name, musicians)
      @name = name
      @musicians = musicians
    end

  def perform(song_title)
    performance = []
    for musician in @musicians
      performance << musician.play_song(song_title)
    end
    return performance
  end

end
```
