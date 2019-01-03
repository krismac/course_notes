fruits = ['apple', 'banana', 'orange']

p fruits[2]

p fruits[3]

p fruits[-1]

last_index = fruits.length - 1
p fruits[last_index]

p fruits.first()
p fruits.last()

empty_array = []
empty_array = Array.new()

p empty_array

fruits[1] = 'pineapple'

# fruits[100] = 'grapes'
# p fruits

fruits.push('mango')
# Same as push:
# fruits << 'mango'

# pop removes last item and returns it to us
p fruits.pop()

# p fruits

p fruits.shift()

# p fruits

fruits.unshift('passion fruit')

# p fruits

silly_array = [5, 'craig', true, nil, [1]]

p silly_array
