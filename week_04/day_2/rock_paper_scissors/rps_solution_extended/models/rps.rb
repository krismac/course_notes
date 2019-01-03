class RPSGame

  def self.check_win(player1, player2)
    hand1 = player1[:hand].downcase
    hand2 = player2[:hand].downcase

    win = {
      "rock" => "scissors",
      "scissors" => "paper",
      "paper" => "rock"
    }

    winner = nil

    if win[hand1] == hand2
      winner = player1
    elsif win[hand2] == hand1
      winner = player2
    end
  
    if winner != nil
      return "Player #{winner[:player_no]} won by playing #{winner[:hand]}!"
    elsif hand1 == hand2
      return "It was a draw."
    else
      return "oops, looks like you didn't enter valid inputs!"
    end

  end


end
