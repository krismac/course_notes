const PubSub = require('../helpers/pub_sub.js');
const MunroDetailView = require('./munro_detail_view');

const MunroListView = function (container) {
  this.container = container;
};

MunroListView.prototype.bindEvents = function () {
  PubSub.subscribe('Munros:munros-ready', (evt) => {
    this.clearList();
    this.renderMunroDetailViews(evt.detail);
  });
};

MunroListView.prototype.clearList = function () {
  this.container.innerHTML = '';
};

MunroListView.prototype.renderMunroDetailViews = function (munros) {
  munros.forEach((munro) => {
    const munroItem = this.createMunroListItem(munro);
    this.container.appendChild(munroItem);
  });
};

MunroListView.prototype.createMunroListItem = function (munro) {
  const munroDetailView = new MunroDetailView();
  const munroDetail = munroDetailView.createMunroDetail(munro);
  return munroDetail;
};

module.exports = MunroListView;
