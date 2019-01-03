const PubSub = require('../helpers/pub_sub.js');

const SightingView = function (container) {
  this.container = container;
};

SightingView.prototype.render = function (sighting) {
  const sightingContainer = document.createElement('div');
  sightingContainer.id = 'sighting';

  const species = this.createHeading(sighting.species);
  sightingContainer.appendChild(species);

  const location = this.createDetail('Location', sighting.location);
  sightingContainer.appendChild(location);

  const date = this.createDetail('Date', sighting.date);
  sightingContainer.appendChild(date);

  const deleteButton = this.createDeleteButton(sighting._id);
  sightingContainer.appendChild(deleteButton);

  this.container.appendChild(sightingContainer);
};

SightingView.prototype.createHeading = function (textContent) {
  const heading = document.createElement('h3');
  heading.textContent = textContent;
  return heading;
};

SightingView.prototype.createDetail = function (label, text) {
  const detail = document.createElement('p');
  detail.textContent = `${label}: ${text}`;
  return detail;
};

SightingView.prototype.createDeleteButton = function (sightingId) {
  const button = document.createElement('button');
  button.classList.add('delete-btn');
  button.value = sightingId;

  button.addEventListener('click', (evt) => {
    PubSub.publish('SightingView:sighting-delete-clicked', evt.target.value);
  });

  return button;
};

module.exports = SightingView;
