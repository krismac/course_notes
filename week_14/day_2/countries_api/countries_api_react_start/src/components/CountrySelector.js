import React from 'react';

const CountrySelector = (props) => {
  return (
    <select id="country-selector" defaultValue="default">
      <option disabled value="default">Choose a country...</option>
    </select>
  )
}

export default CountrySelector;
