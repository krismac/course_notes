require('pg')

class SqlRunner

  def self.run(sql, values = [])
    db = PG.connect({
      dbname: 'pizza_shop',
      host: 'localhost'
    })
    db.prepare('query', sql)
    results = db.exec_prepared('query', values)

    db.close()
    return results
  end

end
