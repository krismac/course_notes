#include "catch.hpp"

#include <algorithm>
#include <bitset>
#include <functional>
#include <numeric>
#include <vector>

// The solutions and tests work from a std::vector of integer values, and the
// solution function takes a reference to this type.
//
using integers = std::vector<int>;
using solution = std::function<int(integers &)>;

int const max_value = 1000000;
int const min_value = -1000000;

// This implementation is simple, but not fully efficient. If there's a gap in
// values, the algorithm doesn't detect it, so it iterates all the input data
// even when it could return earlier of a gap is detected.
//
int sort_then_iterate_all(integers &data) {

  std::sort(begin(data), end(data));
  int smallest_positive = 1;

  for (int value : data) {

    if (value == smallest_positive)
      ++smallest_positive;
  }

  return smallest_positive;
}

// A slightly more efficient approach (although the same time complexity as the
// previous implementation, this affects coefficients only)
//
int sort_then_seek_gap(integers &data) {

  std::sort(begin(data), end(data));
  int previous_value = 0;

  for (int current_value : data) {
    if (current_value < 1)
      continue;

    if (current_value - previous_value > 1)
      break;

    previous_value = current_value;
  }

  return previous_value + 1;
}

// An alternative approach is to populate a new container with only relevant
// positive integer values, discarding zeros and negatives. Using a set
// container also allows the dataset to be reduced to only a single occurrence
// of each value.
//
// A second pass can then identify a gap in the values in the set, or return the
// largest positive value encountered + 1 if the positive integers in the
// container are contiguous.
//
// This can be done with a std::set, but std::bitset reduced the space
// complexity for using a single bit to represent the presence of of a given
// positive integer value in the input data.
//
// This does have the downside, though, of requiring a mapping between the
// zero-based bitset and the one-based integer values (effectively, because
// we're not interested in negative or zero values),
//
int track_positives_with_bitset(integers &data) {

  std::bitset<max_value> positives;

  for (auto value : data) {
    if (value < 1)
      continue;

    positives.set(value - 1); // Map value to 0-based bitset
  }

  for (std::size_t i = 0; i < max_value; i++) {
    if (!positives.test(i))
      return i + 1; // From 0-based bitset back to 1-based int value
  }

  return max_value + 1;
}

