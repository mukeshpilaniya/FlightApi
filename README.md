# Flight Ticket Reservation

#### Description
Flight Ticket Reservation Duration: 90 minutes
Design and implement an application to reserve flights based on source, destination and date. The application should take care of the following aspects:

    • Repository of flight information containing airline name, flight number, source, destination, start time, end time, frequency (days on which the flight is active), total number of seats in the aircraft(capacity)
    • Ability to search for flights based on source, destination anddate
    • Reserve 'n'numberof seats on a particular fight based on availability of seats.

APIs:

    1. Search for flights based on source, destination anddate
    2. Userbeingabletoreserve'n'numberofseatsonaparticularfight(thisAPI should keep availability of seats on that flight inmind)
    3. View reservations for a users (both past andupcoming)

Expectation:

    • Clean professional levelCode
    • Modelling of core entities and relationships betweenthem.
    • Your code needs to be demonstrable. To do this, you can need to have an API based solution either as a WebApp, MobileApp or even providebasic API calls to run through the above mentionedworkflows.
    • Workflows for creation of flight repository are not required. This could be pre- loaded as a part of applicationstartup.
    • User Identification but notauthentication
    • Backend Database is optional. However modelling should becomplete

##### Project info
``` json
Server url- http://localhost:8080
Database- Mysql
Java version- 1.8.0_242
Project Type- Maven
Framework- spring boot
Dependencies- spring web,spring data Jpa
```

