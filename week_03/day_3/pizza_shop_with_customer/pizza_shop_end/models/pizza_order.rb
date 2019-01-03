require_relative('../db/sql_runner.rb')

class PizzaOrder

  attr_accessor(:topping, :quantity)
  attr_reader(:id, :customer_id)

  def initialize(options)
    @id = options['id'].to_i()
    @customer_id = options['customer_id'].to_i()
    @topping = options['topping']
    @quantity = options['quantity'].to_i()
  end

  def customer()
    # We have @customer_id
    sql = '
      SELECT * FROM customers
      WHERE id = $1;
    '
    results = SqlRunner.run(sql, [@customer_id])
    customer_hash = results[0]
    customer = Customer.new(customer_hash)
    return customer
    # Return a Customer object
  end

  def self.delete_all()
    sql = 'DELETE FROM pizza_orders;'
    SqlRunner.run(sql)
  end

  def self.all()
    sql = 'SELECT * FROM pizza_orders;'
    order_hashes = SqlRunner.run(sql)

    order_objects = order_hashes.map do |order_hash|
      PizzaOrder.new(order_hash)
    end

    return order_objects
  end

  def save()
    sql = "
      INSERT INTO pizza_orders (
        customer_id,
        quantity,
        topping
      )
      VALUES ($1, $2, $3)
      RETURNING id;
    "
    values = [
      @customer_id,
      @quantity,
      @topping
    ]
    result = SqlRunner.run(sql, values)

    result_hash = result[0]
    string_id = result_hash['id']
    id = string_id.to_i()
    @id = id
    # OR
    # @id = result[0]['id'].to_i()

  end

  def update()
    sql = "
      UPDATE pizza_orders
      SET (
        customer_id,
        topping,
        quantity
      ) = ( $1, $2, $3 )
      WHERE id = $4;
    "
    values = [
      @customer_id,
      @topping,
      @quantity,
      @id
    ]
    SqlRunner.run(sql, values)
  end

end
