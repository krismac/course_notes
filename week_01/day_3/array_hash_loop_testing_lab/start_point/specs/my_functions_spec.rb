require( 'minitest/autorun' )
require( 'minitest/rg' )
require_relative( '../my_functions' )

class My_Functions < MiniTest::Test

  # Write a function that takes has two parameters, array1 and array2
  # It should return the sum of the array lengths

  def test_add_length_of_arrays
    # arrange
    citrus_fruits = [ "lemon", "orange" ]
    berries = [ "strawberry", "blackberry", "raspberry" ]
    # act
    result = add_array_lengths( citrus_fruits, berries )
    # assert
    assert_equal( 5, result )
  end

  ################################################################

  # # Write a function that has a parameter named numbers
  # # It should return the sum value of an array passed as the argument
  #
  # def test_sum_array
  #   # arrange
  #   numbers = [ 1, 2, 3, 4, 5 ]
  #   # act
  #   result = sum_array( numbers )
  #   # assert
  #   assert_equal( 15, result )
  # end

  ################################################################

  # # Write a function that has two parameters, array and item
  # # It should return true if the item exists in the array otherwise it should return false
  #
  # def test_find_item_true
  #   # arrange
  #   houses = [ "Hufflepuff", "Slytherin", "Gryffindor", "Ravenclaw" ]
  #   # act
  #   result = find_item( houses, "Ravenclaw" )
  #   # assert
  #   assert_equal( true, result )
  # end

  # def test_find_item_false
  #   # arrange
  #   houses = [ "Hufflepuff", "Slytherin", "Gryffindor", "Ravenclaw" ]
  #   # act
  #   result = find_item( houses, "Harkonnen" )
  #   # assert
  #   assert_equal( false, result )
  # end

  ################################################################

  # # Write a function that has one parameter hash
  # # It should return the first key from the hash
  #
  # def test_get_first_key
  #   # arrange
  #   wallets = {
  #     "Alice" => 12,
  #     "Bob"  => 10,
  #     "Charlie"  => 1356,
  #     "Dave" => 1
  #   }
  #   # act
  #   result = get_first_key( wallets )
  #   # assert
  #   assert_equal( 'Alice', result )
  # end

end
