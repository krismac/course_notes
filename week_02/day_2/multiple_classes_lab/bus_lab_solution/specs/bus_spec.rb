require('minitest/autorun')
require('minitest/rg')
require_relative('../bus.rb')
require_relative('../person.rb')
require_relative('../bus_stop.rb')

class BusTest < MiniTest::Test

  def setup()
    @bus = Bus.new(22, "Ocean Terminal")
    @passenger1 = Person.new("John", 30)
    @passenger2 = Person.new("Mary", 63)
    @passenger3 = Person.new("Bob", 40)
  end

  def test_can_create_bus()
    assert_equal(Bus, @bus.class())
  end

  def test_bus_route_number()
    assert_equal(22, @bus.route_number())
  end

  def test_bus_destination()
    assert_equal("Ocean Terminal", @bus.destination())
  end

  def test_bus_can_drive()
    assert_equal("Brum brum", @bus.drive())
  end

  def test_bus_starts_with_no_passengers()
    assert_equal(0, @bus.passenger_count())
  end

  def test_add_passenger()
    @bus.pick_up(@passenger1)
    assert_equal(1, @bus.passenger_count())
  end

  def test_add_two_passengers()
    @bus.pick_up(@passenger1)
    @bus.pick_up(@passenger2)
    assert_equal(2, @bus.passenger_count())
  end 

  def test_drop_off_passenger()
    @bus.pick_up(@passenger1)
    @bus.pick_up(@passenger2)
    @bus.drop_off(@passenger1)
    assert_equal(1, @bus.passenger_count())
  end

  def test_empty_bus()
    @bus.pick_up(@passenger1)
    @bus.pick_up(@passenger2)
    @bus.empty()
    assert_equal(0, @bus.passenger_count())
  end

  def test_pick_up_from_stop()
    @stop1 = BusStop.new("Elm Row")
    @stop1.add_to_queue(@passenger1)
    @bus.pick_up_from_stop(@stop1)
    assert_equal(1, @bus.passenger_count())
    assert_equal(0, @stop1.queue_length())
  end

  def test_pick_up_from_stop__multiple_people()
    @stop1 = BusStop.new("Elm Row")
    @stop1.add_to_queue(@passenger1)
    @stop1.add_to_queue(@passenger2)
    @bus.pick_up_from_stop(@stop1)
    assert_equal(2, @bus.passenger_count())
    assert_equal(0, @stop1.queue_length())
  end

  def test_pick_up_from_stop__bus_does_not_start_empty()
    @bus.pick_up(@passenger3)
    @stop1 = BusStop.new("Elm Row")
    @stop1.add_to_queue(@passenger1)
    @stop1.add_to_queue(@passenger2)
    @bus.pick_up_from_stop(@stop1)
    assert_equal(3, @bus.passenger_count())
  end

end