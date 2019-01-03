import React from 'react';

const GenerationSelect = (props) => {
  const options = props.generations.map((generation, index) => {
    return (
      <option key={index} value={generation}>{generation}</option>
    )
  });

  return (
    <div className='generation-select'>
      <label>Generation: </label>
      <select
      disabled={props.locked}
      onChange={props.handleGenerationSelected}
      value={props.selectedGeneration}
      >
        { options }
      </select>
    </div>
  );
};

export default GenerationSelect;
