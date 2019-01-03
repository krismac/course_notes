const GameFormView = require('./views/game_form_view.js')
const GameGridView = require('./views/games_grid_view.js');
const Games = require('./models/games.js');

document.addEventListener('DOMContentLoaded', () => {
  const gamesForm = document.querySelector('form#games-form');
  const gamesFormView = new GameFormView(gamesForm);
  gamesFormView.bindEvents();

  const gamesContainer = document.querySelector('div#games');
  const gamesGridView = new GameGridView(gamesContainer);
  gamesGridView.bindEvents();

  const games = new Games();
  games.bindEvents();
  games.getData();
});
