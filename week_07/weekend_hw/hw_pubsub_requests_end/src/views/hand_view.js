const PubSub = require('../helpers/pub_sub.js');
const CardView = require('./card_view.js');

const HandView = function (container, clearCardsButton) {
  this.container = container;
  this.clearCardsButton = clearCardsButton;
};

HandView.prototype.bindEvents = function () {
  PubSub.subscribe('Deck:cards-to-deal-ready', (evt) => {
    const cards = evt.detail;
    this.renderCards(cards);
  });

  this.clearCardsButton.addEventListener('click', () => {
    this.container.innerHTML = '';
  });
};

HandView.prototype.renderCards = function (cards) {
  cards.forEach((card) => {
    this.createCardView(card);
  });
};

HandView.prototype.createCardView = function (card) {
  const cardView = new CardView(this.container, card);
  cardView.renderCard();
};

module.exports = HandView;
