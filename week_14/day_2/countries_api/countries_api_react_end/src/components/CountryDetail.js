import React from 'react';

const CountryDetail = (props) => {
  if (!props.country) return null;
  return (
    <h3>{props.country.name}</h3>
  );
}

export default CountryDetail;
