import React from 'react';

const TitleBar = (props) =>{
  return (
    <div>
      <h1>Hit Parade</h1>
      <select onChange={props.handleSelectChange}>
        {props.genres.map(genre => {
          return <option key={genre.name} value={genre.url}>{genre.name}</option>
        })}
      </select>
    </div>
  );
};

export default TitleBar;
