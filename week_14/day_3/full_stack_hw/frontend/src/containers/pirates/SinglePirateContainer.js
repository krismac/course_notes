import React, {Component} from 'react';
import Pirate from '../../components/pirates/Pirate.js';
import PirateDetails from '../../components/pirates/PirateDetails.js';

import Request from '../../helpers/request.js';

class SinglePirateContainer extends Component {
  constructor(props){
    super(props);
    this.state = {pirate: null}
    this.handleDelete = this.handleDelete.bind(this)
    this.handleEdit= this.handleEdit.bind(this)
  }

  componentDidMount(){
    let request = new Request()
    const url = '/api/pirates/' + this.props.id + '?projection=embedShip';
    request.get(url).then((data) => {
      this.setState({pirate: data})
    })
  }

  handleDelete(id){
    const request = new Request();
    const url = '/api/pirates/' + id;
    request.delete(url).then(() => {
      window.location = '/pirates'
    })
  }

  handleEdit(id){
    window.location = '/pirates/edit/' + id
  }


  render(){
    if(!this.state.pirate){
      return null;
    }
    return (
      <div className="component">
       <Pirate ship = {this.state.pirate._embedded.ship} pirate = {this.state.pirate} />
       <PirateDetails pirate = {this.state.pirate} raids={this.state.pirate._embedded.raids} handleDelete = {this.handleDelete} handleEdit={this.handleEdit}/>
     </div>
    )

  }
}

export default SinglePirateContainer;
