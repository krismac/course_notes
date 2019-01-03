chanter = {
  name: 'The Chanter',
  snapchat: 'chanterbanterr',
  fine_ales: {
    stewart: [
      {name: 'Session IPA', abv: 3.9},
      {name: 'First World Problems', abv: 6.2 }
    ],
    brewdog: [
      {name: 'Punk IPA', abv: 9.9},
      {name: 'Nanny State', abv: 0.2 }
    ]
  }
}
footlights = {
  name: 'Footlights',
  fine_ales: {
    tennents: [
      {name: 'T', abv: 3.9},
      {name: 'Export', abv: 5 }
    ],
    brewdog: [
      {name: 'Punk IPA', abv: 5.5},
      {name: 'Nanny State', abv: 0.2 }
    ]
  }
}
foundry = {
  name: 'Foundry',
  fine_ales: {
    stewart: [
      {name: 'Session IPA', abv: 3.9},
      {name: 'First World Problems', abv: 6.2 }
    ],
    brewdog: [
      {name: 'Punk IPA', abv: 5.5},
      {name: 'Nanny State', abv: 0.2 }
    ]
  }
}
# Messy:
# p chanter[:fine_ales][:brewdog][0][:name]

# Take it step-by-step. This helps with understanding and readability
chanter_beers = chanter[:fine_ales]
# p chanter_beers
brewdog_beers = chanter_beers[:brewdog]
# p brewdog_beers
first_beer = brewdog_beers[0]
# p first_beer
name = first_beer[:name]
# p name

# Finding out Hash keys:
keys = first_beer.keys()
# This is an array of keys that we can access as normal
# p keys[0]
# Or loop through and do whatever we like
for key in keys
  value = first_beer[key]
  p "The key: ${key} gives us the value: ${value}"
end

pubs = [chanter, footlights, foundry]

# Solve it for the first element on its own first
pub = pubs[0]

name = pub[:name]
p name.upcase()

# Then wrap it in a loop

for current_pub in pubs
  pub_name = current_pub[:name]
  p pub_name.upcase()
end

# This stops us repeating ourselves and means our code works for 3 pubs, 10 pubs, or 100 pubs! Without needing to change the code again later
# pub_name = pubs[0][:name]
# p pub_name.upcase()
#
# pub_name = pubs[1][:name]
# p pub_name.upcase()
#
# pub_name = pubs[2][:name]
# p pub_name.upcase()
#
# pub_name = pubs[3][:name]
# p pub_name.upcase()

# Nested for loop
for current_pub in pubs
  p current_pub[:name]
  brewdog_beers = current_pub[:fine_ales][:brewdog]
  for beer in brewdog_beers
    p beer[:name]
  end
end
