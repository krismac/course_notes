import InstrumentFamilies from './models/instrument_families.js';
import SelectView from './views/select_view.js';
import InstrumentFamilyView from './views/instrument_family_view.js';
import data from './data/instrument_families.js';

document.addEventListener('DOMContentLoaded', () => {
  const selectElement = document.querySelector('select#instrument-families');
  const familyDropdown = new SelectView(selectElement);
  familyDropdown.bindEvents();

  const familyContainer = document.querySelector('div#instrument-family');
  const instrumentFamilyView = new InstrumentFamilyView(familyContainer);
  instrumentFamilyView.bindEvents();

  const instrumentFamilies = new InstrumentFamilies(data);
  instrumentFamilies.bindEvents();
});
