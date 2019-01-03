const PubSub = require('../helpers/pub_sub.js');

const Coin = function (url) {
  this.url = url;
  this.coin = null;
};

Coin.prototype.getData = function () {
  fetch(this.url)
      .then(res => res.json())
      .then(data => PubSub.publish('Coin:data-ready', data));
};

module.exports = Coin;
