import React, {Component} from 'react';

class CommentForm extends Component {
  constructor() {
    super();
    this.state = {
      author: '',
      text: ''
    };
    this.handleAuthorChange = this.handleAuthorChange.bind(this);
    this.handleTextChange = this.handleTextChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleAuthorChange(event) {
    const author = event.target.value;
    this.setState({author: author});
  }
  handleTextChange(event) {
    const text = event.target.value;
    this.setState({text: text});
  }
  handleSubmit(event) {
    event.preventDefault();
    const {author, text} = this.state;

    if (!author || !text) {
      return;
    }
    const comment = {author: author, text: text};
    this.props.handleCommentSubmit(comment);
    this.setState({author: '', text: ''});
  }
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <input
          type="text"
          placeholder="Name"
          value={this.state.author}
          onChange={this.handleAuthorChange}
        />
        <input
          type="text"
          placeholder="Say something"
          value={ this.state.text }
          onChange={this.handleTextChange}
        />
        <input
          type="submit"
          value="Post"
        />
      </form>
    );
  }
}

export default CommentForm;
