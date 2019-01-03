const PubSub = require('../helpers/pub_sub.js');
const Request = require('../helpers/request_helper.js');

const FormView = function (formElement) {
  this.formElement = formElement;
};

FormView.prototype.bindEvents = function () {
  this.formElement.addEventListener('submit', (evt) => {
    evt.preventDefault();
    const data = this.createData(evt.target);
    const category = evt.target.category.value;
    PubSub.publish(`FormView:submit-${category}`, data);
    evt.target.reset();
  });
};

FormView.prototype.createData = function (form) {
  return {
    name: form.name.value,
    brand: form.brand.value
  };
};

module.exports = FormView;
