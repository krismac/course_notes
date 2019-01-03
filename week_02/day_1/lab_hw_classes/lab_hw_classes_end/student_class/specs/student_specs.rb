require('minitest/autorun')
require('minitest/rg')
require_relative('../student')

class StudentTest < MiniTest::Test

  def setup()

    @student = Student.new("Jeff", "E6")

  end

  def test_student_has_name()
    assert_equal("Jeff", @student.name())
  end

  def test_student_has_cohort()
    assert_equal("E6", @student.cohort())
  end

  def test_students_name_can_update()
    @student.name = "Paul"
    assert_equal("Paul", @student.name())
  end

  def test_student_can_change_cohort()
    @student.cohort = "G4"
    assert_equal("G4", @student.cohort())
  end

  def test_student_can_talk()
    assert_equal("I can talk", @student.talk())
  end

  def test_student_has_favourite_language()
    assert_equal("I love Ruby", @student.say_favourite_language("Ruby"))
  end

end
