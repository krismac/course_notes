const planetsData = require('./data/planets.js');
const SolarSystem = require('./models/solar_system.js');
const PlanetsMenuView = require('./views/planets_menu_view.js');
const PlanetInfoView = require('./views/planet_info_view.js');

document.addEventListener('DOMContentLoaded', () => {

  // If the modular, separate class structure is a blocker for you,
  // you can start out by hacking around in DOMContentLoaded to test things out,
  // Before moving them into their own separate classes
  // const menu = document.querySelector('nav.planets-menu');
  // menu.addEventListener('click', evt => {
  //   console.log(evt.target.id)
  //   const planetsDataModel = new SolarSystem(planetsData);
  //   planetsDataModel.planets.forEach(planet => {
  //     console.log(planet.name == evt.target.id)
  //   });
  // });

  const planetsDataModel = new SolarSystem(planetsData);
  planetsDataModel.bindEvents();

  const menu = document.querySelector('nav.planets-menu');
  const menuView = new PlanetsMenuView(menu);
  menuView.bindEvents();

  const detailsContainer = document.querySelector('section.planet-details');
  const planetDetailsView = new PlanetInfoView(detailsContainer);
  planetDetailsView.bindEvents();
});
