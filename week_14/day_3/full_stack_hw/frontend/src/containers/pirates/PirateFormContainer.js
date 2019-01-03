import React, {Component} from 'react';

import Request from '../../helpers/request';
import PirateForm from '../../components/pirates/PirateForm'

class PirateFormContainer extends Component {
  constructor(props){
    super(props);
    this.state = {ships: [], raids: []};
    this.handlePiratePost = this.handlePiratePost.bind(this);
  }

  componentDidMount(){
    const request = new Request();
    request.get("/api/ships").then((data) => {
      this.setState({ships: data._embedded.ships})
    }).then(() => {
      request.get('/api/raids').then((data) => {
        this.setState({raids: data._embedded.raids})
      });
    });
  }

  handlePiratePost(pirate, raidId){
    const request = new Request();
    request.post('/api/pirates', pirate).then(() => {
      window.location = '/pirates'
    })

    
  }

  render(){

    return <PirateForm
      ships={this.state.ships}
      raids={this.state.raids}
      handlePiratePost={this.handlePiratePost} 
      
      />

  }
}

export default PirateFormContainer;