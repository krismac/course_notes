require_relative("../db/sql_runner")

class Movie
  attr_reader :id
  attr_accessor :title, :genre, :budget

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @title = options['title']
    @genre = options['genre']
    @budget = options['budget']
  end

  def save()
    sql = "INSERT INTO movies (title, genre, budget) VALUES ($1, $2, $3) RETURNING id"
    values = [@title, @genre, @budget]
    movie = SqlRunner.run(sql, values).first
    @id = movie['id'].to_i
  end

  def update()
    sql = "UPDATE movies SET (title, genre, budget) = ($1, $2, $3) WHERE id = $4"
    values = [@title, @genre, @budget, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE * FROM movies where id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  # display all the stars for a particular movie

  def stars()
    sql = "SELECT stars.* FROM stars INNER JOIN castings ON stars.id = castings.star_id WHERE movie_id = $1"
    values = [@id]
    star_data = SqlRunner.run(sql, values)
    return Star.map_items(star_data)
  end

  # extension

  def castings()
    sql = "SELECT * FROM castings where movie_id = $1"
    values = [@id]
    casting_data = SqlRunner.run(sql, values)
    return casting_data.map{|casting| Casting.new(casting)}
  end

  def remaining_budget()
    castings = self.castings()
    casting_fees = castings.map{|casting| casting.fee}
    combined_fees = casting_fees.sum
    return @budget - combined_fees
  end

  def self.all()
    sql = "SELECT * FROM movies"
    movie_data = SqlRunner.run(sql)
    return Movie.map_items(movie_data)
  end

  def self.delete_all()
    sql = "DELETE FROM movies"
    SqlRunner.run(sql)
  end

  def self.map_items(data)
    result = data.map{|movie| Movie.new(movie)}
    return result
  end

end
