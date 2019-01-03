import React from 'react';

const PokemonDetail = (props) => {
  return (
    <div className='pokemon-detail'>
      <h1 className='pokemon-title'>#{props.pokemon.id}: {props.pokemon.name}</h1>
      <img
        className='pokemon-image' src={props.pokemon.image}
        alt={props.pokemon.name + ' image'}
      />
      <h4 className='pokemon-type'>{props.pokemon.types.join(' / ')}</h4>
    </div>
  );
};

export default PokemonDetail;
