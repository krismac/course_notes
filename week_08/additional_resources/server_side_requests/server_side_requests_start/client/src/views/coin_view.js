const PubSub = require('../helpers/pub_sub.js');

const CoinView = function (container) {
  this.container = container;
};

CoinView.prototype.bindEvents = function () {
  PubSub.subscribe('Coin:data-ready', (evt) => this.render(evt.detail) );
};

CoinView.prototype.render = function (coin) {
  const price = document.createElement('p');
  price.textContent = `Currently £${coin.price}`;
  this.container.appendChild(price);
};

module.exports = CoinView;
