require('pry-byebug')
require_relative('../models/bounty.rb')

Bounty.delete_all()

bounty1 = Bounty.new({
  'name' => 'Rose Doolan',
  'bounty_value' => 1500,
  'danger_level' => 'High',
  'last_known_location' => 'Mercury'
})
bounty1.save()

bounty2 = Bounty.new({
  'name' => 'Suzy Lafayette',
  'bounty_value' => 250,
  'danger_level' => 'Low',
  'last_known_location' => 'Pluto'
})
bounty2.save()

bounty3 = Bounty.new({
  'name' => 'Calamity Janet',
  'bounty_value' => 800,
  'danger_level' => 'Moderate',
  'last_known_location' => 'Jupiter'
})
bounty3.save()

binding.pry
nil
