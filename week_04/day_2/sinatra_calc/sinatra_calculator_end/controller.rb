require("sinatra")
require("sinatra/contrib/all")
require("pry")

require_relative('./models/calculator.rb')
also_reload('./models/*')


get '/add/:num1/:num2' do
  num1 = params[:num1].to_i
  num2 = params[:num2].to_i
  @calculation = Calculator.add(num1, num2)
  erb(:result)
end

get '/subtract/:num1/:num2' do
  num1 = params[:num1].to_i
  num2 = params[:num2].to_i
  @calculation = Calculator.subtract(num1, num2)
  erb(:result)
end

get '/multiply/:num1/:num2' do
  @calculation = Calculator.multiply(params[:num1].to_i, params[:num2].to_i)
  erb(:result)
end

get '/divide/:num1/:num2' do
  @calculation = Calculator.divide(params[:num1].to_i, params[:num2].to_i)
  erb(:result)
end

get '/' do
  erb(:home)
end

get '/about_us' do
  erb(:about_us)
end
