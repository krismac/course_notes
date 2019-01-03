const assert = require('assert');
const Decorator = require('../decorator.js');
const PaintCan = require('../paint_can.js');
const Room = require('../room.js');

describe('Decorator', function () {

  let paintCan1;
  let paintCan2;
  let paintCan3;
  let paintCan4;
  let paintCan5;
  let room;
  let decorator;

  beforeEach(function () {
    paintCan1 = new PaintCan(5);
    paintCan2 = new PaintCan(10);
    paintCan3 = new PaintCan(15);
    paintCan4 = new PaintCan(0);
    paintCan5 = new PaintCan(0);
    room = new Room(30);
    decorator = new Decorator();
  });

  it('should start with an empty paint stock', function () {
    const expected = [];
    assert.deepStrictEqual(decorator.paintStock, expected);
  });

  it('should be able to add a can of paint to paint stock', function () {
    decorator.addCanOfPaint(paintCan1);
    const expected = [paintCan1];
    assert.deepStrictEqual(decorator.paintStock, expected)
  });

  it('should be able to calculate total litres paint it has in stock', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan2);
    const expected = 15;
    assert.strictEqual(decorator.calculateAmountOfPaint(), expected);
  });

  it('should be able to calculate that it has enough paint to paint a room', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan2);
    decorator.addCanOfPaint(paintCan3);
    const expected = true;
    assert.deepStrictEqual(decorator.hasEnoughPaint(room), expected);
  });

  it('should be able to calcuate that it doesnt have enough paint to paint a room', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan2);
    const expected = false;
    assert.deepStrictEqual(decorator.hasEnoughPaint(room), expected);
  });

  it('should be able to paint room if has enough paint in stock', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan2);
    decorator.addCanOfPaint(paintCan3);
    decorator.paintRoom(room);
    const expected = true;
    assert.strictEqual(room.isPainted, expected);
  });

  it('should not paint room if it has not enough paint in stock', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan2);
    decorator.paintRoom(room);
    const expected = false;
    assert.strictEqual(room.isPainted, expected);
  });

  it('should be able to decrease amount of paint in stock for a given room', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan2);
    decorator.addCanOfPaint(paintCan3);
    decorator.decreasePaintStock(room);
    const expected = 0;
    assert.strictEqual(decorator.calculateAmountOfPaint(), expected);
  });

  it('should be able to decrease amount of paint in stock when painting a room', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan2);
    decorator.addCanOfPaint(paintCan3);
    decorator.paintRoom(room);
    const expected = 0;
    assert.strictEqual(decorator.calculateAmountOfPaint(), expected);
  });

  it('should be able to remove empty paint cans from stock', function () {
    decorator.addCanOfPaint(paintCan1);
    decorator.addCanOfPaint(paintCan4);
    decorator.addCanOfPaint(paintCan2);
    decorator.addCanOfPaint(paintCan5);
    decorator.removeEmptyPaintCans();
    const expected = [paintCan1, paintCan2];
    assert.deepStrictEqual(decorator.paintStock, expected);
  });

});
