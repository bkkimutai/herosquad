SET MODE PostgresSQL;

CREATE TABLE IF NOT EXISTS heros(
    heroId int PRIMARY KEY auto_increment,
    heroName VARCHAR,
    heroAge INT,
    heroPower VARCHAR,
    heroWeakness VARCHAR,
    squadId INT,
);

CREATE TABLE IF NOT EXISTS squads (
   squadId int PRIMARY KEY auto_increment,
   squadName VARCHAR,
   squadCause VARCHAR,
   maxSize INT,
   squadFull BOOLEAN
);