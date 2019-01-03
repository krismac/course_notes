const PubSub = require('../helpers/pub_sub.js');

const NumberInputView = function () {

};

NumberInputView.prototype.bindEvents = function () {
  const form = document.querySelector('#prime-checker-form');
  form.addEventListener('submit', (evt) => {
    evt.preventDefault();
    // Log it out to be sure of what it is:
    // console.log(evt);
    // console.log(evt.target);
    // console.dir(evt.target.number);
    // console.log(evt.target.number.value);
    const inputtedNumber = evt.target.number.value;
    // I replaced PubSub.publish with the underlying code during HW review:
    const event = new CustomEvent(
      'NumberInputView:number-submitted',
      {
        detail: inputtedNumber
      }
    );
    document.dispatchEvent(event);
    // Normal way to do this with PubSub:
    PubSub.publish('NumberInputView:number-submitted', inputtedNumber);
  });
};

module.exports = NumberInputView;
