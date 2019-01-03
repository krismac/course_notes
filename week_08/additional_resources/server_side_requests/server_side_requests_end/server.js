const express = require('express');
const app = express();
const fetch = require('node-fetch');

app.use(express.static('client/public'));

app.get('/', (req, res) => {
  res.sendFile('index.html');
});

app.get('/coin-data', (req, res) => {
  const url = 'https://chasing-coins.com/api/v1/std/coin/BTC';

  fetch(url)
    .then(jsonData => jsonData.json())
    .then(data => res.json(data));
});

app.listen(3000, function () {
  console.log(`App running on port ${ this.address().port }`);
});
