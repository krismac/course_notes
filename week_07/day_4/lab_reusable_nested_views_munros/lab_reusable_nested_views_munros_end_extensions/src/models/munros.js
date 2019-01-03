const RequestHelper = require('../helpers/request_helper.js');
const PubSub = require('../helpers/pub_sub.js');

const Munros = function () {
  this.munrosData = [];
  this.regions = [];
}

Munros.prototype.bindEvents = function () {
  PubSub.subscribe('SelectView:change', (evt)  => {
    const regionIndex = evt.detail;
    this.publishMunrosByRegion(regionIndex);
  })
};

Munros.prototype.getData = function () {
  const requestHelper = new RequestHelper('https://munroapi.herokuapp.com/api/munros')
  requestHelper.get((data) => {
    PubSub.publish('Munros:munros-ready', data);
    this.publishRegions(data);
  });
}

Munros.prototype.publishRegions = function (data) {
  this.munrosData = data;
  this.regions = this.uniqueRegionList();
  PubSub.publish('Munros:regions-ready', this.regions);
}

Munros.prototype.regionList = function () {
  const fullList = this.munrosData.map(munro => munro.region);
  return fullList;
}

Munros.prototype.uniqueRegionList = function () {
  return this.regionList().filter((munro, index, array) => {
    return array.indexOf(munro) === index;
  });
}

Munros.prototype.countriesByRegion = function (regionIndex) {
  const selectedRegion = this.regions[regionIndex];
  return this.munrosData.filter((munro) => {
    return munro.region === selectedRegion;
  });
};

Munros.prototype.publishMunrosByRegion = function (regionIndex) {
  const foundMunros = this.countriesByRegion(regionIndex);
  PubSub.publish('Munros:munros-ready', foundMunros);
};

module.exports = Munros;
