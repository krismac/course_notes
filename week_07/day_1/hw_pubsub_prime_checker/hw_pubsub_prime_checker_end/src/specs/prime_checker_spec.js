const PrimeChecker = require('../models/prime_checker')
const assert = require('assert')

describe('PrimeChecker', () => {

  let primeChecker;

  beforeEach(() => {
    primeChecker = new PrimeChecker();
  })

  describe('Detects primes', () => {
    it('should detect 2 as prime', () => {
      assert.strictEqual(primeChecker.numberIsPrime(2), true)
    });

    it('should detect 3 as prime', () => {
      assert.strictEqual(primeChecker.numberIsPrime(3), true)
    });

    it('should detect 17 as prime', () => {
      assert.strictEqual(primeChecker.numberIsPrime(17), true)
    });
  });

  describe('Detects not primes', () => {
    it('should detect 0 as not prime', () => {
      assert.strictEqual(primeChecker.numberIsPrime(0), false)
    });

    it('should detect -1 as not prime', () => {
      assert.strictEqual(primeChecker.numberIsPrime(-1), false)
    });

    it('should detect 1 as not prime', () => {
      assert.strictEqual(primeChecker.numberIsPrime(1), false)
    });

    it('should detect 4 as not prime', () => {
      assert.strictEqual(primeChecker.numberIsPrime(4), false)
    });
  });


})