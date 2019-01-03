import React, { Component } from 'react';
import PokedexContainer from './containers/PokedexContainer';

class App extends Component {
  render() {
    const generationOffsets = {
      1: {limit: 151, offset: 0},
      2: {limit: 100, offset: 151},
      3: {limit: 135, offset: 251},
      4: {limit: 107, offset: 386},
      5: {limit: 156, offset: 493},
      6: {limit: 72, offset: 649}
    }

    return (
      <PokedexContainer generationOffsets={generationOffsets} />
    );
  }
}

export default App;
