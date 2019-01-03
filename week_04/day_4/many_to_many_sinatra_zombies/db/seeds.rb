require_relative( "../models/zombie.rb" )
require_relative( "../models/victim.rb" )
require_relative( "../models/biting.rb" )
require("pry-byebug")

Biting.delete_all()
Zombie.delete_all()
Victim.delete_all()

zombie1 = Zombie.new({
  "name" => "Romero",
  "type" => "Generic"
})

zombie1.save()

zombie2 = Zombie.new({
  "name" => "Raimi",
  "type" => "Deadite"
})

zombie2.save()

zombie3 = Zombie.new({
  "name" => "Boyle",
  "type" => "Runner"
})

zombie3.save()

zombie4 = Zombie.new({
  "name" => "Jackson",
  "type" => "Boomer"
})

zombie4.save()

victim1 = Victim.new({
  "name" => "Maggie",
  "run_speed" => 12
})

victim1.save()

victim2 = Victim.new({
  "name" => "Rick",
  "run_speed" => 11
})

victim2.save()

victim3 = Victim.new({
  "name" => "Michonne",
  "run_speed" => 15
})

victim3.save()

victim4 = Victim.new({
  "name" => "Glenn",
  "run_speed" => 30
})

victim4.save()

biting1 = Biting.new({
  "victim_id" => victim1.id,
  "zombie_id" => zombie1.id
})

biting1.save()

biting2 = Biting.new({
  "victim_id" => victim2.id,
  "zombie_id" => zombie2.id
})

biting2.save()

biting3 = Biting.new({
  "victim_id" => victim3.id,
  "zombie_id" => zombie4.id
})
biting3.save()

biting4 = Biting.new({
  "victim_id" => victim3.id,
  "zombie_id" => zombie1.id
})

biting4.save()

binding.pry
nil
