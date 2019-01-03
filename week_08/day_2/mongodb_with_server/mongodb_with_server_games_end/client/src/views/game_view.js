const PubSub = require('../helpers/pub_sub.js');

const GameView = function (container) {
  this.container = container;
};

GameView.prototype.render = function (game) {
  const gameContainer = document.createElement('div');
  gameContainer.id = 'game';

  const name = this.createHeading(game.name);
  gameContainer.appendChild(name);

  const playingTimeText = `Playing Time: ${game.playingTime} minutes`;
  const playingTime = this.createDetail(playingTimeText);
  gameContainer.appendChild(playingTime);

  const playersText = `Players: ${game.players.min} - ${game.players.max}`;
  const players = this.createDetail(playersText);
  gameContainer.appendChild(players);

  const deleteButton = this.createDeleteButton(game._id);
  gameContainer.appendChild(deleteButton);

  this.container.appendChild(gameContainer);
};

GameView.prototype.createHeading = function (textContent) {
  const heading = document.createElement('h3');
  heading.textContent = textContent;
  return heading;
};

GameView.prototype.createDetail = function (textContent) {
  const detail = document.createElement('p');
  detail.textContent = textContent;
  return detail;
};

GameView.prototype.createDeleteButton = function (gameId) {
  const button = document.createElement('button');
  button.classList.add('delete-btn');
  button.value = gameId;

  button.addEventListener('click', (evt) => {
    PubSub.publish('GameView:game-delete-clicked', evt.target.value);
  });

  return button;
};

module.exports = GameView;
