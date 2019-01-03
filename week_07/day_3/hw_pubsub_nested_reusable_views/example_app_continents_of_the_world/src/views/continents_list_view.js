const PubSub = require('../helpers/pub_sub.js');
const ContinentView = require('./continent_view.js');

const ContinentsListView = function (container) {
  this.container = container;
}

ContinentsListView.prototype.bindEvents = function () {
  PubSub.subscribe('Continents:continents-data-ready', (evt) => {
    this.continents = evt.detail;
    this.render();
  });
};

ContinentsListView.prototype.render = function () {
  this.continents.forEach((continent) => {
    const continentView = new ContinentView(this.container, continent);
    continentView.render();
  });
};



module.exports = ContinentsListView;
