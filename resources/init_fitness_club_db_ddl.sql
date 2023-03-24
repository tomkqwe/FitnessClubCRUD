CREATE DATABASE fitness_club;
CREATE SCHEMA fitness_club_db;

DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS client_status;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS coach_education;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS sport_name;
DROP TABLE IF EXISTS traning;

CREATE TABLE sport_name
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE coach
(
    id               SERIAL PRIMARY KEY,
    last_name        TEXT                           NOT NULL,
    first_name       TEXT                           NOT NULL,
    education_id     INT REFERENCES coach_education (id),
    sport_id         INT REFERENCES sport_name (id) NOT NULL,
    years_experience INT                            NOT NULL
);

CREATE TABLE coach_education
(
    id             SERIAL PRIMARY KEY,
    name_education TEXT NOT NULL UNIQUE
);

CREATE TABLE client
(
    id         SERIAL PRIMARY KEY,
    last_name  TEXT NOT NULL,
    first_name TEXT NOT NULL,
    status_id  INT REFERENCES client_status (id),
    days_left  INT  not null
);

CREATE TABLE client_status
(
    id          SERIAL PRIMARY KEY,
    status_name TEXT NOT NULL UNIQUE
);

CREATE TABLE traning(
                        id SERIAL PRIMARY KEY ,
                        coach_id INT REFERENCES coach(id),
                        sport_id INT REFERENCES sport_name(id),
                        client_id INT REFERENCES client(id),
                        price NUMERIC NOT NULL,
                        shedule_id INT REFERENCES schedule(id)
);

CREATE TABLE schedule(
                         id SERIAL PRIMARY KEY,
                         coach_id INT REFERENCES coach(id),
                         sport_id INT REFERENCES sport_name(id),
                         duration_hours INT NOT NULL
)