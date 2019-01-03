require("minitest/autorun")
require("minitest/rg")
require_relative("../instrument.rb")

class InstrumentTest < MiniTest::Test

  def setup()
    @instrument = Instrument.new("guitar")
  end

  def test_has_type()
    assert_equal("guitar", @instrument.type())
  end

  def test_can_make_sound()
    assert_equal("I'm playing Back In Black!", @instrument.make_sound("Back In Black"))
  end

  def test_can_make_sound__piano
    piano = Instrument.new("piano")
    assert_equal("Plink plonk... I'm playing Chopsticks!", piano.make_sound("Chopsticks"))
  end

end
