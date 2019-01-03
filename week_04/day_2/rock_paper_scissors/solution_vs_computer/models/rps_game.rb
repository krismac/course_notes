class RpsGame

  attr_reader(:player_move, :computer_move, :all_moves)

  def initialize(move_played)
    @player_move = move_played.to_sym
    @win_lookup = {
      scissors: :paper,
      paper: :rock,
      rock: :scissors
    }
    @all_moves = @win_lookup.keys()
    @computer_move = @all_moves.sample()
  end

  def result
    return "draw" if draw?()
    return "win" if win?()
    return "lose" if lose?()
  end

  def win?
    return (@win_lookup[@player_move] == @computer_move)
  end

  def draw?
    return (@player_move == @computer_move)
  end

  def lose?
    return (@win_lookup[@computer_move] == @player_move)
  end

end