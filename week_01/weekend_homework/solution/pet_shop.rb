def pet_shop_name(pet_shop)
  return pet_shop[:name]
end

def stock_count(pet_shop)
  return pet_shop[:pets].count
end

def pets_sold(pet_shop)
  return pet_shop[:admin][:pets_sold]
end

def increase_pets_sold(pet_shop, num_pets_sold)
  pet_shop[:admin][:pets_sold] += num_pets_sold
end

def total_cash(pet_shop)
  cash = pet_shop[:admin][:total_cash]
  return cash
end

def add_or_remove_cash(pet_shop, amount)
  pet_shop[:admin][:total_cash] += amount
end

def pets_by_breed(pet_shop, breed)
  matches = []
  for pet in pet_shop[:pets]
    matches << pet if(pet[:breed] == breed)
  end
  return matches
end

def find_pet_by_name(pet_shop, pet_name)
  match = nil
  for pet in pet_shop[:pets]
    match = pet if(pet[:name] == pet_name)
  end
  return match
end

def remove_pet_by_name(pet_shop, pet_name)
  pet_to_delete = find_pet_by_name(pet_shop, pet_name)
  pet_shop[:pets].delete(pet_to_delete)
end

def add_pet_to_stock(pet_shop, pet)
  pet_shop[:pets].push(pet)
end

def customer_cash(customer)
  return customer[:cash]
end

def remove_customer_cash(customer, amount)
  customer[:cash] -= value
end

def customer_pet_count(customer)
  return customer[:pets].count
end

def add_pet_to_customer(customer, pet)
  customer[:pets] << pet
end

def customer_can_afford_pet(customer, pet)
  return customer[:cash] >= pet[:price]
end

def sell_pet_to_customer(pet_shop, pet, customer)
  return if (pet == nil)
  return if !(customer_can_afford_pet(customer, pet))

  add_pet_to_customer(customer,pet)
  add_or_remove_cash(pet_shop, pet[:price])
  remove_customer_cash(pet_shop, pet[:price])
  remove_pet_by_name(pet_shop, pet[:name])
  increase_pets_sold(pet_shop, 1)
end
