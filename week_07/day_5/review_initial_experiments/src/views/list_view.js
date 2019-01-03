const ListView = function (container) {
  this.container = container;
}

ListView.prototype.render = function (countries) {
  countries.forEach(country => {
    const div = document.createElement('div');
    div.textContent = country.name;
    this.container.appendChild(div);
  });
}

module.exports = ListView;
