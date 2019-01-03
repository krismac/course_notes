require_relative("../db/sql_runner")

class Star

  attr_reader :id
  attr_accessor :first_name, :last_name

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @first_name = options['first_name']
    @last_name = options['last_name']
  end

  def save()
    sql = "INSERT INTO stars (first_name, last_name) VALUES ($1, $2) RETURNING id"
    values = [@first_name, @last_name]
    star = SqlRunner.run(sql, values).first
    @id = star['id'].to_i
  end

  def update()
    sql = "UPDATE stars SET (first_name, last_name) = ($1, $2) WHERE id = $3"
    values = [@first_name, @last_name, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE * from stars where id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  # display all the movies a particular star is cast in

  def movies()
    sql = "SELECT movies.* FROM movies INNER JOIN castings ON movies.id = castings.movie_id WHERE star_id = $1"
    values = [@id]
    movie_data = SqlRunner.run(sql, values)
    return Movie.map_items(movie_data)
  end

  def self.all()
    sql = "SELECT * FROM stars"
    star_data = SqlRunner.run(sql)
    return Star.map_items(star_data)
  end

  def self.delete_all()
    sql = "DELETE FROM stars"
    SqlRunner.run(sql)
  end

  def self.map_items(data)
    result = data.map{|star| Star.new(star)}
    return result
  end

end
