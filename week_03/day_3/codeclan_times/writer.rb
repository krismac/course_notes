require('pg')

class Writer

  def initialize(params)
    @id     = params["id"].to_i
    @f_name = params["f_name"]
    @l_name = params["l_name"]
    @staff  = params["staff"]
  end

  def save
    sql = "INSERT INTO writers (f_name, l_name, staff)
             VALUES ('#{@f_name}', '#{@l_name}', '#{@staff}') RETURNING id"

    db = PG.connect( {dbname: 'codeclan_times', host: 'localhost'} )
    @id = db.exec(sql)[0]["id"].to_i
    db.close
  end

  def Writer.all
     db = PG.connect( {dbname: 'codeclan_times', host: 'localhost'} )
     writers = db.exec("SELECT * FROM writers")

     return writers.map do |writer|
       Writer.new(writer)
     end

   end

   def staff?
     return @staff
   end

end
