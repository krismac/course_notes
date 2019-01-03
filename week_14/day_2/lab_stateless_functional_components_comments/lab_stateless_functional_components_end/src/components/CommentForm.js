import React, { Component } from 'react';

class CommentForm extends Component {

  constructor(props) {
    super(props);
    this.state = {
      author: '',
      text: ''
    };

    this.handleAuthorChange = this.handleAuthorChange.bind(this);
    this.handleTextChange = this.handleTextChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(event) {
    event.preventDefault();
    const author = this.state.author.trim();
    const text = this.state.text.trim();
    if (!text || !author) {
      return
    }
    this.props.onCommentSubmit({author: author, text: text});
    this.setState({author: '', text: ''});
  }

  handleAuthorChange(event) {
    this.setState({author: event.target.value});
  }

  handleTextChange(event) {
    this.setState({text: event.target.value});
  }

  render() {
     return (
       <form className="comment-form" onSubmit={this.handleSubmit}>
         <input
           type="text"
           placeholder="Your name"
           value={this.state.author}
           onChange={this.handleAuthorChange}
         />
         <input
           type="text"
           placeholder="Say something..."
           value={this.state.text}
           onChange={this.handleTextChange}
         />
         <input type="submit" value="Post" />
       </form>
     )
   }
}

export default CommentForm;
