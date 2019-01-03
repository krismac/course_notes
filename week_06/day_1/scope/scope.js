var name = 'Jill';
var secretsFunction = function () {
  var pinCode = [0, 0, 0, 0];
  // console.log('pinCode inside secretsFunction:', pinCode);
  // console.log('name inside secretsFunction:', name);
}

secretsFunction();
// console.log('pinCode outside secretsFunction:', pinCode);
// console.log('name outside secretsFunction:', name);

var filterNamesByFirstLetter = function (names, letter) {
  var filteredNames = [];
  for (let name of names) {
    if (name[0] === letter) {
      filteredNames.push(name);
    }
  }

  // console.log('name after loop:', name);
  return filteredNames
}

var students = ['Alice', 'Bob', 'Alyssia', 'Artem', 'Babs'];
var filteredStudents = filterNamesByFirstLetter(students, 'A');
// console.log('filteredStudents', filteredStudents);

const calculateEnergy = function (mass) {
  const speedOfLight = 299792458;
  // speedOfLight++
  return mass * speedOfLight ** 2;
}

// calculateEnergy = () => 0
const energyOfMe = calculateEnergy(75);
// console.log('energyOfMe (if I had a mass of 75kg)', energyOfMe);

const song = {
  title: 'Raspberry Beret',
  artist: 'Prince'
};

console.log('song before mutation', song);
song.title = 'When Doves Cry';
console.log('song after mutation', song);

const songs = [
  song,
  'Happy Birthday',
  'Hey Jude'
];

console.log('songs array before mutation', songs);
songs[1] = 'Call Me Maybe';
songs.pop();
console.log('songs array after mutation', songs);
