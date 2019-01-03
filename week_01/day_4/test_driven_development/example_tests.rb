require('minitest/autorun')
require('minitest/rg')

class ExampleTests < MiniTest::Test

end


def test_one_plus_one
  expected_result = 2
  actual_calculated_value = 1 + 1
  assert_equal(expected_result, actual_calculated_value)
end

def test_add_one_to_5_is_6
  expected = 6
  actual = add_one(5)
  assert_equal(expected, actual)
end
