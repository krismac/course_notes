const PubSub = require('../helpers/pub_sub.js');
const CountryView = require('./country_view.js');

const ListView = function (container) {
  this.container = container;
}

ListView.prototype.setUpEventListeners = function () {
  PubSub.subscribe('Countries:countries-loaded', (evt) => {
    const countries = evt.detail;
    this.render(countries);
  });
}

ListView.prototype.render = function (countries) {
  countries.forEach(country => {
    const countryView = new CountryView();
    const div = countryView.create(country);
    this.container.appendChild(div);
  });
}

module.exports = ListView;
