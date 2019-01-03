require('minitest/autorun')
require('minitest/rg')
require_relative('../room')
require_relative('../song')
require_relative('../guest')

class RoomTest < Minitest::Test

  def setup
    @song1 = Song.new("Girlfriend", "NSYNC")
    @song2 = Song.new("Power of Love", "Huey Lewis and the News")
    @song3 = Song.new("Pretty Rave Girl", "Daddy DJ")
    @song4 = Song.new("You shook me all night long", "AC/DC")

    @songs1 = [@song1, @song2, @song3]

    @room = Room.new("CodeClan Room", @songs1)
    @guest1 = Guest.new("Alice")
    @guest2 = Guest.new("Bob")
    @guest3 = Guest.new("Charlie")

    @guests = [@guest1, @guest2]
  end

  def test_room_has_name
    assert_equal("CodeClan Room", @room.name())
  end

  def test_room_has_songs
      assert_equal(3, @room.number_of_songs())
  end

  def test_can_check_in_guest
    @room.check_in_guest(@guest3)
    assert_equal(1, @room.number_of_guests())
  end

  def test_can_check_in_multiple_guests
    @room.check_in_multiple_guests(@guests)
    assert_equal(2, @room.number_of_guests())
  end

  def test_guests_can_check_out
    @room.check_in_multiple_guests(@guests)
    @room.check_out_guests()
    assert_equal(0, @room.number_of_guests())
  end

  def test_can_add_one_song
    @room.add_song(@song4)
    assert_equal(4, @room.number_of_songs())
  end


end
