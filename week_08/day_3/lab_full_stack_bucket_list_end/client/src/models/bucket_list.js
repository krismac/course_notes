const RequestHelper = require('../helpers/request_helper.js');
const PubSub = require('../helpers/pub_sub.js');

const BucketList = function() {
  this.items = [];
  this.request = new RequestHelper('/api/must-dos');
};

BucketList.prototype.setupEventListeners = function() {
  PubSub.subscribe('FormView:add-item', (evt) => {
    const itemToAdd = evt.detail;
    this.add(itemToAdd);
  });
  PubSub.subscribe('ListItemView:update-item', (evt) => {
    const itemToUpdate = evt.detail;
    this.update(itemToUpdate);
  });
  PubSub.subscribe('ListItemView:delete-item', (evt) => {
    const itemToDelete = evt.detail;
    this.delete(itemToDelete);
  });
};

BucketList.prototype.all = function() {
  this.request
    .get()
    .then((listItems) => {
      this.items = listItems;
      PubSub.publish('BucketList:list-ready', this.items);
    })
    .catch((err) => console.error(err));
};

BucketList.prototype.add = function(newItem) {
  this.request
    .post(newItem)
    .then((listItems) => {
      this.items = listItems;
      PubSub.publish('BucketList:list-ready', this.items);
    })
    .catch((err) => console.error(err));
};

BucketList.prototype.update = function(updatedItem) {
  const id = updatedItem._id;
  this.request
    .put(updatedItem, id)
    .then((listItems) => {
      this.items = listItems;
      PubSub.publish('BucketList:list-ready', this.items);
    })
    .catch((err) => console.error(err));
};

BucketList.prototype.delete = function(itemToDelete) {
  const id = itemToDelete._id;
  this.request
    .delete(id)
    .then((listItems) => {
      this.items = listItems;
      PubSub.publish('BucketList:list-ready', this.items);
    })
    .catch((err) => console.error(err));
};

module.exports = BucketList;
