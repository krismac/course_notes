require('PG')

class Bounty

  attr_reader(:id)
  attr_accessor(:name, :bounty_value, :danger_level, :last_known_location)

  def initialize(options)
    @id = options['id'].to_i if options['id']
    @name = options['name']
    @bounty_value = options['bounty_value'].to_i
    @danger_level = options['danger_level']
    @last_known_location = options['last_known_location']
  end

  def save() # CREATE
    db = PG.connect({dbname: 'bounty_hunter', host: 'localhost'})
    sql = "INSERT INTO bounties
    (
      name,
      bounty_value,
      danger_level,
      last_known_location
    )
    VALUES
    (
      $1,$2,$3,$4
    )
    RETURNING id"
    values = [@name, @bounty_value, @danger_level, @last_known_location]
    db.prepare("save", sql)
    @id = db.exec_prepared("save", values)[0]["id"]
    db.close()
  end

  def update() # UPDATE
    db = PG.connect({dbname: 'bounty_hunter', host: 'localhost'})
    sql = "
    UPDATE bounties SET (
      name,
      bounty_value,
      danger_level,
      last_known_location
    ) =
    (
      $1, $2, $3, $4
    )
    WHERE id = $5"
    values = [@name, @bounty_value, @danger_level, @last_known_location, @id]
    db.prepare("update", sql)
    db.exec_prepared("update", values)
    db.close()
  end

  def delete() # DELETE
    db = PG.connect({dbname: 'bounty_hunter', host: 'localhost'})
    sql = "DELETE FROM bounties
      WHERE id = $1"
    values = [@id]
    db.prepare("delete", sql)
    db.exec_prepared("delete", values)
    db.close()
  end

  def Bounty.all() # READ
    db = PG.connect({dbname: 'bounty_hunter', host: 'localhost'})
    sql = "SELECT * FROM bounties"
    db.prepare("all", sql)
    results = db.exec_prepared("all")
    db.close()
    bounties = results.map {|bounty_hash| Bounty.new(bounty_hash)}
    return bounties
  end

  def Bounty.find(id) # READ
    db = PG.connect({dbname: 'bounty_hunter', host: 'localhost'})
    sql = "SELECT * FROM bounties
      WHERE id = $1"
    values = [id]
    db.prepare("find", sql)
    results_array = db.exec_prepared("find", values)
    db.close()
    bounty_hash = results_array[0]
    bounty = Bounty.new(bounty_hash)
    return bounty
  end

  def Bounty.find_by_name(name)
    db = PG.connect({
      dbname: 'bounty_hunter',
      host: 'localhost'
      })
    sql = "SELECT * from bounties WHERE name = $1"
    values = [name]
    db.prepare("find_by_name", sql)
    results_array = db.exec_prepared("find_by_name", values)
    db.close()
    bounty_hash = results_array[0]
    bounty = Bounty.new(bounty_hash)
    return bounty
  end

  def Bounty.delete_all() # DELETE
    db = PG.connect({dbname: 'bounty_hunter', host: 'localhost'})
    sql = "DELETE FROM bounties"
    db.prepare("delete_all", sql)
    db.exec_prepared("delete_all")
    db.close()
  end

end
