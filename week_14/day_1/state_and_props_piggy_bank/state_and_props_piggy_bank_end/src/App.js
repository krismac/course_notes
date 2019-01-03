import React, { Component } from 'react';
import PiggyBank from './PiggyBank';

class App extends Component {
  render() {
    return (
      <PiggyBank
        title="Savings Pig"
        depositAmount={5}
      />
    );
  }
}

export default App;
