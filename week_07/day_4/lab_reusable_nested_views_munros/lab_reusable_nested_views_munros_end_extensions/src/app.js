const Munros = require('./models/munros.js');
const SelectView = require('./views/select_view.js');
const MunroListView = require('./views/munro_list_view.js');

document.addEventListener('DOMContentLoaded', () => {
  const selectElement = document.querySelector('select#region-select');
  const selectView = new SelectView(selectElement);
  selectView.bindEvents();

  const listContainer = document.querySelector('#munro-list');
  const munroListView = new MunroListView(listContainer);
  munroListView.bindEvents();

  const munros = new Munros;
  munros.bindEvents();
  munros.getData();
})
