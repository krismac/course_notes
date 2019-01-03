const PubSub = require('../helpers/pub_sub.js');

const FormView = function(formElement) {
  this.element = formElement;
};

FormView.prototype.setupEventListeners = function() {
  this.element.addEventListener('submit', function(evt) {
    evt.preventDefault();
    const form = evt.target;

    const newItem = { title: form['title-field'].value };
    PubSub.publish('FormView:add-item', newItem);

    form.reset();
  });
};

module.exports = FormView;
