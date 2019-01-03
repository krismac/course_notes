const PubSub = require('../helpers/pub_sub.js');

const PlanetsMenuView = function(menu) {
  this.menu = menu;
};

PlanetsMenuView.prototype.bindEvents = function() {
    // Frequently run your code and check what you've got:
    // console.log(evt.target)
    this.menu.addEventListener('click', (evt) => {
    // Or have some fun using mouseover instead
    // this.menu.addEventListener('mouseover', (evt) => {
    const selectedPlanetName = evt.target.id;
    PubSub.publish('PlanetsMenuView:selected', selectedPlanetName);
  });
};

module.exports = PlanetsMenuView;
