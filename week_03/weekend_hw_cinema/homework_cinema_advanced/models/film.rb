require_relative('../db/sql_runner')

class Film

  attr_reader :id
  attr_accessor :title, :price, :empty_seats

  def initialize(options)
    @id = options['id'].to_i
    @title = options['title']
    @price = options['price'].to_f
  end

  def save()
    sql = "INSERT INTO films
    (
      title,
      price
    )
    VALUES
    (
      $1, $2
    )
    RETURNING *"
    values = [@title, @price]
    film = SqlRunner.run(sql, values).first
    @id = film['id'].to_i
  end

  def update()
    sql = "UPDATE films
    SET
    (
      title, price
    ) =
    (
      $1, $2
    )
    WHERE id = $3"
    values = [@title, @price, @id]
    SqlRunner.run(sql, values)
  end

  def customers()
    sql = "SELECT customers.*
    FROM customers
    INNER JOIN tickets
    ON customers.id = tickets.customer_id
    INNER JOIN screenings
    ON tickets.screening_id = screenings.id
    WHERE screenings.film_id = $1"
    values = [@id]
    customer_data = SqlRunner.run(sql, values)
    customers = Customer.map_items(customer_data)
    return customers
  end

  def screenings()
    sql = "SELECT * FROM screenings
    WHERE film_id = $1"
    values = [@id]
    screening_data = SqlRunner.run(sql, values)
    return Screening.map_items(screening_data)
  end

  def tickets()
    sql = "SELECT tickets.*
    FROM tickets
    INNER JOIN screenings
    ON tickets.screening_id = screenings.id
    WHERE screenings.film_id = $1"
    values = [@id]
    ticket_data = SqlRunner.run(sql, values)
    return Ticket.map_items(ticket_data)
  end

  def number_of_viewers()
    return customers.count
  end

  def most_popular_screening_time()
    sql = "SELECT tickets.screening_id,
    COUNT (*) AS count
    FROM tickets
    INNER JOIN screenings ON tickets.screening_id = screenings.id
    WHERE screenings.film_id = $1
    GROUP BY tickets.screening_id
    ORDER BY count
    DESC LIMIT 1"
    values = [@id]
    most_popular_screening_id = SqlRunner.run(sql, values)[0]["screening_id"].to_i
    most_popular_screening = Screening.find(most_popular_screening_id)
    return most_popular_screening.start_time
  end

  def self.all()
    sql = "SELECT * FROM films"
    film_data = SqlRunner.run(sql)
    return Film.map_items(film_data)
  end

  def self.delete_all()
    sql = "DELETE FROM films"
    values = []
    SqlRunner.run(sql, values)
  end

  def self.most_viewers()
    ordered = Film.all.sort { |film1,film2| film1.number_of_viewers <=> film2.number_of_viewers }
    return ordered.first
  end


  #Helper methods for mapping
  def self.map_items(film_data)
    result = film_data.map { |film| Film.new( film ) }
    return result
  end

  def self.map_item(film_data)
    result = Film.map_items(film_data)
    return result.first
  end

end
