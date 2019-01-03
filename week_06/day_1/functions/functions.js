function sayHello(greeting, name = 'World') {
  return `${greeting} ${name}!`;
}

// console.log('sayHello message:', sayHello('Hi', 'Danielle'));
// console.log('sayHello with no arguments:', sayHello());

// console.log('1 + 3 with add:', add(1, 3));
var add = function (firstNumber, secondNumber) {
  return firstNumber + secondNumber;
}

// Task 1
function calculateTotal(numbers) {
  var total = 0;
  for (var number of numbers) {
    total += number;
  }
  return total;
}

var sum = calculateTotal([10, 40, 200, 50]);
// console.log('sum of array of numbers:', sum);

// Task 2
var checkForKey = function (object, searchString) {
  for (var key in object) {
    if (searchString === key) {
      return true;
    }
  }
  return false;
}

var person = {
  name: 'Wojtek',
  age: 30
};

var keyIsFound = checkForKey(person, 'name');
var keyNotFound = checkForKey(person, 'email');

// console.log('keyIsFound - should be true:', keyIsFound);
// console.log('keyNotFound - should be false:', keyNotFound);

var multiply = (firstNumber, secondNumber) => firstNumber * secondNumber;
console.log('multiply 2 by 5:', multiply(2, 5));
