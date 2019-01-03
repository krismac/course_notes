const Consumables = require('./models/consumables.js');
const ListView = require('./views/list_view');
const FormView = require('./views/form_view');

document.addEventListener('DOMContentLoaded', () => {

  const formElement = document.querySelector('form#consumable-form');
  const formView = new FormView(formElement);
  formView.bindEvents();

  const teasListElement = document.querySelector('ul#teas-list');
  const teasListView = new ListView('teas', teasListElement);
  teasListView.bindEvents();

  const biscuitsListElement = document.querySelector('ul#biscuits-list');
  const biscuitsListView = new ListView('biscuits', biscuitsListElement);
  biscuitsListView.bindEvents();

  const apiUrl = 'http://localhost:3000/api';

  const teas = new Consumables('teas', `${apiUrl}/teas`);
  teas.bindEvents();
  teas.getData();

  const biscuits = new Consumables('biscuits', `${apiUrl}/biscuits`);
  biscuits.bindEvents();
  biscuits.getData();

});
