import React from 'react'
import Cell from './Cell.jsx'

//var GridRow = function(props) {

class GridRow extends React.Component {
  constructor(props) {
      super(props);
      this.playSquare = this.playSquare.bind(this);
  }

  playSquare(cell) {
    this.props.playSquare(cell)
  }
  render() {
    var board = this.props.board;

    var cell = (index) => (
      <Cell
        id={index}
        player={this.props.player}
        playSquare={this.playSquare}
        gameWon={this.props.gameWon}
        contents={board[index]}/>
    )

    return(
      <tr>
        {cell(this.props.firstCell)}
        {cell(this.props.firstCell + 1)}
        {cell(this.props.firstCell + 2)}
      </tr>
    )
  }
}

export default GridRow;
