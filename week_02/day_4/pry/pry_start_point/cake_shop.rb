class CakeShop

  attr_reader :cakes

  def initialize(cakes)
    @cakes = cakes
  end

  def average_cake_rating()

    @cakes.map { |cake| cake.rating }
    ratings_sum = 0
    
    for rating in @cakes
      ratings_sum += rating
    end

    average = ratings_sum / ratings.length

    return average

  end

end