// Test case has simple happy-path scenarios, as well as a range of edge case
// scenarios of the type that an online test platform will use to find
// weaknesses in your implementation.
//
TEST_CASE("Find smallest integer not occurring in input") {

  constexpr int const value_range = max_value - min_value + 1;

  integers extreme_single_positive = {max_value};             // -> 1
  integers extreme_single_negative = {min_value};             // -> 1
  integers extreme_range = {max_value, min_value};            // -> 1
  integers many_extremes = {max_value, max_value, max_value}; // -> 1
  integers empty_data;                                        // -> 1
  integers single_element_zero = {0};                         // -> 1
  integers single_element_one = {1};                          // -> 2
  integers single_element_negative = {-1};                    // -> 1
  integers all_zeros = {0, 0, 0, 0, 0, 0, 0, 0};              // -> 1
  integers all_negatives = {-9, -8, -7, -6, -5, -4, -3, -2};  // -> 1
  integers all_ones = {1, 1, 1, 1, 1, 1, 1, 1};               // -> 2
  integers mixed_signs = {-3, -5, -2, 0, 1, 2, 3, 4};         // -> 5
  integers repeat_values = {1, 2, 3, 3, 3, 3, 4, 5};          // -> 6
  integers with_gap = {1, 2, 3, 4, 6, 7, 8, 9};               // -> 5
  integers no_gap = {1, 2, 3, 4, 5, 6, 7, 8};                 // -> 9
  integers immediate_gap = {99};                              // -> 1
  integers all_values_in_range(value_range);                  // -> max + 1

  std::iota(begin(all_values_in_range), end(all_values_in_range), min_value);

  SECTION("By sorting then iterating entire dataset") {
    REQUIRE(1 == sort_then_iterate_all(extreme_single_positive));
    REQUIRE(1 == sort_then_iterate_all(extreme_single_negative));
    REQUIRE(1 == sort_then_iterate_all(extreme_range));
    REQUIRE(1 == sort_then_iterate_all(many_extremes));
    REQUIRE(1 == sort_then_iterate_all(empty_data));
    REQUIRE(1 == sort_then_iterate_all(single_element_zero));
    REQUIRE(2 == sort_then_iterate_all(single_element_one));
    REQUIRE(1 == sort_then_iterate_all(single_element_negative));
    REQUIRE(1 == sort_then_iterate_all(all_zeros));
    REQUIRE(1 == sort_then_iterate_all(all_negatives));
    REQUIRE(2 == sort_then_iterate_all(all_ones));
    REQUIRE(5 == sort_then_iterate_all(mixed_signs));
    REQUIRE(6 == sort_then_iterate_all(repeat_values));
    REQUIRE(5 == sort_then_iterate_all(with_gap));
    REQUIRE(9 == sort_then_iterate_all(no_gap));
    REQUIRE(1 == sort_then_iterate_all(immediate_gap));
    REQUIRE(max_value + 1 == sort_then_iterate_all(all_values_in_range));
  }

  SECTION("By sorting then looking for a gap") {
    REQUIRE(1 == sort_then_seek_gap(extreme_single_positive));
    REQUIRE(1 == sort_then_seek_gap(extreme_single_negative));
    REQUIRE(1 == sort_then_seek_gap(extreme_range));
    REQUIRE(1 == sort_then_seek_gap(many_extremes));
    REQUIRE(1 == sort_then_seek_gap(empty_data));
    REQUIRE(1 == sort_then_seek_gap(single_element_zero));
    REQUIRE(2 == sort_then_seek_gap(single_element_one));
    REQUIRE(1 == sort_then_seek_gap(single_element_negative));
    REQUIRE(1 == sort_then_seek_gap(all_zeros));
    REQUIRE(1 == sort_then_seek_gap(all_negatives));
    REQUIRE(2 == sort_then_seek_gap(all_ones));
    REQUIRE(5 == sort_then_seek_gap(mixed_signs));
    REQUIRE(6 == sort_then_seek_gap(repeat_values));
    REQUIRE(5 == sort_then_seek_gap(with_gap));
    REQUIRE(9 == sort_then_seek_gap(no_gap));
    REQUIRE(1 == sort_then_seek_gap(immediate_gap));
    REQUIRE(max_value + 1 == sort_then_seek_gap(all_values_in_range));
  }

  SECTION("By tracking positive values in a bitset") {
    REQUIRE(1 == track_positives_with_bitset(extreme_single_positive));
    REQUIRE(1 == track_positives_with_bitset(extreme_single_negative));
    REQUIRE(1 == track_positives_with_bitset(extreme_range));
    REQUIRE(1 == track_positives_with_bitset(many_extremes));
    REQUIRE(1 == track_positives_with_bitset(empty_data));
    REQUIRE(1 == track_positives_with_bitset(single_element_zero));
    REQUIRE(2 == track_positives_with_bitset(single_element_one));
    REQUIRE(1 == track_positives_with_bitset(single_element_negative));
    REQUIRE(1 == track_positives_with_bitset(all_zeros));
    REQUIRE(1 == track_positives_with_bitset(all_negatives));
    REQUIRE(2 == track_positives_with_bitset(all_ones));
    REQUIRE(5 == track_positives_with_bitset(mixed_signs));
    REQUIRE(6 == track_positives_with_bitset(repeat_values));
    REQUIRE(5 == track_positives_with_bitset(with_gap));
    REQUIRE(9 == track_positives_with_bitset(no_gap));
    REQUIRE(1 == track_positives_with_bitset(immediate_gap));
    REQUIRE(max_value + 1 == track_positives_with_bitset(all_values_in_range));
  }
}
