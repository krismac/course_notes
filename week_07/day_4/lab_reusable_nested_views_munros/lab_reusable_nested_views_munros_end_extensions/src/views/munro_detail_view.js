const MunroDetailView = function () {

}

MunroDetailView.prototype.createMunroDetail = function (munro) {
  const munroDetail = document.createElement('div');
  munroDetail.classList.add('munro-detail');

  const name = document.createElement('h3');
  name.textContent = munro.name;
  munroDetail.appendChild(name);

  const detailsList = document.createElement('ul');
  const meaning = this.createDetailListItem('Meaning', munro.meaning);
  detailsList.appendChild(meaning);

  const height = this.createDetailListItem('Height', munro.height)
  detailsList.appendChild(height);

  munroDetail.appendChild(detailsList);
  return munroDetail;
};

MunroDetailView.prototype.createDetailListItem = function (label, property) {
  const element = document.createElement('li');
  element.textContent = `${label}: ${property}`;
  return element;
};

module.exports = MunroDetailView;
