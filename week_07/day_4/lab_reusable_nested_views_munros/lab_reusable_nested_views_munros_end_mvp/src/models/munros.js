const RequestHelper = require('../helpers/request_helper.js');
const PubSub = require('../helpers/pub_sub.js');

const Munros = function () {
  this.munrosData = [];
  this.regions = [];
}

Munros.prototype.getData = function () {
  const requestHelper = new RequestHelper('https://munroapi.herokuapp.com/api/munros')
  requestHelper.get((data) => {
    PubSub.publish('Munros:munros-ready', data);
  });
}

module.exports = Munros;
