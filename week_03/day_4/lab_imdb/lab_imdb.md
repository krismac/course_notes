# IMDB - Many to Many lab

Terrible news! IMDB, the world's most famous internet movie database, has _crashed!_ The Powers That Be have phoned CodeClan and specifically tasked YOU with rebuilding it from scratch!

But help is at hand, because they've given you a spec to work to:

**The new IMDB should have**

- Movies
  - title
  - genre

- Actors
  - first_name
  - last_name

- Roles
  - movie_id
  - actor_id
  - fee

The app should be able to
  - handle CRUD actions for all three models
  - display all the stars for a particular movie (`movie.actors()`)
  - display all the movies a particular star is cast in. (`actor.movies()`)

## Extension

Add a budget to your movie model (and DB table). Create a method on Movie that will return the remaining budget once all a movie's star's fees have been taken into consideration!
