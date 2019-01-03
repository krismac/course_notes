const PubSub = require('../helpers/pub_sub.js');
const ListItemView = require('./list_item.js');

const ListView = function(listElement) {
  this.element = listElement;
};

ListView.prototype.setupEventListeners = function() {
  this.element.addEventListener('submit', function(evt) {
    evt.preventDefault();
  });
  PubSub.subscribe('BucketList:list-ready', (evt) => {
    const items = evt.detail;
    this.renderList(items);
  });
};

ListView.prototype.renderList = function(items) {
  this.emptyList();
  items.forEach((item) => this.renderItem(item));
};

ListView.prototype.emptyList = function(items) {
  this.element.innerHTML = '';
};

ListView.prototype.renderItem = function(item) {
  const listItemView = new ListItemView(item);
  const li = listItemView.createLi();
  this.element.appendChild(li);
};

module.exports = ListView;
