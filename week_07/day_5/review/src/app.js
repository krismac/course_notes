const ListView = require('./views/list_view.js');
const Countries = require('./models/countries.js');
const PubSub = require('./helpers/pub_sub.js');

document.addEventListener('DOMContentLoaded', () => {
  const container = document.querySelector('section#country-list');
  const listView = new ListView(container);
  listView.setUpEventListeners();

  const countriesData = new Countries();
  countriesData.getData();
});
