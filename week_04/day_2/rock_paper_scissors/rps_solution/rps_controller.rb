require('sinatra')
require('sinatra/contrib/all') if development?
require_relative('./models/rps')
also_reload('./models/*')

get '/:hand1/:hand2' do
  hand1 = params[:hand1]
  hand2 = params[:hand2]
  return RPSGame.check_win(hand1, hand2)
end