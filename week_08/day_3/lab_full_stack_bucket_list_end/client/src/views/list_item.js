const PubSub = require('../helpers/pub_sub.js');

const ListItemView = function(item) {
  this.item = item;
  this.element = null;
};

ListItemView.prototype.createLi = function() {
  const li = document.createElement('li');
  li.classList.add('bucket-list-item');
  if (this.item.completed) {
    li.classList.add('completed');
  }

  const deleteButton = this.createDeleteButton();
  li.appendChild(deleteButton);

  const checkbox = this.createCheckbox();
  li.appendChild(checkbox);

  const titleSpan = this.createTitleSpan(li);
  li.appendChild(titleSpan);

  this.element = li;
  return li;
};

ListItemView.prototype.createTitleSpan = function(li) {
  let titleSpan = document.createElement('span');
  titleSpan.textContent = this.item.title;
  titleSpan.classList.add('title');
  return titleSpan;
};

ListItemView.prototype.createCheckbox = function() {
  const checkbox = document.createElement('input');
  checkbox.type = 'checkbox';
  checkbox.checked = this.item.completed;

  checkbox.addEventListener('click', (evt) => {
    const isChecked = evt.target.checked;
    this.handleCheckboxClicked(isChecked);
  });

  return checkbox;
};

ListItemView.prototype.handleCheckboxClicked = function(checkboxState) {
  this.item.completed = checkboxState;
  PubSub.publish('ListItemView:update-item', this.item);
};

ListItemView.prototype.createDeleteButton = function() {
  const deleteButton = document.createElement('button');
  deleteButton.classList.add('delete');

  deleteButton.addEventListener('click', (evt) => {
    PubSub.publish('ListItemView:delete-item', this.item);
  });
  return deleteButton;
};

module.exports = ListItemView;
