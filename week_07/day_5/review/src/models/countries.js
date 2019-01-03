const RequestHelper = require('../helpers/request.js');
const PubSub = require('../helpers/pub_sub.js');

const Countries = function () {

}

Countries.prototype.getData = function () {
  const req = new RequestHelper('https://restcountries.eu/rest/v2/all');
  req.get()
    .then(data => {
      console.log(data);
      PubSub.publish('Countries:countries-loaded', data);
    });
}

module.exports = Countries;
