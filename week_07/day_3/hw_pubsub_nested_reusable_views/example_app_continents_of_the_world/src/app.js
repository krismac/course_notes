const ContinentListView = require('./views/continents_list_view.js');
const Continents = require('./models/continents.js');

document.addEventListener('DOMContentLoaded', () => {
  const continentsListContainer = document.querySelector('#continents');
  const continentsListView = new ContinentListView(continentsListContainer);
  continentsListView.bindEvents();

  const continents = new Continents();
  continents.getData();
});
