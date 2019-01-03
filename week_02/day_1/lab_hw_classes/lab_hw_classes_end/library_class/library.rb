class Library

  attr_reader :books

  def initialize(books)
    @books = books || []
  end

  def find_book(title)
    found_book = nil
    for book in @books
      if book[:title] == title
        found_book = book
      end
    end
    return found_book
  end

  def find_renting_info(title)
    info = "Book not found."
    book = find_book(title)
    info = book[:rental_details] if book != nil
    return info
  end

  def add_book(new_book_title)
    new_book = {
      title: new_book_title,
      rental_details: {
        student_name: "",
        date: ""
        }
      }
    @books.push(new_book)
  end

  def rent_book(book_title, student, due_date)
    book = find_book(book_title)
    book[:rental_details] = { student_name: student, date: due_date }
  end

end
