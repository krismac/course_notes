class Customer

  attr_accessor(:first_name, :last_name)
  attr_reader(:id)

  def initialize(options)
    @id = options['id'].to_i()
    @first_name = options['first_name']
    @last_name = options['last_name']
  end

  def orders()
    # We have @id
    sql = '
      SELECT * FROM pizza_orders
      WHERE customer_id = $1;
    '
    results = SqlRunner.run(sql, [@id])

    orders = results.map do | order_hash |
      PizzaOrder.new(order_hash)
    end
    return orders
    # Return array of PizzaOrder objects
  end

  def save()
    sql = '
      INSERT INTO customers (
        first_name,
        last_name
      ) VALUES ($1, $2)
      RETURNING id;
    '
    results = SqlRunner.run(sql, [@first_name, @last_name])
    @id = results[0]['id'].to_i()
  end

  def self.delete_all()
    sql = 'DELETE FROM customers;'
    SqlRunner.run(sql)
  end

  def update()
    sql = '
      UPDATE customers
      SET (first_name, last_name)
      = ($1, $2)
      WHERE id = $3;
    '
    SqlRunner.run(sql, [@first_name, @last_name, @id])
  end

  def self.all()
    sql = 'SELECT * FROM customers;'
    customer_hashes = SqlRunner.run(sql)
    customer_objects = customer_hashes.map do |customer_hash|
      Customer.new(customer_hash)
    end
    return customer_objects
  end

  def self.find(id)
    sql = '
      SELECT * FROM customers
      WHERE id = $1;
    '
    results = SqlRunner.run(sql, [id])
    customer_hash = results[0]
    customer_object = Customer.new(customer_hash)
    return customer_object
  end

  def delete()
    sql = '
      DELETE FROM customers
      WHERE id = $1;
    '
    SqlRunner.run(sql, [@id])
  end

end
