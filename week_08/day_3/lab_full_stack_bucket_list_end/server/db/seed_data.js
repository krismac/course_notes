use bucketList;
db.dropDatabase();

db.mustDos.insertMany([
  {
    title: 'Learn to play the banjo',
    completed: false,
  },
  {
    title: 'Do a pull-up',
    completed: true,
  },
  {
    title: 'Become a JavaScript boss',
    completed: false,
  },
]);
