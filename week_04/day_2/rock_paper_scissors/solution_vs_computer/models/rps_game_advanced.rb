class RpsGame

  attr_reader(:player_move, :computer_move, :all_moves)

  def initialize(move_played)
    @player_move = move_played.to_sym
    @win_lookup = [
      {scissors: :paper},
      {paper: :rock},
      {rock: :lizard},
      {lizard: :spock},
      {spock: :scissors},
      {scissors: :lizard},
      {lizard: :paper},
      {paper: :spock},
      {spock: :rock},
      {rock: :scissors}
    ]
    @all_moves = get_moves()
    @computer_move = @all_moves.sample()
  end

  def get_moves
    all_hash_keys = @win_lookup.map do |hash|
      keys = hash.keys()
      keys[0]
    end
    moves = all_hash_keys.uniq()
    return moves
  end

  def result
    return "draw" if draw?()
    return "win" if win?()
    return "lose" if lose?()
  end

  def win?
    won = false
    for rule in @win_lookup
      if rule[@player_move] == @computer_move
        won = true
      end
    end
    return won
  end

  def draw?
    return (@player_move == @computer_move)
  end

  def lose?
    lost = false
    for rule in @win_lookup
      if rule[@computer_move] == @player_move
        lost = true
      end
    end
    return lost
  end

end