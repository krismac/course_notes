const Request = require('../helpers/request.js');
const PubSub = require('../helpers/pub_sub.js');

const DeckData = function () {

};

DeckData.prototype.getData = function () {
  const request = new Request('https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1');
  request.get()
    .then((data) => {
      this.getCardData(data.deck_id);
    })
    .catch((err) => {
      console.error(err);
    });
  };
  
  DeckData.prototype.getCardData = function (deck_id) {
    const request = new Request(`https://deckofcardsapi.com/api/deck/${deck_id}/draw/?count=52`);
    request.get()
      .then((data) => {
        PubSub.publish('DeckData:deck-data-ready', data.cards);
      })
      .catch((err) => {
        console.error(err);
      });
};


module.exports = DeckData;
