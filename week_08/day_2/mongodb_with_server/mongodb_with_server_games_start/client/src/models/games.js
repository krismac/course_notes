const Request = require('../helpers/request.js');
const PubSub = require('../helpers/pub_sub.js');

const Games = function (url) {
  this.url = url;
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
  const request = new Request(this.url);
  request.get()
    .then((games) => {
      PubSub.publish('Games:data-loaded', games);
    })
    .catch(console.error);
};

Games.prototype.postGame = function (game) {
  const request = new Request(this.url);
  request.post(game)
    .then((games) => {
      PubSub.publish('Games:data-loaded', games);
    })
    .catch(console.error);
};

Games.prototype.deleteGame = function (gameId) {
  const request = new Request(this.url);
  request.delete(gameId)
    .then((games) => {
      PubSub.publish('Games:data-loaded', games);
    })
    .catch(console.error);
};

module.exports = Games;
