require_relative('./writer')

writer_objects = Writer.all

craig = Writer.new( {
  "f_name" => "Craig",
  "l_name" => "Morton",
  "staff"  => "f"
} )

craig.save
p craig
