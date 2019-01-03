const PubSub = require('../helpers/pub_sub.js');

const ListView = function (category, listElement) {
  this.category = category;
  this.listElement = listElement;
};

ListView.prototype.bindEvents = function () {
  PubSub.subscribe(`Consumables:${this.category}-data-loaded`, (evt) => {
    this.render(evt.detail);
  });
};

ListView.prototype.render = function (consumableData) {
  this.clearList();
  consumableData.forEach((item, index) => {
    const listItem = this.createListItem(item);
    this.listElement.appendChild(listItem);
  });
};

ListView.prototype.clearList = function () {
  this.listElement.innerHTML = '';
};

ListView.prototype.createListItem = function (item) {
  const listItem = document.createElement('li');
  const textContent = `${item.name}, ${item.brand}`;
  listItem.textContent = textContent;
  return listItem;
};

module.exports = ListView;
