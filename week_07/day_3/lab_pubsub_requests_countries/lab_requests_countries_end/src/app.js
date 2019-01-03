const Countries = require('./models/countries.js');
const SelectView = require('./views/select_view.js');
const CountryView = require('./views/country_view.js');

document.addEventListener('DOMContentLoaded', () => {
  const selectElement = document.querySelector('select#countries');
  const selectView = new SelectView(selectElement);
  selectView.bindEvents();

  const countryContainer = document.querySelector('#country');
  const countryView = new CountryView(countryContainer);
  countryView.bindEvents();

  const countries = new Countries('https://restcountries.eu/rest/v2/all');
  countries.bindEvents();
  countries.getData();
});
