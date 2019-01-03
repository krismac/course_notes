const PubSub = require('../helpers/pub_sub');

const SelectView = function (selectElement) {
  this.selectElement = selectElement;
};

SelectView.prototype.bindEvents = function () {
  PubSub.subscribe('Munros:regions-ready', (evt) => {
    this.populateSelect(evt.detail);
  });

  this.selectElement.addEventListener('change', (evt) => {
    const selectedIndex = evt.target.value;
    PubSub.publish('SelectView:change', selectedIndex);
  });
};

SelectView.prototype.populateSelect = function (regions) {
  regions.forEach((region, index) => {
    const option = this.createRegionOption(region, index);
    this.selectElement.appendChild(option);
  })
};

SelectView.prototype.createRegionOption = function (region, index) {
  const option = document.createElement('option');
  option.textContent = region;
  option.value = index;
  return option;
};

module.exports = SelectView;
