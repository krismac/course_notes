const PubSub = require('../helpers/pub_sub.js');
const SightingView = require('./sighting_view.js');

const SightingsGridView = function (container) {
  this.container = container;
};

SightingsGridView.prototype.bindEvents = function () {
  PubSub.subscribe('Sightings:data-loaded', (evt) => {
    this.render(evt.detail);
  });
};

SightingsGridView.prototype.render = function (sightings) {
  this.container.innerHTML = '';
  const sightingView = new SightingView(this.container);
  sightings.forEach((sighting) => sightingView.render(sighting));
};

module.exports = SightingsGridView;
