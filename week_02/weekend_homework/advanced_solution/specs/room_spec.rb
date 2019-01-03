require('minitest/autorun')
require('minitest/rg')
require('pry-byebug')
require_relative('../room')
require_relative('../song')
require_relative('../guest')

class RoomTest < Minitest::Test

  def setup
    @song1 = Song.new("Girlfriend", "NSYNC")
    @song2 = Song.new("Power of Love", "Huey Lewis and the News")
    @song3 = Song.new("Pretty Rave Girl", "Daddy DJ")
    @song4 = Song.new("You shook me all night long", "AC/DC")
    @song5 = Song.new("Barbie Girl", "Aqua")
    @song6 = Song.new("Ode to Joy", "Beethoven")

    @songs1 = [@song1, @song2, @song3, @song4]

    @songs2 = [@song5, @song6]

    @room = Room.new("CodeClan Room", 3, @songs1, 0.5)
    @guest1 = Guest.new("Alice", 15.0, @song2)
    @guest2 = Guest.new("Bob", 500.0, @song1)
    @guest3 = Guest.new("Charlie", 1.0, @song3)
    @guest4 = Guest.new("Dave", 20.0, @song4)

    @guests = [@guest1, @guest2, @guest3]
  end

  def test_room_has_name
    assert_equal("CodeClan Room", @room.name)
  end

  def test_room_has_songs
      assert_equal(4, @room.number_of_songs)
  end

  def test_can_check_in_guests
    @room.check_in_guests(@guests)
    assert_equal(3, @room.guests.count)
  end

  def test_cannot_be_overbooked
    @room.check_in_guests(@guests)
    assert_equal(0, @room.check_in_guests([@guest4]))
  end

  def test_guests_can_check_out
    @room.check_in_guests(@guests)
    @room.check_out_guests
    assert_equal(0, @room.guests.count)
  end

  def test_can_cheer
    @room.check_in_guests(@guests)
    songs = @room.songs
    assert_equal("Whooo!", @guests[0].cheer(songs))
  end

  def test_money_got_deducted_for_entry
    @room.check_in_guests(@guests)
    assert_equal(1.5, @room.income)
  end

  def test_can_add_one_song
    @room.add_song(@song5)
    assert_equal(5, @room.number_of_songs)
  end

  def test_can_add_multiple_songs
    @room.add_multiple_songs(@songs2)
    assert_equal(6, @room.number_of_songs)
  end


end
