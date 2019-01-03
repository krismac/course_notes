import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import NavBar from './NavBar.js'

import PirateListContainer from './containers/pirates/PirateListContainer'
import SinglePirateContainer from './containers/pirates/SinglePirateContainer';
import PirateFormContainer from './containers/pirates/PirateFormContainer';
import PirateEditFormContainer from './containers/pirates/PirateEditFormContainer';



class App extends Component {
  render() {
    return (
      <Router >
        <React.Fragment>
          <NavBar />
          <Switch>
          <Route exact path = '/pirates' component={PirateListContainer}/>
          <Route exact path = '/pirates/new' component={PirateFormContainer}/>
          <Route exact path="/pirates/edit/:id" render = {(props) =>{
            const id = props.match.params.id;
            return <PirateEditFormContainer id = {id} />
            }}
          />
          <Route exact path="/pirates/:id" render = {(props) =>{
            const id = props.match.params.id;
            return <SinglePirateContainer id = {id} />
            }}
          />
          </Switch>
        </React.Fragment>
      </Router>

    );
  }
}

export default App;
