import React, {Component, Fragment} from 'react';

class Comment extends Component {
  render() {
    return (
      <Fragment>
        <h4>{ this.props.author }</h4>
        <p>{this.props.text}</p>
      </Fragment>
    )
  }
}

export default Comment;
