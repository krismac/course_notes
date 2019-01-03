import React from 'react'

class GameStatus extends React.Component {
  
  render(){
    var currentState;

    if (this.props.winner !== "") {
      currentState = this.props.winner + " wins!";
    } else if (!this.props.won && this.props.turns === 9) {
      currentState = "It's a tie";
    } else {
      currentState = this.props.currentPlayer + " to go.";
    }
    return(
      <div>
        <h2>{currentState}</h2>
      </div>
      )
  }
}

export default GameStatus;