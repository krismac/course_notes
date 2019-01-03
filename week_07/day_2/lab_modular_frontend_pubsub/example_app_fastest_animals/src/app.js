const Animals = require('./models/animals.js');
const SelectView = require('./views/select_view.js');
const AnimalInfoView = require('./views/animal_info_view.js');

document.addEventListener('DOMContentLoaded', function(){
  const selectElement = document.querySelector('select#animals-dropdown');
  const animalDropdown = new SelectView(selectElement);
  animalDropdown.bindEvents();

  const infoDiv = document.querySelector('div#animal-info')
  const animalInfoDisplay = new AnimalInfoView(infoDiv);
  animalInfoDisplay.bindEvents();

  const animalsDataSource = new Animals();
  animalsDataSource.bindEvents();
});
