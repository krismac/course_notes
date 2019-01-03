const assert = require('assert');
const Journey = require('../models/journey.js');
const Traveller = require('../models/traveller.js');

describe('Traveller', function() {

  let journey1;
  let journey2;
  let journey3;
  let journey4;
  let journey5;
  let journeys;
  let traveller;

  beforeEach(function() {
    journey1 = new Journey('linlithgow', 'stirling', 'train', 30);
    journey2 = new Journey('paris', 'frankfurt', 'train', 400);
    journey3 = new Journey('sydney', 'new york', 'aeroplane', 10000);
    journey4 = new Journey('london', 'rome', 'car', 1200);
    journey5 = new Journey('lancaster', 'isle of man', 'ferry', 80);
    journeys = [journey1, journey2, journey3, journey4, journey5];
    traveller = new Traveller(journeys);
  });

  it('should have a collection of journeys', function() {
    const actual = traveller.journeys;
    assert.deepStrictEqual(actual, journeys);
  });

  it('should be able to get the journeys start locations', function() {
    const expected = [
      journey1.startLocation,
      journey2.startLocation,
      journey3.startLocation,
      journey4.startLocation,
      journey5.startLocation
    ];
    assert.deepStrictEqual(traveller.getJourneyStartLocations(), expected);
  });

  it('should be able to get the journeys end locations', function() {
    const expected = [
      journey1.endLocation,
      journey2.endLocation,
      journey3.endLocation,
      journey4.endLocation,
      journey5.endLocation
    ];
    assert.deepStrictEqual(traveller.getJourneyEndLocations(), expected);
  });

  it('should be able to get journeys by transport', function() {
    const expected = [
      journey1,
      journey2
    ];
    assert.deepStrictEqual(traveller.getJourneysByTransport('train'), expected);
  });

  it('should be able to get journeys over a certain distance', function() {
    const expected = [
      journey3,
      journey4
    ];
    assert.deepStrictEqual(traveller.getJourneysByMinDistance(1000), expected)
  });

  it('should be able to calculate total distance travelled', function() {
    assert.deepStrictEqual(traveller.calculateTotalDistanceTravelled(), 11710);
  });

  it('should be able to get a unique list of the modes of transport', function() {
    const expected = [ 'train', 'aeroplane', 'car', 'ferry' ];
    assert.deepStrictEqual(traveller.getUniqueModesOfTransport(), expected);
  });

});
