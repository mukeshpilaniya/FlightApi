# FlightApi
``` Json
Server url- http://localhost:8080
Database- Mysql
Java version- 1.8.0_242
Project Type- Maven
Framework- spring boot
Dependencies- spring web,spring data Jpa
```Mysql
-- run these commands to setup mysql database for application before running the application jar
-- drop database if exits
DROP DATABASE IF EXISTS flight_db;

-- create database name
CREATE DATABASE flight_db;

-- create user with password
CREATE USER 'flight_user'@'localhost' IDENTIFIED BY 'flight_password';

-- provide all the permission
GRANT ALL PRIVILEGES ON flight_db. * TO 'flight_user'@'localhost';


--run application

either you can build project using mavan package or run java -jar flight-0.0.1-SNAPSHOT.jar

-- tables in flight_db
+---------------------+
| Tables_in_flight_db |
+---------------------+
| flight              |
| flight_schedule     |
| station             |
| ticket              |
| user                |
+---------------------+

-- user table
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| email        | varchar(255) | YES  |     | NULL    |                |
| name         | varchar(255) | YES  |     | NULL    |                |
| phone_number | bigint(20)   | YES  |     | NULL    |                |
| user_name    | varchar(255) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+

--flight table
+-----------------+--------------+------+-----+---------+----------------+
| Field           | Type         | Null | Key | Default | Extra          |
+-----------------+--------------+------+-----+---------+----------------+
| flight_id       | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| flight_number   | bigint(20)   | YES  |     | NULL    |                |
| flight_name     | varchar(255) | YES  |     | NULL    |                |
| number_of_seats | bigint(20)   | YES  |     | NULL    |                |
+-----------------+--------------+------+-----+---------+----------------+

-- station table
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| station_id   | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| station_city | varchar(255) | YES  |     | NULL    |                |
| station_code | varchar(255) | YES  |     | NULL    |                |
| station_name | varchar(255) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+

-- flight_schedule table
+------------------+------------+------+-----+---------+----------------+
| Field            | Type       | Null | Key | Default | Extra          |
+------------------+------------+------+-----+---------+----------------+
| schedule_id      | bigint(20) | NO   | PRI | NULL    | auto_increment |
| arrival_time     | datetime   | YES  |     | NULL    |                |
| day_of_the_week  | int(11)    | YES  |     | NULL    |                |
| departure_time   | datetime   | YES  |     | NULL    |                |
| bus_id           | bigint(20) | YES  | MUL | NULL    |                |
| from_bus_station | bigint(20) | YES  | MUL | NULL    |                |
| to_bus_station   | bigint(20) | YES  | MUL | NULL    |                |
+------------------+------------+------+-----+---------+----------------+

-- ticket table
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| id           | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| bus_number   | bigint(20)   | YES  |     | NULL    |                |
| date         | date         | YES  |     | NULL    |                |
| source       | varchar(255) | YES  |     | NULL    |                |
| reserve_seat | bigint(20)   | YES  |     | NULL    |                |
| destination  | varchar(255) | YES  |     | NULL    |                |
| user_id      | bigint(20)   | YES  | MUL | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+

```

# RestAPI call endpoints

1. resister user 
Endpoint url:- http://localhost:8080/user/add
Example:
Request Type-POST method
Request:- http://localhost:8080/user/add/
{
    "name": "pilaniya1",
    "userName": "iceman",
    "email": "pilaniya1@iiitb.org",
    "phoneNumber": 982688344
}
Response:-
{
    "id": 2,
    "name": "pilaniya1",
    "userName": "iceman",
    "email": "pilaniya1@iiitb.org",
    "phoneNumber": 982688344,
    "ticket": []
}

2. search flight

Endpoint Url:- http://localhost:8080/flight/search/{source}/{destination}/{date}
Example:
Request Type-GET method
Request:- http://localhost:8080/flight/search/jaipur/delhi/2020-11-03


2. reserve seats
Endpoint url:- http://localhost:8080/flight/reserveSeats/{userId}/{flightNumber}/{source}/{destination}/{date}/{seats}
Example:
Request Type-GET method
Request:- http://localhost:8080/flight/reserveSeats/1/101/jaipur/delhi/2020-11-03/5
```
