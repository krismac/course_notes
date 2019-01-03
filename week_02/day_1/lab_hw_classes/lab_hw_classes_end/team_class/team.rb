class Team

  attr_reader :team_name, :players, :points
  attr_accessor :coach

  def initialize(team_name, players, coach_name)
    @team_name = team_name
    @players = players
    @coach = coach_name
    @points = 0
  end

  def add_player(new_player)
    @players << new_player
  end
  # Added in review:
  def add_many(new_players)
    for player in new_players
      # @players << player
      add_player(player)
    end
    # OR
    # @players.concat(new_players)
  end

  def has_player?(player)
    return @players.include?(player)
  end

  def play_game(game_won)
    if game_won
      @points += 3
    end
  end

end
