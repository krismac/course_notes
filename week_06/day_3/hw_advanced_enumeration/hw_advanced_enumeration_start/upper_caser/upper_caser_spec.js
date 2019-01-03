const assert = require('assert');
const UpperCaser = require('./upper_caser.js');

describe('UpperCaser', function () {
  it('should be able to convert a single word to uppercase', function () {
    const upperCaser = new UpperCaser(['shouting']);
    assert.deepStrictEqual(upperCaser.toUpperCase(), ['SHOUTING']);
  });

  it('should be able to convert multiple words to uppercase', function () {
    const upperCaser = new UpperCaser(['i', 'am', 'shouting']);
    assert.deepStrictEqual(upperCaser.toUpperCase(), ['I', 'AM', 'SHOUTING']);
  });
});
