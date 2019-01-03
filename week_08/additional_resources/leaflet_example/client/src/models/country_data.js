const Request = require('../helpers/request');
const PubSub = require('../helpers/pub_sub');

const CountryData = function () {
  this.countries = [];
};

CountryData.prototype.getData = function () {
  const request = new Request('https://restcountries.eu/rest/v2/all');
  request.get()
    .then(data => this.handleDataReady(data));
  PubSub.subscribe('SelectView:change', (evt) => {
    const selectedIndex = evt.detail;
    PubSub.publish('CountryData:selected-country', this.countries[selectedIndex]);
  });
};

CountryData.prototype.handleDataReady = function (countries) {
  this.countries = countries;
  PubSub.publish('CountryData:load', this.countries);
};

module.exports = CountryData;
