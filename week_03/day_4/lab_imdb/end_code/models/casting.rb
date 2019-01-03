require_relative("../db/sql_runner")

class Casting

  attr_reader :id
  attr_accessor :movie_id, :star_id, :fee

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @movie_id = options['movie_id'].to_i
    @star_id = options['star_id'].to_i
    @fee = options['fee'].to_i
  end

  def save()
    sql = "INSERT INTO castings (movie_id, star_id, fee) VALUES ($1, $2, $3) RETURNING id"
    values = [@movie_id, @star_id, @fee]
    casting = SqlRunner.run(sql, values)[0];
    @id = casting['id'].to_i
  end

  def update()
    sql = "UPDATE stars SET (movie_id, star_id, fee) = ($1, $2, $3) WHERE id = $4"
    values = [@movie_id, @star_id, @fee, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE * FROM castings where id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def movie()
    sql = "SELECT * FROM movies WHERE id = $1"
    values = [@movie_id]
    movie = SqlRunner.run(sql, values).first
    return Movie.new(movie)
  end

  def star()
    sql = "SELECT * FROM stars WHERE id = $1"
    values = [@star_id]
    star = SqlRunner.run(sql, values).first
    return Star.new(star)
  end

  def self.all()
    sql = "SELECT * FROM castings"
    data = SqlRunner.run(sql)
    return data.map{|casting| Casting.new(casting)}
  end

  def self.delete_all()
    sql = "DELETE FROM castings"
    SqlRunner.run(sql)
  end

end
