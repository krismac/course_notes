const Joke = require('./models/joke.js');
const JokeView = require('./views/joke_view.js');

document.addEventListener('DOMContentLoaded', () => {
  const joke = new Joke();
  joke.getData();

  const jokeContainer = document.querySelector('div#joke-container');
  const jokeView = new JokeView(jokeContainer);
  jokeView.bindEvents();
});
