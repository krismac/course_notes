const DeckData = require('./models/deck_data.js');
const Deck = require('./models/deck.js');
const SelectView = require('./views/select_view.js');
const HandView = require('./views/hand_view.js');

document.addEventListener('DOMContentLoaded', () => {
  const cardContainer = document.querySelector('#card-container');
  const clearCardsButton = document.querySelector('button#clear-cards');
  const handView = new HandView(cardContainer, clearCardsButton);
  handView.bindEvents();

  const selectElement = document.querySelector('select#number-of-cards-select');
  const selectView = new SelectView(selectElement);
  selectView.bindEvents();

  const deck = new Deck();
  deck.bindEvents();

  const deckData = new DeckData();
  deckData.getData();
});