##### run these commands to setup mysql database for application before running the application jar
``` json
-- drop database if exits
DROP DATABASE IF EXISTS flight_db;

-- create database name
CREATE DATABASE flight_db;

-- create user with password
CREATE USER 'flight_user'@'localhost' IDENTIFIED BY 'flight_password';

-- provide all the permission
GRANT ALL PRIVILEGES ON flight_db. * TO 'flight_user'@'localhost';
```
##### Dummy data for application
``` json
-- Dummy data for airport table
INSERT INTO `flight_db`.`airport` (`airport_id`, `airport_city`, `airport_code`, `airport_name`) VALUES ('1', 'jaipur', 'JP', 'jaipur');
INSERT INTO `flight_db`.`airport` (`airport_id`, `airport_city`, `airport_code`, `airport_name`) VALUES ('2', 'delhi', 'NCR', 'delhi');
INSERT INTO `flight_db`.`airport` (`airport_id`, `airport_city`, `airport_code`, `airport_name`) VALUES ('3', 'bangalore', 'BNG', 'bangalore');
INSERT INTO `flight_db`.`airport` (`airport_id`, `airport_city`, `airport_code`, `airport_name`) VALUES ('4', 'pune', 'PU', 'pune');
INSERT INTO `flight_db`.`airport` (`airport_id`, `airport_city`, `airport_code`, `airport_name`) VALUES ('5', 'sikar', 'SIK', 'sikar');

-- Dummy data for flight table
INSERT INTO `flight_db`.`flight` (`flight_id`, `flight_number`, `flight_name`, `number_of_seats`) VALUES ('1', '101', 'AIRIndia', '55');
INSERT INTO `flight_db`.`flight` (`flight_id`, `flight_number`, `flight_name`, `number_of_seats`) VALUES ('2', '102', 'GoAIR ', '45');
INSERT INTO `flight_db`.`flight` (`flight_id`, `flight_number`, `flight_name`, `number_of_seats`) VALUES ('3', '103', 'AIRindia', '60');
INSERT INTO `flight_db`.`flight` (`flight_id`, `flight_number`, `flight_name`, `number_of_seats`) VALUES ('4', '104', 'Indigo', '55');
INSERT INTO `flight_db`.`flight` (`flight_id`, `flight_number`, `flight_name`, `number_of_seats`) VALUES ('5', '105', 'GoAIR', '50');

-- Dummy data for flight_schedule table
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('1', '2020-11-02 10:00:00', '1', '2020-11-02 09:00:00', '1', '1', '3');
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('2', '2020-11-02 11:00:00', '1', '2020-11-02 09:00:00', '1', '1', '4');
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('3', '2020-11-03 10:30:00', '2', '2020-11-03 09:00:00', '1', '1', '3');
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('4', '2020-11-04 11:25:00', '3', '2020-11-04 10:00:00', '1', '2', '5');
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('5', '2020-11-03 09:00:00', '2', '2020-11-03 08:00:00', '2', '1', '3');
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('6', '2020-11-03 10:00:00', '2', '2020-11-03 08:00:00', '2', '1', '5');
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('7', '2020-11-05 11:50:00', '4', '2020-11-05 11:25:00', '3', '2', '4');
INSERT INTO `flight_db`.`flight_schedule` (`schedule_id`, `arrival_time`, `day_of_the_week`, `departure_time`, `flight_id`, `from_flight_airport`, `to_flight_airport`) VALUES ('8', '2020-11-05 09:40:00', '4', '2020-11-05 08:30:00', '4', '3', '1');

-- Dummy data for user table
INSERT INTO `flight_db`.`user` (`id`, `email`, `name`, `phone_number`, `user_name`) VALUES ('1', 'pilaniya@iiitb.org', 'mukesh', '123456789', 'pilaniya');
INSERT INTO `flight_db`.`user` (`id`, `email`, `name`, `phone_number`, `user_name`) VALUES ('2', 'pilaniya1@iiitb.org', 'rohit', '123456789', 'pilaniya1');
INSERT INTO `flight_db`.`user` (`id`, `email`, `name`, `phone_number`, `user_name`) VALUES ('3', 'pilaniya2@iiitb.org', 'sumit', '123456789', 'pilaniya2');
INSERT INTO `flight_db`.`user` (`id`, `email`, `name`, `phone_number`, `user_name`) VALUES ('4', 'pilaniya3@iiitb.org', 'rakesh', '123456789', 'pilaniya3');

-- Dummy data for ticket table
INSERT INTO `flight_db`.`ticket` (`ticket_id`, `date`, `flight_number`, `source`, `reserve_seat`, `destination`, `user_id`) VALUES ('1', '2020-11-02', '101', 'jaipur', '2', 'bangalore', '1');
INSERT INTO `flight_db`.`ticket` (`ticket_id`, `date`, `flight_number`, `source`, `reserve_seat`, `destination`, `user_id`) VALUES ('2', '2020-11-09', '101', 'jaipur', '2', 'bangalore', '1');
INSERT INTO `flight_db`.`ticket` (`ticket_id`, `date`, `flight_number`, `source`, `reserve_seat`, `destination`, `user_id`) VALUES ('3', '2020-11-02', '101', 'jaipur', '1', 'bangalore', '1');
INSERT INTO `flight_db`.`ticket` (`ticket_id`, `date`, `flight_number`, `source`, `reserve_seat`, `destination`, `user_id`) VALUES ('4', '2020-11-02', '101', 'jaipur', '2', 'bangalore', '1');
INSERT INTO `flight_db`.`ticket` (`ticket_id`, `date`, `flight_number`, `source`, `reserve_seat`, `destination`, `user_id`) VALUES ('5', '2020-11-03', '102', 'jaipur', '15', 'bangalore', '1');
INSERT INTO `flight_db`.`ticket` (`ticket_id`, `date`, `flight_number`, `source`, `reserve_seat`, `destination`, `user_id`) VALUES ('6', '2020-11-02', '101', 'jaipur', '5', 'bangalore', '1');
```

##### run application
either you can build project using maven package or run `` java -jar flight-0.0.1-SNAPSHOT.jar ``

##### tables in flight_db
``` json
+---------------------+
| Tables_in_flight_db |
+---------------------+
| airport             |
| flight              |
| flight_schedule     |
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

-- airport table
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| airport_id   | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| airport_city | varchar(255) | YES  |     | NULL    |                |
| airport_code | varchar(255) | YES  |     | NULL    |                |
| airport_name | varchar(255) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+

-- flight_schedule table
+---------------------+------------+------+-----+---------+----------------+
| Field               | Type       | Null | Key | Default | Extra          |
+---------------------+------------+------+-----+---------+----------------+
| schedule_id         | bigint(20) | NO   | PRI | NULL    | auto_increment |
| arrival_time        | datetime   | YES  |     | NULL    |                |
| day_of_the_week     | int(11)    | YES  |     | NULL    |                |
| departure_time      | datetime   | YES  |     | NULL    |                |
| flight_id           | bigint(20) | YES  | MUL | NULL    |                |
| from_flight_airport | bigint(20) | YES  | MUL | NULL    |                |
| to_flight_airport   | bigint(20) | YES  | MUL | NULL    |                |
+---------------------+------------+------+-----+---------+----------------+

-- ticket table
+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| ticket_id     | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| date          | date         | YES  |     | NULL    |                |
| flight_number | bigint(20)   | YES  |     | NULL    |                |
| source        | varchar(255) | YES  |     | NULL    |                |
| reserve_seat  | bigint(20)   | YES  |     | NULL    |                |
| destination   | varchar(255) | YES  |     | NULL    |                |
| user_id       | bigint(20)   | YES  | MUL | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+
``` 

