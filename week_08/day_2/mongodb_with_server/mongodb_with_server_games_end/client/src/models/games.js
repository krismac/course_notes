const Request = require('../helpers/request.js');
const PubSub = require('../helpers/pub_sub.js');

const Games = function () {
  this.url = 'http://localhost:3000/api/games';
  this.request = new Request(this.url);
};

Games.prototype.bindEvents = function () {
  PubSub.subscribe('GameView:game-delete-clicked', (evt) => {
    this.deleteGame(evt.detail);
  });

  PubSub.subscribe('GameView:game-submitted', (evt) => {
    this.postGame(evt.detail);
  })
};

Games.prototype.getData = function () {
  this.request.get()
    .then((games) => {
      PubSub.publish('Games:data-loaded', games);
    })
    .catch(console.error);
};

Games.prototype.postGame = function (game) {
  this.request.post(game)
    .then((games) => {
      PubSub.publish('Games:data-loaded', games);
    })
    .catch(console.error);
};

Games.prototype.deleteGame = function (gameId) {
  this.request.delete(gameId)
    .then((games) => {
      PubSub.publish('Games:data-loaded', games);
    })
    .catch(console.error);
};

module.exports = Games;
