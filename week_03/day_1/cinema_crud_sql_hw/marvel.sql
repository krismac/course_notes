DROP TABLE movies;
DROP TABLE people;

CREATE TABLE movies (
	id SERIAL8 PRIMARY KEY,
	title VARCHAR(255),
	year INT2,
	show_time VARCHAR(255)
);

CREATE TABLE people (
	id SERIAL8 PRIMARY KEY,
	name VARCHAR(255)
);INSERT INTO people (name) VALUES ('Ana Martinez');
INSERT INTO people (name) VALUES ('Andrew Carracher');
INSERT INTO people (name) VALUES ('Caroline Graves');
INSERT INTO people (name) VALUES ('Genna-Lee Walsh');
INSERT INTO people (name) VALUES ('Graham Stein');
INSERT INTO people (name) VALUES ('Iain Floyd');
INSERT INTO people (name) VALUES ('Iona Wright');
INSERT INTO people (name) VALUES ('Jackie Farr');
INSERT INTO people (name) VALUES ('Jennifer Proctor');
INSERT INTO people (name) VALUES ('Jordan Raitt');
INSERT INTO people (name) VALUES ('Katherine Jeffree');
INSERT INTO people (name) VALUES ('Kris McElhinney');
INSERT INTO people (name) VALUES ('Michael Griffin');
INSERT INTO people (name) VALUES ('Monica Mateiu');
INSERT INTO people (name) VALUES ('Nathan Atkinson');
INSERT INTO people (name) VALUES ('Nyalls Hemingway');
INSERT INTO people (name) VALUES ('Oksana Richards');
INSERT INTO people (name) VALUES ('Rana Akbar');
INSERT INTO people (name) VALUES ('Tavy Fraser');
INSERT INTO people (name) VALUES ('Thomas Gracie');
INSERT INTO people (name) VALUES ('Xavier Godard');
INSERT INTO people (name) VALUES ('Kith Douglas');

INSERT INTO movies (title, year, show_time) VALUES ('Iron Man', 2008, '15:35');
INSERT INTO movies (title, year, show_time) VALUES ('The Incredible Hulk', 2008, '22:05');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 2', 2010, '18:00');
INSERT INTO movies (title, year, show_time) VALUES ('Thor', 2011, '21:20');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The First Avenger', 2011, '13:10');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers Assemble', 2012, '14:30');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 3', 2013, '21:55');
INSERT INTO movies (title, year, show_time) VALUES ('Thor: The Dark World', 2013, '15:20');
INSERT INTO movies (title, year, show_time) VALUES ('Batman Begins', 2005, '20:30');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The Winter Soldier', 2014, '21:10');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy', 2014, '16:20');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers: Age of Ultron', 2015, '23:00');
INSERT INTO movies (title, year, show_time) VALUES ('Ant-Man', 2015, '13:25');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: Civil War', 2016, '14:45');
INSERT INTO movies (title, year, show_time) VALUES ('Doctor Strange', 2016, '22:40');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy 2', 2017, '22:00');
INSERT INTO movies (title, year, show_time) VALUES ('Spider-Man: Homecoming', 2017, '18:10');
INSERT INTO movies (title, year, show_time) VALUES ('Thor: Ragnarok', 2017, '19:35');
INSERT INTO movies (title, year, show_time) VALUES ('Black Panther', 2018, '22:20');

