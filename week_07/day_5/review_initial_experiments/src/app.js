const RequestHelper = require('./helpers/request.js');
const ListView = require('./views/list_view.js');

document.addEventListener('DOMContentLoaded', () => {
  const container = document.querySelector('section#country-list');
  const listView = new ListView(container);

  const req = new RequestHelper('https://restcountries.eu/rest/v2/all');
  req.get()
    .then(data => {
      console.log(data);
      listView.render(data);
    });
});
