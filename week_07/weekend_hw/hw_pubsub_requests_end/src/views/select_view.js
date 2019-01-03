const pubSub = require('../helpers/pub_sub');

const SelectView = function (selectElement) {
  this.selectElement = selectElement;
};

SelectView.prototype.bindEvents = function () {
  pubSub.subscribe('Deck:deck-updated', (evt) => {
    const totalNumberOfCards = evt.detail;
    this.populateSelect(totalNumberOfCards);
  });

  this.selectElement.addEventListener('change', (evt) => {
    const selectedNumber = evt.target.value;
    pubSub.publish('SelectView:number-of-cards-selected', selectedNumber);
  });
};

SelectView.prototype.populateSelect = function (numberOfOptionsToCreate) {
  this.clear();
  this.createDefaultOption();
  this.createOptions(numberOfOptionsToCreate);
};

SelectView.prototype.clear = function () {
  this.selectElement.innerHTML = '';
};

SelectView.prototype.createDefaultOption = function () {
  const defaultOption = document.createElement('option');
  defaultOption.default = true;
  defaultOption.selected = true;
  this.selectElement.appendChild(defaultOption);
};

SelectView.prototype.createOptions = function (numberOfOptionsToCreate) {
  for (let i = 1; i <= numberOfOptionsToCreate; i++) {
    this.createOption(i);
  }
};

SelectView.prototype.createOption = function (numberToDisplay) {
  const option = document.createElement('option');
  option.textContent = numberToDisplay;
  option.value = numberToDisplay;
  this.selectElement.appendChild(option);
};

module.exports = SelectView;
