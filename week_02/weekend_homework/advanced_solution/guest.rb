class Guest

  attr_accessor(:name, :funds, :favourite_song)

  def initialize(name, funds, favourite_song)
    @name = name
    @funds = funds
    @favourite_song = favourite_song
  end

  def deduct_funds(cost)
    @funds = @funds - cost
  end

  def cheer(songs)
    songs.each {|song| return "Whooo!" if song.title == @favourite_song.title }
  end

  def sufficient_funds_for_entry?(entry_fee)
    return @funds >= entry_fee
  end

end