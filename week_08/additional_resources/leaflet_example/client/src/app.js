const MapView = require('./views/map_view');
const SelectView = require('./views/select_view');
const CountryData = require('./models/country_data');

document.addEventListener('DOMContentLoaded', () => {
  const countryData = new CountryData();
  countryData.getData();

  const mapDiv = document.querySelector('#map');
  const glasgowCoords = [55.86, -4.25];
  const zoomLevel = 10;
  const mapView = new MapView(mapDiv, glasgowCoords, zoomLevel);
  mapView.init();
  mapView.bindEvents();

  const countrySelect = document.querySelector('#country-select');
  const countrySelectView = new SelectView(countrySelect);
  countrySelectView.bindEvents();
});
