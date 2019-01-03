DROP TABLE bitings;
DROP TABLE zombies;
DROP TABLE victims;

CREATE TABLE zombies
(
  id SERIAL8 PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255)
);

CREATE TABLE victims
(
  id SERIAL8 PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  run_speed INT2
);

CREATE TABLE bitings
(
  id SERIAL8 PRIMARY KEY,
  victim_id INT8 REFERENCES victims(id),
  zombie_id INT8 REFERENCES zombies(id),
  infected_on DATE NOT NULL
);

INSERT INTO victims (name, run_speed) VALUES ('Rick', 12);
INSERT INTO victims (name, run_speed) VALUES ('Maggie', 11);
INSERT INTO victims (name, run_speed) VALUES ('Michonne', 15);
INSERT INTO victims (name, run_speed) VALUES ('Glenn', 30);

INSERT INTO zombies (name, type) VALUES ('Romero', 'generic');
INSERT INTO zombies (name, type) VALUES ('Boyle', 'runner');
INSERT INTO zombies (name, type) VALUES ('Raimi', 'deadite');
INSERT INTO zombies (name, type) VALUES ('Newell', 'boomer');

INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (1, 1, 'March 27 2018');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (2, 2,'March 29 2018');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (4, 3, 'March 30 2018');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (1, 3, 'March 30 2018');
