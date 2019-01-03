require_relative( '../db/sql_runner' )

class Victim

  attr_reader( :name, :run_speed, :id )

  def initialize( options )
    @id = options['id'].to_i if options['id']
    @name = options['name']
    @run_speed = options['run_speed'].to_i
  end

  def save()
    sql = "INSERT INTO victims
    (
      name,
      run_speed
    )
    VALUES
    (
      $1, $2
    )
    RETURNING id"
    values = [@name, @run_speed]
    results = SqlRunner.run(sql, values)
    @id = results.first()['id'].to_i
  end

  def zombies()
    sql = "SELECT z.* FROM zombies z INNER JOIN bitings b ON b.zombie_id = z.id WHERE b.victim_id = $1;"
    values = [@id]
    results = SqlRunner.run(sql, values)
    return results.map { |zombie| Zombie.new(zombie) }
  end

  def self.all()
    sql = "SELECT * FROM victims"
    results = SqlRunner.run( sql )
    return results.map { |victim| Victim.new( victim ) }
  end

  def self.find( id )
    sql = "SELECT * FROM victims
    WHERE id = $1"
    values = [id]
    results = SqlRunner.run( sql, values )
    return Victim.new( results.first )
  end

  def self.delete_all
    sql = "DELETE FROM victims"
    SqlRunner.run( sql )
  end

end
