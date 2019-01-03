const SightingFormView = require('./views/sighting_form_view.js')
const SightingGridView = require('./views/sightings_grid_view.js');
const Sightings = require('./models/sightings.js');

document.addEventListener('DOMContentLoaded', () => {
  const sightingsForm = document.querySelector('form#sightings-form');
  const sightingsFormView = new SightingFormView(sightingsForm);
  sightingsFormView.bindEvents();

  const sightingsContainer = document.querySelector('div#sightings');
  const sightingsGridView = new SightingGridView(sightingsContainer);
  sightingsGridView.bindEvents();

  const sightings = new Sightings();
  sightings.bindEvents();
  sightings.getData();
});
