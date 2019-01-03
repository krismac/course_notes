require('minitest/autorun')
require('minitest/rg')
require_relative('../guest')
require_relative('../song')

class GuestTest < Minitest::Test

  def setup
    @song1 = Song.new("Livin La Vida Loca", "Ricky Martin")
    @guest = Guest.new("Bob", 10.0, @song1)
  end

  def test_guest_has_name
    assert_equal("Bob", @guest.name)
  end

  def test_guest_has_funds
    assert_equal(10.0, @guest.funds)
  end

  def test_guest_has_favourite_song
    assert_equal("Livin La Vida Loca", @guest.favourite_song.title)
  end

end
