const CoinView = require('./views/coin_view.js');
const Coin = require('./models/coin.js');

document.addEventListener('DOMContentLoaded', () => {
  const coinContainer = document.querySelector('div#coin-info');
  const coinView = new CoinView(coinContainer);
  coinView.bindEvents();

  const bitCoinUrl = 'https://chasing-coins.com/api/v1/std/coin/BTC';
  const coin = new Coin(bitCoinUrl);
  coin.getData();
});
