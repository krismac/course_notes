require('minitest/autorun')
require('minitest/rg')
require_relative('../library')

class LibraryTest < MiniTest::Test

  def setup()

    @books = [
      {
        title: "lord_of_the_rings",
        rental_details: {
          student_name: "Jeff",
          date: "01/12/2016"
        }
      },
      {
        title: "colour_of_magic",
        rental_details: {
          student_name: "",
          date: ""
        }
      }
    ]

    @library = Library.new(@books)

  end

  def test_list_books()
    book_list = @library.books()
    assert_equal(@books, book_list)
  end

  def test_find_book()
    found_book = @library.find_book("colour_of_magic")
    assert_equal("colour_of_magic", found_book[:title])
  end

  def test_find_book__book_not_in_library()
    found_book = @library.find_book("harry_potter")
    assert_nil(found_book)
  end

  def test_check_who_is_renting()
    assert_equal({:student_name => "Jeff", :date => "01/12/2016"}, @library.find_renting_info("lord_of_the_rings"))
  end

  def test_can_add_book()
    @library.add_book("1984")
    assert_equal({ title: "1984", rental_details: { student_name: "", date: ""} }, @library.find_book("1984"))
    all_books = @library.books()
    assert_equal(3, all_books.count())
  end

  def test_can_rent_out_book()
    @library.rent_book("colour_of_magic", "Paul", "05/12/2016")
    renting_info = @library.find_renting_info("colour_of_magic")
    assert_equal({
      :student_name => "Paul",
      :date => "05/12/2016"
      } , renting_info)
  end

end
