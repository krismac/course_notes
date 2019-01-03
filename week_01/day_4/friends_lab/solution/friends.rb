def get_name(person)
  return person[:name]
end

def get_favourite_tv_show(person)
  return person[:favourites][:tv_show]
end

def likes_to_eat(person, food)
  for snack in person[:favourites][:snacks]
    if snack == food
      return true
    end
  end
  return false
end


def add_friend(person, new_friend)
  person[:friends].push(new_friend)
  # or
  # person[:friends] << new_friend
end

def remove_friend(person, old_friend)
  person[:friends].delete(old_friend)
end

def total_money(people)
  total_money = 0
  for person in people
    total_money += person[:monies]
  end
  return total_money
end

def lend_money(lender, lendee, amount)
  lender[:monies] -= amount
  lendee[:monies] += amount
end

def all_favourite_foods(people)
  favourite_foods = []
  for person in people
    for snack in person[:favourites][:snacks]
      favourite_foods.push(snack)
      # or
      # favourite_foods << snack
    end
  end
  return favourite_foods
end

def find_no_friends(people)
  no_mates = []
  for person in people
    if person[:friends].length == 0
      no_mates.push(person)
    end
  end
  return no_mates
end
