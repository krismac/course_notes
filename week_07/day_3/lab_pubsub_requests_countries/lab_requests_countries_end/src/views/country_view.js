const PubSub = require('../helpers/pub_sub.js');

const CountryView = function (container) {
  this.container = container;
};

CountryView.prototype.bindEvents = function () {
  PubSub.subscribe('Countries:selected-country-ready', (evt) => {
    this.clearCountry();
    this.render(evt.detail);
  });
};

CountryView.prototype.render = function (country) {
  const countryName = this.createTextElement('h2', country.name);
  this.container.appendChild(countryName);

  const flagImage = document.createElement('img');
  flagImage.src = country.flag;
  this.container.appendChild(flagImage);

  const regionTitle = this.createTextElement('h3', 'Region:');
  this.container.appendChild(regionTitle);

  const countryRegion = this.createTextElement('p', country.region);
  this.container.appendChild(countryRegion);

  const languagesListTitle = this.createTextElement('h3', 'Languages:');
  this.container.appendChild(languagesListTitle);

  const languagesList = document.createElement('ul');
  this.populateLanguageList(country.languages, languagesList);
  this.container.appendChild(languagesList);
};

CountryView.prototype.createTextElement = function (elementType, text) {
  const element = document.createElement(elementType);
  element.textContent = text;
  return element;
};

CountryView.prototype.populateLanguageList = function (languages, list) {
  languages.forEach((language) => {
    const listItem = document.createElement('li');
    listItem.textContent = language.name;
    list.appendChild(listItem);
  });
};

CountryView.prototype.clearCountry = function () {
  this.container.innerHTML = '';
};

module.exports = CountryView;
