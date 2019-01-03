import React from 'react';

class NewGame extends React.Component{

  constructor(props) {
    super(props);

    this.handleButtonClick = this.handleButtonClick.bind(this);
  }

  handleButtonClick() {
    this.props.startNewGame();
  }

  render() {
    if (this.props.won || (this.props.turns == 9)) {
      return(
        <div>
          <button className="newGameBtn" onClick={this.handleButtonClick}>New Game</button>
        </div>
      )
    } else {
      return (<div></div>)
    }
  }
}

export default NewGame
