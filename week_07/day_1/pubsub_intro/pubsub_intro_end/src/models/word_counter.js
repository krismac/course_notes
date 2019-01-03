const PubSub = require('../helpers/pub_sub.js');

const WordCounter = function() {

};

WordCounter.prototype.bindEvents = function () {
  PubSub.subscribe('FormView:text-submitted', (event) => {
    const inputtedText = event.detail;
    const result = this.countWords(inputtedText);
    PubSub.publish('WordCounter:result-calculated', result);
  });
};

WordCounter.prototype.countWords = function (text) {
  const words = text.split(' ');
  return words.length;
};

module.exports = WordCounter;
