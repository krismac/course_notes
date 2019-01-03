require('minitest/autorun')
require('minitest/rg')
require_relative('../song')

class GuestTest < Minitest::Test

  def setup
    @song = Song.new("Ricky Martin", "Livin La Vida Loca")
  end

  def test_song_has_title
    assert_equal("Livin La Vida Loca", @song.title())
  end

  def test_song_has_author
    assert_equal("Ricky Martin", @song.artist())
  end

end