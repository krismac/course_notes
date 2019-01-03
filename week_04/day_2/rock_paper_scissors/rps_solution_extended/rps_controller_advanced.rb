require('sinatra')
require('sinatra/contrib/all') if development?
require_relative('./models/rps')
also_reload('./models/*')

get '/:hand1/:hand2' do
  player1 = { player_no: 1, hand: params[:hand1]}
  player2 = { player_no: 2, hand: params[:hand2]}
  @result = RPSGame.check_win(player1, player2)
  erb(:result)
end

get '/' do
  erb(:rules)
end