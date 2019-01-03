require('sinatra')
require('sinatra/contrib/all') if development?

get('/hello') do
  return 'Hello World!'
end

get('/goodbye/craig') do
  return 'See ya Craig!!!!!!!!'
end

# General case must come after specific case (above)
get('/goodbye/:name') do
  return 'See ya ' + params['name'] + '!'
end

get('/hello/:first_name/:last_name') do
  # return params.to_s()
  return "Hello #{params['first_name']} #{params['last_name']}"
end

get('/friends/:number') do
  friends_list = ['Joey', 'Monica', 'Chandler', 'Phoebe', 'Rachel', 'Ross']

  index = params['number'].to_i() - 1

  return friends_list[index]
end

# get '/weather/:area_id' do
#   weather = Weather.new(params)
#   data = weather.next_5_days()
#   # Pass data to View
# end
