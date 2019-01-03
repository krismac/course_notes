import React, {Component} from 'react';
import Comment from './Comment.js';

class CommentList extends Component {
  render() {
    const commentNodes = this.props.data.map((comment) => {
      return <Comment
        key={comment.id}
        author={ comment.author }
        text={comment.text}
      />
    });

    return (
      <div className="comment-list">
        { commentNodes }
      </div>
    )
  }
}

export default CommentList;
