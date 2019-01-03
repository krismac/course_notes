const CoinView = require('./views/coin_view.js');
const Coin = require('./models/coin.js');

document.addEventListener('DOMContentLoaded', () => {
  const coinContainer = document.querySelector('div#coin-info');
  const coinView = new CoinView(coinContainer);
  coinView.bindEvents();

  const bitCoinUrl = 'http://localhost:3000/coin-data';
  const coin = new Coin(bitCoinUrl);
  coin.getData();
});
