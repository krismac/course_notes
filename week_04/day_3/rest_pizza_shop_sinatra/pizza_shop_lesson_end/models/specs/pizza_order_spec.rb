require("minitest/autorun")
require_relative("../pizza_order")

class TestPizzaOrder < MiniTest::Test

  def setup
    options = {"id" => 1, "first_name" => "Walter", "last_name" => "White",
      "topping" => "Pepperoni", "quantity" => 5}

    @pizza_order = PizzaOrder.new(options)
  end

  def test_first_name()
    result = @pizza_order.first_name()
    assert_equal("Walter", result)
  end

  def test_last_name()
    result = @pizza_order.last_name()
    assert_equal("White", result)
  end

  def test_topping()
    result = @pizza_order.topping()
    assert_equal("Pepperoni", result)
  end

  def test_quantity()
    result = @pizza_order.quantity()
    assert_equal(5, result)
  end

  def test_pretty_name()
    result = @pizza_order.pretty_name()
    assert_equal("Walter White", result)
  end

  def test_total()
    result = @pizza_order.total()
    assert_equal(50, result)
  end

end
