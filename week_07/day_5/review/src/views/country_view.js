const CountryView = function () {

}

CountryView.prototype.create = function (country) {
  const div = document.createElement('div');
  div.classList.add('country-info');

  const name = document.createElement('h2');
  name.textContent = country.name;
  div.appendChild(name);

  const capital = document.createElement('p');
  capital.textContent = country.capital;
  div.appendChild(capital);

  const populationDensity = document.createElement('p');
  populationDensity.textContent = Math.round(country.population / country.area);
  div.appendChild(populationDensity);

  return div;
}

module.exports = CountryView;
