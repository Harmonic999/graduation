DROP TABLE IF EXISTS food;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS registered_votes;

CREATE TABLE work.restaurants (
  id         INT         NOT NULL AUTO_INCREMENT,
  name       VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE(id ASC) VISIBLE
);

CREATE TABLE work.food (
  id            INT         NOT NULL AUTO_INCREMENT,
  restaurant_id INT         NOT NULL,
  description   VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE(id ASC) VISIBLE
);

CREATE TABLE work.users (
  id         INT                     NOT NULL AUTO_INCREMENT,
  name       VARCHAR(50)             NOT NULL,
  email      VARCHAR(50)             NOT NULL UNIQUE,
  password   VARCHAR(255)             NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL,
  UNIQUE INDEX id_UNIQUE(id ASC) VISIBLE,
  UNIQUE INDEX email_UNIQUE(email ASC)
);

CREATE TABLE work.user_roles (
  user_id INTEGER NOT NULL,
  role    VARCHAR(50)
    REFERENCES users (id)
      ON DELETE CASCADE
);

CREATE TABLE work.registered_votes (
  user_id INTEGER NOT NULL,
  restaurant_id INTEGER NOT NULL,
  UNIQUE INDEX id_UNIQUE(user_id ASC) VISIBLE
);

