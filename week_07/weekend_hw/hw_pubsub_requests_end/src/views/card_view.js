const CardView = function (container, card) {
  this.container = container;
  this.card = card;
};

CardView.prototype.renderCard = function () {
  const cardImage = document.createElement('img');
  cardImage.src = this.card.image;
  this.container.appendChild(cardImage);
};

module.exports = CardView;

