require_relative('../db/sql_runner')

class Album

  attr_accessor :name, :artist_id
  attr_reader :id

  def initialize( options )
    @id = options['id'].to_i
    @name = options['name']
    @artist_id = options['artist_id']
  end

  def save()
    sql = "INSERT INTO albums
    (
    name,
    artist_id
    ) VALUES
    (
    $1, $2
    )
    RETURNING id"
    values = [@name, @artist_id]
    @id = SqlRunner.run( sql, values )[0]["id"].to_i()
  end

  def artist()
    sql = "SELECT * FROM artists
    WHERE id = $1"
    values = [@artist_id]
    artist = SqlRunner.run( sql,values )
    result = Artist.new( artist.first )
    return result
  end

  def update # EXTENSION
    sql = "UPDATE albums SET name = $1, artist_id = $2 WHERE id = $3"
    values = [@name, @artist_id, @id]
    SqlRunner.run(sql, values)
  end

  def delete() # EXTENSION
    sql = "DELETE FROM albums WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def self.all()
    sql = "SELECT * FROM albums"
    albums = SqlRunner.run( sql )
    result = albums.map { |album_hash| Album.new( album_hash ) }
    return result
  end

  def self.delete_all() # EXTENSION
    sql = "DELETE FROM albums"
    SqlRunner.run(sql)
  end

  def self.find(id) # EXTENSION
    sql = "SELECT * FROM albums WHERE id = $1"
    values = [id]
    result = SqlRunner.run(sql, values)
    album = self.new(result.first)
    return album
  end

end
