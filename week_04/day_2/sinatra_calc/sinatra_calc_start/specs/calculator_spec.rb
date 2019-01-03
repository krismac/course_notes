require('minitest/autorun')
require('minitest/rg')
require_relative('../models/calculator')

class TestCalculator < Minitest::Test

  def test_add
    assert_equal( 6, Calculator.add(4,2))
  end

  def test_subtract
    assert_equal( 2, Calculator.subtract(4,2))
  end

  def test_multiply
    assert_equal( 8, Calculator.multiply(4,2))
  end

  def test_divide
    assert_equal( 2, Calculator.divide(4,2))
  end

end
