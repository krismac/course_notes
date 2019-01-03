require('minitest/autorun')
require('minitest/rg')
require_relative('../person.rb')

class PersonTest < MiniTest::Test

  def setup()
    @person = Person.new("Beth", 25)
  end

  def test_can_create_person()
    assert_equal(Person, @person.class())
  end

  def test_person_name()
    assert_equal("Beth", @person.name())
  end

  def test_person_age()
    assert_equal(25, @person.age())
  end

end