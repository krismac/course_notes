const PubSub = require('../helpers/pub_sub.js');

const ResultView = function () {

};

ResultView.prototype.bindEvents = function () {
  PubSub.subscribe('WordCounter:result-calculated', (event) => {
    const numberOfWords = event.detail;
    this.displayResult(numberOfWords);
  });
};

ResultView.prototype.displayResult = function (result) {
  const resultElement = document.querySelector('#result');
  resultElement.textContent = `You entered ${result} words.`;
};

module.exports = ResultView;
