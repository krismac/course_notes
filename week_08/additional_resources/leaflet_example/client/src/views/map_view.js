const leaflet = require('leaflet');
const PubSub = require('../helpers/pub_sub')

const MapView = function (mapDiv, coords, zoomLevel) {
  this.mapDiv = mapDiv;  
  this.coords = coords;
  this.zoomLevel = zoomLevel;
  this.leafletMap = null;
}

MapView.prototype.init = function () {
  // more tile providers here - http://leaflet-extras.github.io/leaflet-providers/preview/index.html
  const CARTOUrl = 'https://cartodb-basemaps-{s}.global.ssl.fastly.net/rastertiles/voyager/{z}/{x}/{y}{r}.png';
  const CARTOTileLayer = new leaflet.TileLayer(CARTOUrl, {
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a> &copy; <a href="http://carto.com/attributions">CARTO</a>'
  });

  this.leafletMap = leaflet.map(this.mapDiv)
    .addLayer(CARTOTileLayer)
    .setView(this.coords, this.zoomLevel)
}

MapView.prototype.bindEvents = function () {
  PubSub.subscribe('CountryData:selected-country', (evt) => {
    const lat = evt.detail.latlng[0] || 0;
    const lng = evt.detail.latlng[1] || 0;
    const coords = [lat, lng];
    const bounds = this.guessBoundsFromAreaAndCoords(evt.detail.area, coords);
    this.fitBounds(bounds);
    this.addMarker(coords);
  })
}

MapView.prototype.guessBoundsFromAreaAndCoords = function (area, coords) {
  const countryWidthGuess = Math.sqrt(area);
  const degInKm = 111;
  const topLeftLat = coords[0] - (countryWidthGuess / degInKm / 2);
  const topLeftLng = coords[1] - (countryWidthGuess / degInKm / 2);
  const bottomRightLat = topLeftLat + (countryWidthGuess / degInKm);
  const bottomRightLng = topLeftLng + (countryWidthGuess / degInKm);
  return [[topLeftLat, topLeftLng], [bottomRightLat, bottomRightLng]];
}

MapView.prototype.fitBounds = function (corners) {
  this.leafletMap.fitBounds(corners);
}

MapView.prototype.addMarker = function (coords) {
  leaflet.marker(coords).addTo(this.leafletMap);
}

module.exports = MapView;