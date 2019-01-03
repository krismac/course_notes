require( 'sinatra' )
require( 'sinatra/contrib/all' )
require( 'pry-byebug' )

require_relative( './models/pizza_order' )
also_reload( './models/*' )

get '/pizza-orders' do # index
  @orders = PizzaOrder.all()
  erb( :index )
end

get '/pizza-orders/new' do # new
  erb( :new )
end

get '/pizza-orders/:id' do # show
  @order = PizzaOrder.find( params[:id] )
  erb( :show )
end

post '/pizza-orders' do # create
  @order = PizzaOrder.new( params )
  @order.save()
  erb( :create )
end



get '/pizza-orders/:id/edit' do # edit
  @order = PizzaOrder.find( params[:id] )
  erb( :edit )
end

post '/pizza-orders/:id' do # update
  PizzaOrder.new( params ).update
  redirect to '/pizza-orders'
end

post '/pizza-orders/:id/delete' do # delete
  order = PizzaOrder.find( params[:id] )
  order.delete()
  redirect to '/pizza-orders'
end