DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  age VARCHAR(250) NOT NULL,
  favourite_colour VARCHAR(250) NOT NULL,
  nationality VARCHAR(250) NOT NULL
);