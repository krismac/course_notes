const PubSub = require('../helpers/pub_sub.js');
const GameView = require('./game_view.js');

const GamesGridView = function (container) {
  this.container = container;
};

GamesGridView.prototype.bindEvents = function () {
  PubSub.subscribe('Games:data-loaded', (evt) => {
    this.render(evt.detail);
  });
};

GamesGridView.prototype.render = function (games) {
  this.container.innerHTML = '';
  const gameView = new GameView(this.container);
  games.forEach((game) => gameView.render(game));
};

module.exports = GamesGridView;
