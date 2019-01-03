require_relative( '../db/sql_runner' )

class Zombie

  attr_reader( :name, :type, :id )

  def initialize( options )
    @id = options['id'].to_i if options['id']
    @name = options['name']
    @type = options['type']
  end

  def save()
    sql = "INSERT INTO zombies
    (
      name,
      type
    )
    VALUES
    (
      $1, $2
    )
    RETURNING id"
    values = [@name, @type]
    results = SqlRunner.run(sql, values)
    @id = results.first()['id'].to_i
  end

  def victims
    sql = "SELECT v.* FROM victims v INNER JOIN bitings b ON b.victim_id = v.id WHERE b.zombie_id = $1;"
    values = [@id]
    results = SqlRunner.run(sql, values)
    return results.map { |victim| Victim.new(victim) }
  end

  def self.all()
    sql = "SELECT * FROM zombies"
    results = SqlRunner.run( sql )
    return results.map { |hash| Zombie.new( hash ) }
  end

  def self.find( id )
    sql = "SELECT * FROM zombies
    WHERE id = $1"
    values = [id]
    results = SqlRunner.run( sql, values )
    return Zombie.new( results.first )
  end

  def self.delete_all
    sql = "DELETE FROM zombies"
    SqlRunner.run( sql )
  end

end
