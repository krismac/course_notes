import React from 'react';
import CountrySelector from '../components/CountrySelector';
import CountryDetail from '../components/CountryDetail';

class CountryContainer extends React.Component {
  constructor(props){
    super(props);
    this.state = {};
  }

  render(){
    return (
      <div>
        <h2>Country Container</h2>
        <CountrySelector />
        <CountryDetail />
      </div>
    );
  }
}

export default CountryContainer;
