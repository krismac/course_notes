DROP TABLE bitings;
DROP TABLE zombies;
DROP TABLE victims;

CREATE TABLE zombies
(
  id SERIAL8 primary key,
  name VARCHAR(255) not null,
  type VARCHAR(255)
);

CREATE TABLE victims
(
  id SERIAL8 primary key,
  name VARCHAR(255) not null,
  run_speed INT2
);

CREATE TABLE bitings
(
  id SERIAL8 primary key,
  victim_id INT8 references victims(id),
  zombie_id INT8 references zombies(id)
);