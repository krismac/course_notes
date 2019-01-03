import React, {Component} from 'react';

class PirateEditForm extends Component {
  constructor(props){
    super(props);
    this.state = {
      firstName: props.pirate.firstName,
      lastName: props.pirate.lastName,
      age: props.pirate.age,
      ship: props.pirate._embedded.ship._links.self.href.replace("{?projection}", ""),
      raidOptions: props.raids
    }
    console.log(this.state);
    this.handleSubmit = this.handleSubmit.bind(this)
  }

  componentWillReceiveProps(props) {
    console.log(props);
  }

 handleSubmit(event){
    event.preventDefault();
    console.log(this.state);
    const pirate = {
        "firstName": this.state.firstName,
        "lastName": this.state.lastName,
        "age": this.state.age,
        "ship": this.state.ship,
        "raids": [...this.state.raidOptions].filter((option) => {
          return option.selected
        }).map((option) => {
          return option.value
        })
      }
    this.props.handlePirateEdit(pirate)
  }


render(){

     const shipOptions = this.props.ships.map((ship, index) => {
      return <option key={index} value={ship._links.self.href}>{ship.name}</option>
    })

    const raidOptions = this.props.raids.map((raid, index) => {
      return <option key={index} value={raid._links.self.href}>{raid.location}</option>
    })


  return (
    <div>
      <form onSubmit={this.handleSubmit}>
        <input type="text" value = {this.state.firstName} name="firstName" onChange={e => this.setState({ firstName: e.target.value })}/>
        <input type="text" value = {this.state.lastName} name="lastName" onChange={e => this.setState({ lastName: e.target.value })}/>
        <input type="number" value = {this.state.age} name="age" onChange={e => this.setState({ age: e.target.value })}/>
        <select name="ship" onChange={e => this.setState({ ship: e.target.value })}>
          {shipOptions}
        </select>
        <select multiple name="raids" onChange={e => this.setState({raidOptions: e.target.options})} >
          {raidOptions}
        </select>
        <button type="submit">Save</button>
      </form>
    </div>

)
}
  }

  export default PirateEditForm;
