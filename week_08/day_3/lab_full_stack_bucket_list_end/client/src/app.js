const FormView = require('./views/form.js');
const ListView = require('./views/list.js');
const BucketList = require('./models/bucket_list.js');

document.addEventListener('DOMContentLoaded', () => {
  const list = document.querySelector('ul#bucket-list');
  const listView = new ListView(list);
  listView.setupEventListeners();

  const form = document.querySelector('form#new-must-do-form');
  const formView = new FormView(form);
  formView.setupEventListeners();

  const bucketListData = new BucketList();
  bucketListData.setupEventListeners();
  bucketListData.all();
});
