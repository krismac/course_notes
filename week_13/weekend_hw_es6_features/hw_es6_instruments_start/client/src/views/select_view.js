const PubSub = require('../helpers/pub_sub.js');

const SelectView = function (element) {
  this.element = element;
};

SelectView.prototype.bindEvents = function () {
  PubSub.subscribe('InstrumentFamilies:data-ready', (evt) => {
    const allInstrumentFamilies = evt.detail;
    this.populate(allInstrumentFamilies);
  });

  this.element.addEventListener('change', (evt) => {
    const selectedIndex = evt.target.value;
    PubSub.publish('SelectView:change', selectedIndex);
  });
};

SelectView.prototype.populate = function (instrumentFamilyData) {
  instrumentFamilyData.forEach((familiy, index) => {
    const option = document.createElement('option');
    option.textContent = familiy.name;
    option.value = index;
    this.element.appendChild(option);
  });
};

module.exports = SelectView;
