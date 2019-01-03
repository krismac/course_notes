use games_hub;
db.dropDatabase();

db.games.insertMany([
  {
    name: "Love Letter",
    playingTime: 20,
    players: {
      min: 2,
      max: 4
    }
  },
  {
    name: "Catan",
    playingTime: 90,
    players: {
      min: 3,
      max: 4
    }
  },
  {
    name: "Exploding Kittens",
    playingTime: 15,
    players: {
      min: 2,
      max: 5
    }
  },
  {
    name: "Resistance",
    playingTime: 30,
    players: {
      min: 5,
      max: 10
    }
  }
]);
