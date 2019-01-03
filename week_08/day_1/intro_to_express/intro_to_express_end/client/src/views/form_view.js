const PubSub = require('../helpers/pub_sub.js');

const FormView = function (element) {
  this.element = element;
}

FormView.prototype.bindListeners = function () {
  this.element.addEventListener('submit', function (evt) {
    evt.preventDefault();

    const artist = evt.target.artist.value;
    const title = evt.target.title.value;

    fetch(`https://api.lyrics.ovh/v1/${ artist }/${ title }`)
      .then(res => res.json())
      .then(data => PubSub.publish('FormView:request-complete', data.lyrics));

    evt.target.artist.value = '';
    evt.target.title.value = '';
  });
}

module.exports = FormView;
