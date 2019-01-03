require("minitest/autorun")
require("minitest/rg")
require_relative("../musician.rb")
require_relative("../instrument.rb")

class MusicianTest < MiniTest::Test

  def setup()
    instrument1 = Instrument.new("guitar")
    instrument2 = Instrument.new("piano")
    @musician1 = Musician.new("Jimi Hendrix", instrument1)
    @musician2 = Musician.new("Freddy Mercury", instrument2)
  end

  def test_musician_has_name()
    assert_equal("Jimi Hendrix", @musician1.name())
  end

  def test_musician_has_instrument()
    assert_equal("guitar", @musician1.instrument().type())
  end

  def test_musician_can_play_song()
    assert_equal("I'm playing Hey Joe!", @musician1.play_song("Hey Joe"))
  end

  def test_musican_can_play_song_on_piano()
    assert_equal("Plink plonk... I'm playing Killer Queen!", @musician2.play_song("Killer Queen"))
  end

end
