const PubSub = require('../helpers/pub_sub');

const SelectView = function (element) {
  this.element = element;
}

SelectView.prototype.bindEvents = function () {
  PubSub.subscribe('CountryData:load', (evt) => {
    const optionTexts = evt.detail.map(country => country.name);
    this.render(optionTexts);
  })
}

SelectView.prototype.render = function (optionTexts) {

  optionTexts.forEach((optionText, index) => {
    const option = document.createElement('option');
    option.textContent = optionText;
    option.value = index;
    this.element.appendChild(option);
  })

  this.element.addEventListener('change', (evt) => {
    PubSub.publish('SelectView:change', evt.target.value);
  })

}


module.exports = SelectView;