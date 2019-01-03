const Room = function (areaInSquareMeters) {
  this.areaInSquareMeters = areaInSquareMeters;
  this.isPainted = false;
};

Room.prototype.paint = function () {
  this.isPainted = true;
};

module.exports = Room;
