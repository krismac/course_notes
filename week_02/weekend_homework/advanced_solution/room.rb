class Room

  attr_accessor(:name, :max_capacity, :songs, :guests, :income)

  def initialize(name, max_capacity, songs, entry_fee)
    @name = name
    @max_capacity = max_capacity
    @songs = songs
    @guests = []
    @entry_fee = entry_fee
    @income = 0
  end

  def number_of_songs
    return @songs.count
  end

  def number_of_guests
    return @guests.count
  end

  def add_song(song)
    @songs << song
  end

  def add_multiple_songs(songs)
    @songs.concat(songs)
  end


  def check_in_guests(guests)
    checked_in_guests = 0
    return checked_in_guests unless is_available?(guests)

     guests.each do |guest|

        next unless guest.sufficient_funds_for_entry?(@entry_fee)
        check_in_guest(guest)
        checked_in_guests += 1
     end
    add_income_to_room(checked_in_guests)
    return checked_in_guests
  end

  def check_in_guest(guest)
    guest.deduct_funds(@entry_fee)
    @guests.push(guest) 
  end

  def check_out_guests
    @guests.clear
  end

  def add_income_to_room(checked_in_guests)
    @income += checked_in_guests * @entry_fee
  end

  def is_available?(guests)
    return number_of_guests <= free_spaces && free_spaces != 0
  end

  def free_spaces
    free_spaces = @max_capacity - @guests.size
    return free_spaces
  end


end