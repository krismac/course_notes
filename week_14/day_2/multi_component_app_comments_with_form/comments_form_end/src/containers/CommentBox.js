import React, {Component} from 'react';
import CommentList from '../components/CommentList.js';
import CommentForm from '../components/CommentForm.js';

class CommentBox extends Component {
  constructor() {
    super();
    this.state = {
      comments: [
        {
          id: 1,
          author: 'Nyalls',
          text: 'Can we talk about Brexit yet?'
        },
        {
          id: 2,
          author: 'Craig',
          text: 'No politics!!!'
        }
      ]
    };
    this.handleCommentSubmit = this.handleCommentSubmit.bind(this);
  }

  handleCommentSubmit(newComment) {
    newComment.id = Date.now();
    // ES5:
    // const updatedComments = this.state.comments.concat([newComment]);
    // ES2016?
    const updatedComments = [
      newComment,
      ...this.state.comments
    ];
    this.setState({comments: updatedComments})
  }

  render() {
    return (
      <>
        <CommentForm
          handleCommentSubmit={this.handleCommentSubmit}
        />
        <CommentList data={this.state.comments}/>
      </>
    );
  }
}

export default CommentBox;
