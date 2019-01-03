require_relative( '../db/sql_runner' )

class Biting

  attr_reader( :zombie_id, :victim_id, :id )

  def initialize( options )
    @id = options['id'].to_i if options['id']
    @zombie_id = options['zombie_id'].to_i
    @victim_id = options['victim_id'].to_i
  end

  def save()
    sql = "INSERT INTO bitings
    (
      zombie_id,
      victim_id
    )
    VALUES
    (
      $1, $2
    )
    RETURNING id"
    values = [@zombie_id, @victim_id]
    results = SqlRunner.run(sql, values)
    @id = results.first()['id'].to_i
  end

  def self.all()
    sql = "SELECT * FROM bitings"
    results = SqlRunner.run( sql )
    return results.map { |biting| Biting.new( biting ) }
  end

  def victim()
    sql = "SELECT * FROM victims
    WHERE id = $1"
    values = [@victim_id]
    results = SqlRunner.run( sql, values )
    return Victim.new( results.first )
  end

  def zombie()
    sql = "SELECT * FROM zombies
    WHERE id = $1"
    values = [@zombie_id]
    results = SqlRunner.run( sql, values )
    return Zombie.new( results.first )
  end

  def self.delete_all()
    sql = "DELETE FROM bitings"
    SqlRunner.run( sql )
  end

  def self.destroy(id)
    sql = "DELETE FROM bitings
    WHERE id = $1"
    values = [id]
    SqlRunner.run( sql, values )
  end

end
