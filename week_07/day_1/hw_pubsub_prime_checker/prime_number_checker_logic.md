# Prime Number Checker Logic

When writing your Prime Number Checker application, you will need to write a function calculates whether a number is prime or not.

A prime number is a number that is only divisible by 1 and itself. 1 is not a prime number and neither are negative numbers. So our function can:

1. Check whether the number is 1 or less, and if so, the number is not prime so we return false.
2. If the number is greater than 1, we will use a loop to check whether the number is divisible by any number between 2 and itself, using the modulus operator to check if there is a remainder of 0. If this is the case, we know the number is not prime and we return false and break out of the loop.
3. Finally, if neither of the above are the case, we know the number is prime and can return true.

```js
PrimeChecker.prototype.numberIsPrime = function (number) {
  if (number <= 1) {
    return false;
  }
  for (let i = 2; i < number; i++) {
    if (number % i === 0) {
        return false;
    }
  }
  return true;
};
```
