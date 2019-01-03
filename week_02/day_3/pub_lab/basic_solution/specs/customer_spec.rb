require("minitest/autorun")
require('minitest/rg')
require_relative("../customer")

class CustomerTest < MiniTest::Test

  def setup
    @customer = Customer.new("Frodo", 10.0)
  end

  def test_customer_has_name
    assert_equal("Frodo", @customer.name())
  end

  def test_customer_has_money
    assert_equal(10.0, @customer.wallet())
  end

end
