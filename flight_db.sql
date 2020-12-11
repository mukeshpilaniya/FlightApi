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
