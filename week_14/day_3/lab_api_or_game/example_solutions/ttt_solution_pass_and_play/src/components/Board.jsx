import React from 'react'
import Cell from './Cell.jsx'
import Row from './GridRow.jsx'

class Board extends React.Component {
  constructor(props) {
    super(props);
    this.state = { board: this.props.board, won: false};

    this.takeTurn = this.takeTurn.bind(this);
  }

  checkRowsForWinner() {
    var board = this.props.board;
    if (((board[0] !== "") && (board[0] === board[1]) &&
         (board[0] === board[2])) ||
        ((board[3] !== "") &&(board[3] === board[4]) &&
         (board[3] === board[5])) ||
        ((board[6] !== "") &&(board[6] === board[7]) &&
         (board[6] === board[8]))
      ) {
      return true
    }
    return false
  }

  checkColumnsForWinner() {
    var board = this.props.board;
    if (((board[0] !== "") && (board[0] == board[3]) &&
         (board[0] === board[6])) ||
        ((board[1] !== "") &&(board[1] === board[4]) &&
         (board[1] === board[7])) ||
        ((board[5] !== "") &&(board[2] === board[5]) &&
         (board[2] === board[8]))
      ) {
      return true;
    }
    return false;
  }

  checkDiagonalsForWinner() {
    var board = this.props.board;
    if ((board[4] !== "") && (((board[0] === board[4]) && (board[0] === board[8])) ||
        ((board[2] === board[4]) && (board[2] === board[6])))) {
        return true;
    }
    return false;
  }

  checkForWinner() {
    if (
      (this.checkColumnsForWinner() === true) ||
      (this.checkRowsForWinner() === true) ||
      (this.checkDiagonalsForWinner() === true)
      ) {
        this.props.endGame();
      } else {
        this.props.changePlayer();
      }
  }

  takeTurn(square) {
    this.props.update(square);
    this.checkForWinner();
  }

  render() {
    var board = this.props.board;

    var row = (firstCell) => (
        <Row
          firstCell={firstCell}
          player={this.props.player}
          playSquare={this.takeTurn}
          gameWon={this.props.won}
          board={this.props.board}
        />
    )

    return (
      <div>
        <h1>Tic Tac Toe</h1>
        <table id="ticTacToeGrid">
          <tbody>
            {row(0)}
            {row(3)}
            {row(6)}
          </tbody>
        </table>
      </div>
    )
  }
}

export default Board;
