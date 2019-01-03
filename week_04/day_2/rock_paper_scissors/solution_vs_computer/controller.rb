require("sinatra")
require( 'sinatra/contrib/all' ) if development?
require_relative("./models/rps_game.rb")
also_reload('./models/*')

get("/") do
  erb(:welcome)
end

get("/:move") do
  move = params[:move].to_sym()
  @game = RpsGame.new(move)

  if @game.all_moves().include?(move)
    erb(:result)
  else
    return "Please choose  one of these moves: #{@game.all_moves()}"
  end
end