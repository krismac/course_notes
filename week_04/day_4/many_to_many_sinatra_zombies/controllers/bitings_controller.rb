require( 'sinatra' )
require( 'sinatra/contrib/all' )
require( 'pry-byebug' )
require_relative( '../models/biting.rb' )
require_relative( '../models/victim.rb' )
require_relative( '../models/zombie.rb' )
require_relative( '../models/action.rb' )
also_reload( '../models/*' )

get '/bitings' do
  @bitings = Biting.all
  @actions = Action.all
  erb ( :"bitings/index" )
end

get '/bitings/new' do
  @victims = Victim.all
  @zombies = Zombie.all
  erb(:"bitings/new")
end

post '/bitings' do
  biting = Biting.new(params)
  biting.save
  redirect to("/bitings")
end

post '/bitings/:id/delete' do
  Biting.destroy(params[:id])
  redirect to("/bitings")
end