##### RestAPI call endpoints
``` css
1. register user 
Endpoint url:- http://localhost:8080/user/add
Request Type-POST method
Example:
Request:- http://localhost:8080/user/add/
{
    "name": "pilaniya1",
    "userName": "iceman",
    "email": "pilaniya1@iiitb.org",
    "phoneNumber": 982688344
}
Response:-
{
    "id": 5,
    "name": "pilaniya5",
    "userName": "pilaniya5",
    "email": "pilaniya5@iiitb.org",
    "phoneNumber": 123456789
}
```
``` css
2.search flight
Endpoint Url:- http://localhost:8080/flight/search/{source}/{destination}/{date}
Request Type-GET method
Example:
Request:- http://localhost:8080/flight/search/jaipur/bangalore/2020-11-23
Response:-
[
    {
        "id": 1,
        "flight": {
            "id": 1,
            "flightno": 101,
            "name": "AIRIndia",
            "numberOfSeats": 55
        },
        "fromFlightAirport": {
            "id": 1,
            "name": "jaipur",
            "code": "JP",
            "city": "jaipur"
        },
        "toFlightAirport": {
            "id": 3,
            "name": "bangalore",
            "code": "BNG",
            "city": "bangalore"
        },
        "day": "MONDAY",
        "departureTime": "2020-11-02T03:30:00.000+00:00",
        "arrivalTime": "2020-11-02T04:30:00.000+00:00"
    }
]
```

``` css
3. reserve seats
Endpoint url:- http://localhost:8080/flight/reserveSeats/{userId}/{flightNumber}/{source}/{destination}/{date}/{seats}
Request Type-GET method
Example:
Request:- http://localhost:8080/flight/reserveSeats/1/101/jaipur/bangalore/2020-11-02/13
Response:-
{
    "id": 7,
    "flightnumer": 101,
    "fromAirport": "jaipur",
    "toAirport": "bangalore",
    "date": "2020-11-02",
    "reserveSeats": 13
}
Request:- http://localhost:8080/flight/reserveSeats/1/101/jaipur/bangalore/2020-11-02/65
Response:-  only 32 tickets are available
```
``` css
4. view reservation
Endpoint url:- http://localhost:8080/user/viewReservation/{userId}
Request Type-GET method
Request:-http://localhost:8080/user/viewReservation/1
Response:- 
[
    {
        "id": 1,
        "flightnumer": 101,
        "fromAirport": "jaipur",
        "toAirport": "bangalore",
        "date": "2020-11-02",
        "reserveSeats": 2
    },
    {
        "id": 2,
        "flightnumer": 101,
        "fromAirport": "jaipur",
        "toAirport": "bangalore",
        "date": "2020-11-09",
        "reserveSeats": 2
    },
    {
        "id": 3,
        "flightnumer": 101,
        "fromAirport": "jaipur",
        "toAirport": "bangalore",
        "date": "2020-11-02",
        "reserveSeats": 1
    },
    {
        "id": 4,
        "flightnumer": 101,
        "fromAirport": "jaipur",
        "toAirport": "bangalore",
        "date": "2020-11-02",
        "reserveSeats": 2
    },
    {
        "id": 5,
        "flightnumer": 102,
        "fromAirport": "jaipur",
        "toAirport": "bangalore",
        "date": "2020-11-03",
        "reserveSeats": 15
    },
    {
        "id": 6,
        "flightnumer": 101,
        "fromAirport": "jaipur",
        "toAirport": "bangalore",
        "date": "2020-11-02",
        "reserveSeats": 5
    },
    {
        "id": 7,
        "flightnumer": 101,
        "fromAirport": "jaipur",
        "toAirport": "bangalore",
        "date": "2020-11-02",
        "reserveSeats": 13
    }
]
```
