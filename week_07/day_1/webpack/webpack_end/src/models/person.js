const TextFormat = require('../helpers/text_format.js');

const Person = function (name, favouriteColour) {
  this.name = name;
  this.favouriteColour = favouriteColour;
};

Person.prototype.formatName = function () {
  const names = this.name.split(' ');
  const capitalisedNames = names.map((name) => TextFormat.capitalise(name));
  this.name = capitalisedNames.join(' ');
};

Person.prototype.formatColour = function () {
  this.favouriteColour = TextFormat.capitalise(this.favouriteColour);
};

module.exports = Person;
