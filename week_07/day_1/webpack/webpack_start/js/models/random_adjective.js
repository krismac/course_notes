const RandomAdjective = function () {
  this.adjectives = [
    'bad',
    'beautiful',
    'boring',
    'disasterous',
    'dreary',
    'fabulous',
    'good',
    'magic',
    'top-notch',
    'wonderful',
  ];
};

RandomAdjective.prototype.get = function () {
  const randomIndex = Math.floor(Math.random() * this.adjectives.length);
  return this.adjectives[randomIndex];
};
