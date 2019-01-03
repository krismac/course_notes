const PubSub = require('../helpers/pub_sub.js');

const AnimalInfoView = function(container){
  this.container = container;
};

AnimalInfoView.prototype.bindEvents = function(){
  PubSub.subscribe('Animals:selected-animal-ready', (evt) => {
    const animal = evt.detail;
    this.render(animal);
  });
};

AnimalInfoView.prototype.render = function(animal){
  const infoParagraph = document.createElement('p');
  infoParagraph.textContent = `The ${animal.species}, of class '${animal.class}', has a maximum speed of ${animal.maxSpeed} km/h.`;
  this.container.innerHTML = '';
  this.container.appendChild(infoParagraph);
};

module.exports = AnimalInfoView;
