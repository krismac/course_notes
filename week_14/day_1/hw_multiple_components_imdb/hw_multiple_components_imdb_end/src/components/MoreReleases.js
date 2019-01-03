import React, { Component } from 'react';
import './MoreReleases.css';

class MoreReleases extends Component {

  render() {
    return (
      <div className='more-releases'>
        <a href={'http://www.imdb.com/calendar/?region=gb'}>
          View more upcoming releases >>
        </a>
      </div>
    );
  }

}


export default MoreReleases;
