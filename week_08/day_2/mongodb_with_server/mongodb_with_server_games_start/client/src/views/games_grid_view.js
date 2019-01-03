const PubSub = require('../helpers/pub_sub.js');
const GameView = require('./game_view.js');

const GamesView = function (container) {
  this.container = container;
};

GamesView.prototype.bindEvents = function () {
  PubSub.subscribe('Games:data-loaded', (evt) => {
    this.render(evt.detail);
  });
};

GamesView.prototype.render = function (games) {
  this.container.innerHTML = '';
  const gameView = new GameView(this.container);
  games.forEach((game) => gameView.render(game));
};

module.exports = GamesView;
