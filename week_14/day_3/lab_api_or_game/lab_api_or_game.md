# React Lab - Make a game _or_ display API data

Practice what we've learned in the past few days by making a small React app.

Containers will handle data requests, state changes and callbacks.

Components will handle visualisation logic (and only have access to props). These could even be a kind of thing that has no state, is basically just a function, and definitely a component... are you thinking what I'm thinking??

Plan out your Component hierarchy and your intended state & props first.

# Option 1 - API

Practise what we've learned in the past few days by making a small React app. This could be similar to the countries app we made that has a dropdown menu which when selected displays some information about that option. You could also select from a list of api's below or be creative and make something of your choice.

Also remember to have a container and component folder. Containers will handle data requests, state changes and callbacks. Components will handle visualation logic (and only have access to props).

Sample APIs:

## Pokemon API

http://pokeapi.co/

E.g. make a dropdown of the original Pokemon which you can select to see their details. This API uses URLS to link to more information rather than having one huge JSON response, so you will need to do a second AJAX request when an option is selected.

To get more than 20 Pokemon returned at once you can add a limit, e.g. http://pokeapi.co/api/v2/pokemon/?limit=151

## Harry Potter API

http://hp-api.herokuapp.com/

E.g. List all of the characters and click to see more info. You could extend this by filtering by Hogwarts House.

## Football Data

http://api.football-data.org/documentation

E.g. make a drop down box of all of the teams playing in the Premier League, and when selected show a list of the players for that team with their position and shirt number - this will need a second AJAX request on click. OR Make an app to look at the different football league tables.

You need to sign up for a free API key (http://api.football-data.org/register) which should be emailed to you right away, and then include this in any requests to the API. This will look something like this:

_fetch_

```js
var url = 'http://api.football-data.org/v1/soccerseasons';
const options = {
  headers: {
    "X-Auth-Token": "TOKEN GOES HERE"
  }
}
fetch(url, options)
```

_XHR_
```js
const url = 'http://api.football-data.org/v1/soccerseasons';
const request = new XMLHttpRequest();
request.open("GET", url);
request.setRequestHeader("X-Auth-Token", "TOKEN GOES HERE");
request.addEventListener('load', () => {
});
request.send();
```

# Option 2 - TicTacToe / Naughts & Crosses

Build this classic game from your childhood, using React and ES6.

- TicTacToe (aka Noughts and Crosses)

For those who haven't played or heard of it:

https://en.wikipedia.org/wiki/Tic-tac-toe

- We're thinking pass-and-play here, no need to bring in networking.

- Or, choose another game if TicTacToe sounds too simple (it isn't, make TicTacToe! It is **not** trivial)

**A word of caution** - it can be tempting to write and test all your logic before thinking about React. While this is a good instinct; it can really trip you up. This is because in React we have to be very careful about how we mutate (change) state. Game logic is always tricky, so we recommend starting with rendering a fixed "dummy" game state, focussing on designing your Component hierarchy and writing your React components, before thinking about game logic. Then you'll have a better idea of what kind of business logic functions will be able to slot in to your React code.

- Bonus tip - how a game looks and how we represent it's state in the simplest way may not be exactly the same. We can control the layout with CSS...

- If you get **really** stuck there's an official React tutorial to build TicTacToe here - https://reactjs.org/tutorial/tutorial.html
