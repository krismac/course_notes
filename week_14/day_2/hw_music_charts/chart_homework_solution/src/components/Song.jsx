import React, {Component} from 'react';

class Song extends Component {

  render(){
    const altTag = `${this.props.title} by ${this.props.artist}`;

    return (
      <div className="song">
        <img
          alt={"Play " + altTag}
          id={this.props.position}
          className='audio-control'
          src='https://image.freepik.com/free-icon/play-button_318-42541.jpg'
          onClick={() => {this.props.handlePlayPause(this.audio)}}
        />

        <img
          src={this.props.image}
          alt={altTag} />

        <div className='details'>
          <h3>{this.props.position}. {this.props.title}</h3>
          <h4>{this.props.artist}</h4>
        </div>

        <audio
          ref={(audio) => this.audio = audio}
          id={'audio' + this.props.position}
          src={this.props.audio} />
      </div>
    );
  }
};

export default Song;
