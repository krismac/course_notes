class Person

  # attr_reader(:name)
  # attr_writer(:name)
  # Replaced by:
  attr_accessor(:name)


  def initialize(name)
    @name = name
  end

  # def name()
  #   return @name
  # end
  # Replaced by:
  # attr_reader(:name)

  # def name=(new_name)
  #   @name = new_name
  # end
  # Replaced by:
  # attr_writer(:name)

end

tom = Person.new('Thomas')
p tom.name()

# attr_writer allows us to set class properties like we're used to setting Hash properties
# hash = {key: 'some value'}
# hash[:key] = 'new value'
# ie:
tom.name = 'Jackie'

p tom.name()
