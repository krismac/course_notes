const Decorator = function () {
  this.paintStock = [];
};

Decorator.prototype.addCanOfPaint = function (paintCan) {
  this.paintStock.push(paintCan);
};

Decorator.prototype.calculateAmountOfPaint = function () {
  let total = 0;

  for (const paintCan of this.paintStock) {
    total += paintCan.litresOfPaint;
  }

  return total;
};

Decorator.prototype.hasEnoughPaint = function (room) {
  return this.calculateAmountOfPaint() >= room.areaInSquareMeters;
};

Decorator.prototype.decreasePaintStock = function (room) {
  let areaToBePainted = room.areaInSquareMeters;

  for (const paintCan of this.paintStock) {
    if (paintCan.litresOfPaint >= areaToBePainted) {
      paintCan.decreasePaint(areaToBePainted);
      areaToBePainted = 0;
      return;
    } else {
      areaToBePainted -= paintCan.litresOfPaint;
      paintCan.empty();
    }
  }
};

Decorator.prototype.paintRoom = function (room) {
  if (!this.hasEnoughPaint(room)) {
    return;
  }

  room.paint();
  this.decreasePaintStock(room);
};

Decorator.prototype.removeEmptyPaintCans = function () {
  const cansWithPaint = [];

  for (const paintCan of this.paintStock) {
    if (!paintCan.isEmpty()) {
      cansWithPaint.push(paintCan);
    }
  }

  this.paintStock = cansWithPaint;
};

module.exports = Decorator;
