require_relative('../db/sql_runner')

class Screening

  attr_reader :id
  attr_accessor :film_id, :start_time, :empty_seats

  def initialize(options)
    @id = options['id'].to_i
    @film_id = options['film_id'].to_i
    @start_time = options['start_time']
    @empty_seats = options['empty_seats'].to_i
  end

  def save()
    sql = "INSERT INTO screenings
    (
      film_id, start_time, empty_seats
    )
    VALUES
    (
      $1, $2, $3
    )
    RETURNING *"
    values = [@film_id, @start_time, @empty_seats]
    screening = SqlRunner.run(sql, values).first
    @id = screening['id'].to_i
  end

  def film()
    sql = "SELECT * FROM films
    WHERE films.id = $1"
    values = [@film_id]
    film_data = SqlRunner.run(sql, values)
    film = Film.map_item(film_data)
    return film
  end

  def update()
    sql = "UPDATE screenings
    SET
    (
      film_id, start_time, empty_seats
    ) =
    (
      $1, $2, $3
    )
    WHERE id = $4"
    values = [@film_id, @start_time, @empty_seats, @id]
    SqlRunner.run(sql, values)
  end

  def sell_ticket()
    @empty_seats -= 1
    update()
  end

  def self.all()
    sql = "SELECT * FROM screenings"
    screening_data = SqlRunner.run(sql)
    return Screening.map_items(screening_data)
  end

  def self.delete_all()
    sql = "DELETE FROM screenings"
    SqlRunner.run(sql)
  end

  def self.find(id)
    sql = "SELECT * FROM screenings
    WHERE id = $1"
    values = [id]
    screening_data = SqlRunner.run(sql, values)
    return Screening.map_item(screening_data)
  end

  def self.most_popular()
    sql = "SELECT screening_id,
    COUNT(*) AS count
    FROM tickets
    GROUP BY screening_id
    ORDER BY count
    DESC LIMIT 1;"
    most_popular_id = SqlRunner.run(sql).first["screening_id"].to_i
    Screening.find(most_popular_id)
  end

  #Helper methods for mapping
  def self.map_items(screening_data)
    result = screening_data.map { |screening| Screening.new( screening ) }
    return result
  end

  def self.map_item(screening_data)
    result = Screening.map_items(screening_data)
    return result.first
  end

end
