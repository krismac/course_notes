class Band

  attr_reader :name, :members

  def initialize(name, members)
    @name = name
    @members = members
  end

  def perform(song)
    performance = []
    for musician in @members
      performance.push(musician.play_song(song))
    end
    return performance
  end

end
