require('minitest/autorun')
require('minitest/rg')
require_relative('../bus_stop.rb')
require_relative('../person.rb')

class BusStopTest < MiniTest::Test

  def setup()
    @stop = BusStop.new("Waverley Station")
    @passenger1 = Person.new("John", 30)
    @passenger2 = Person.new("Mary", 63)
  end

  def test_can_create_stop()
    assert_equal(BusStop, @stop.class())
  end

  def test_queue_starts_empty()
    assert_equal(0, @stop.queue_length())
  end

  def test_add_person_to_queue()
    @stop.add_to_queue(@passenger1)
    assert_equal(1, @stop.queue_length())
  end
  
  def test_add_multiple_people_to_queue()
    @stop.add_to_queue(@passenger1)
    @stop.add_to_queue(@passenger2)
    assert_equal(2, @stop.queue_length())
  end

  def test_clear_queue()
    @stop.add_to_queue(@passenger1)
    @stop.add_to_queue(@passenger2)
    @stop.clear_queue()
    assert_equal(0, @stop.queue_length())
  end

end