class Room

  attr_reader :name, :songs, :guests

  def initialize(name, songs)
    @name = name
    @songs = songs
    @guests = []
  end

  def number_of_guests()
    return @guests.length()
  end

  def number_of_songs()
    return @songs.length()
  end

  def check_in_guest(guest)
    @guests.push(guest)
  end

  def check_in_multiple_guests(guests)
    guests.each {|guest| check_in_guest(guest)}
  end

  def check_out_guests()
    @guests = []
  end

  def add_song(song)
    @songs.push(song)
  end

  def add_multiple_songs(songs)
    songs.each {|song| add_song(song)}
  end

end