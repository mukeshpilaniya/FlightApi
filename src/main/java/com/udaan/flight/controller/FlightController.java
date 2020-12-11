package com.udaan.flight.controller;

import com.udaan.flight.model.*;
import com.udaan.flight.repository.*;
import com.udaan.flight.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightDetailRepository flightDetailRepository;
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/flight/search/{source}/{destination}/{date}")
    public ResponseEntity<?> searchFlight(@PathVariable String source, @PathVariable String destination, @PathVariable Date date) {

        int d = DateUtils.getDayOftheWeek(date);
        Day day = getDay(d);
        System.out.println(source+" "+destination+" "+date + " " + day);
        return new ResponseEntity<>(flightScheduleRepository.getByFromFlightAirportNameAndToFlightAirportNameAndDay(source, destination, day), HttpStatus.OK);
    }

    public Day getDay(int d) {
        Day day = Day.SUNDAY; //random initialization
        switch (d) {
            case 1:
                day = Day.SUNDAY;
                break;
            case 2:
                day = Day.MONDAY;
                break;
            case 3:
                day = Day.TUESDAY;
                break;
            case 4:
                day = Day.WEDNESDAY;
                break;
            case 5:
                day = Day.THURSDAY;
                break;
            case 6:
                day = Day.FRIDAY;
                break;
            case 7:
                day = Day.SATURDAY;
                break;
        }
        return day;
    }

    @RequestMapping(value = "/flight/reserveSeats/{userId}/{flightNumber}/{source}/{destination}/{date}/{seats}")
    public ResponseEntity<?> reserveSeats(@PathVariable long userId, @PathVariable long flightNumber, @PathVariable String source,
                                          @PathVariable String destination, @PathVariable Date date, @PathVariable long seats) {
        FlightDetail bus = flightDetailRepository.findByFlightno(flightNumber);
        Airport fAirport = airportRepository.findByName(source);
        Airport dAirport = airportRepository.findByName(destination);

        int d = DateUtils.getDayOftheWeek(date);
        Day day = getDay(d);

        if (bus == null || fAirport == null || dAirport == null) {
            return new ResponseEntity<>("flightnumber or Airport or userId not found", HttpStatus.NOT_FOUND);
        } else {

            List<Ticket> ticketList = ticketRepository.getByFlightnumerAndFromAirportAndToAirportAndAndDate(flightNumber, source, destination, date);
            System.out.println("yes");
            long totalSeats = flightDetailRepository.findByFlightno(flightNumber).getNumberOfSeats();
            long bookSeats = 0;
            for (int i = 0; i < ticketList.size(); i++) {
                bookSeats = bookSeats + (ticketList.get(i).getReserveSeats());
            }
            System.out.println(totalSeats+" "+bookSeats);
            if (totalSeats - bookSeats >= seats) {
                User user=userRepository.findById(userId);
                System.out.println(user);
                Ticket ticket = new Ticket(user, flightNumber, source, destination, date, seats);
                return new ResponseEntity<>(ticketRepository.save(ticket), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>( " only " + (totalSeats - bookSeats) + " tickets are available", HttpStatus.OK);
            }

        }
    }
}