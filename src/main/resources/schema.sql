DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS votes;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE GLOBAL_SEQ START WITH 100000;

CREATE TABLE users
(
    id               INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    first_name       VARCHAR(255)            NOT NULL,
    last_name        VARCHAR(255)            NOT NULL,
    email            VARCHAR(255)            NOT NULL,
    password         VARCHAR(255)            NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON USERS (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id          INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name        VARCHAR(255)            NOT NULL,
    description VARCHAR(255)            NOT NULL,
    registered  TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE dishes
(
    id              INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    date_menu       DATE DEFAULT now()  NOT NULL,
    name            VARCHAR(255) NOT NULL,
    price           NUMERIC(5,2) NOT NULL,
    description     VARCHAR(255) NOT NULL,
    restaurant_id   INTEGER      NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE votes
(
    vote_date       DATE DEFAULT now() NOT NULL,
    user_id         INTEGER NOT NULL,
    restaurant_id   INTEGER NOT NULL,
    CONSTRAINT user_vote_date_idx UNIQUE (user_id, vote_date),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE
);
