const PubSub = require('../helpers/pub_sub.js');

const Deck = function () {
  this.cards = null;
};

Deck.prototype.bindEvents = function () {
  PubSub.subscribe('SelectView:number-of-cards-selected', (evt) => {
    const numberOfCardsToDeal = evt.detail;
    this.dealCards(numberOfCardsToDeal);
  });

  PubSub.subscribe('DeckData:deck-data-ready', (evt) => {
    this.cards = evt.detail;
    PubSub.publish('Deck:deck-updated', this.cards.length);
  });
};

Deck.prototype.dealCards = function (numberOfCardsToDeal) {
  const cardsToDeal = this.cards.splice(0, numberOfCardsToDeal);
  PubSub.publish('Deck:cards-to-deal-ready', cardsToDeal);
  PubSub.publish('Deck:deck-updated', this.cards.length);
};

module.exports = Deck;
