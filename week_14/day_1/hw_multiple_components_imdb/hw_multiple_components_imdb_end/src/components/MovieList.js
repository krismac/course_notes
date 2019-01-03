import React, { Component } from 'react';
import MovieItem from './MovieItem';
import './MovieList.css';

class MovieList extends Component {

  render() {
    const movieItems = this.props.movies.map((movie) => {
      return (
        <MovieItem
          movie={movie}
          key={movie.id}
        />
      );
    });
    return (
      <div className='movie-list'>
        <ul>
          {movieItems}
        </ul>
      </div>
    );
  }

}

export default MovieList;
