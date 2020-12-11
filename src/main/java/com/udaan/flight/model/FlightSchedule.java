package com.udaan.flight.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightDetail flight;

    @ManyToOne
    @JoinColumn(name = "from_flight_airport")
    private Airport fromFlightAirport;

    @ManyToOne
    @JoinColumn(name = "to_flight_airport")
    private Airport toFlightAirport;

    @Column(name = "day_of_the_week")
    private Day day;

    @Column(name = "departure_time")
    private Timestamp departureTime;

    @Column(name = "arrival_time")
    private Timestamp arrivalTime;

    public FlightSchedule() {
    }

    public FlightSchedule(FlightDetail flight, Airport fromFlightAirport, Airport toFlightAirport, Day day, Timestamp departureTime, Timestamp arrivalTime ){
        this.flight=flight;
        this.fromFlightAirport = fromFlightAirport;
        this.toFlightAirport = toFlightAirport;
        // this.date=date;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.day=day;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FlightDetail getFlight() {
        return flight;
    }

    public void setFlight(FlightDetail flight) {
        this.flight = flight;
    }

    public Airport getFromFlightAirport() {
        return fromFlightAirport;
    }

    public void setFromFlightAirport(Airport fromFlightAirport) {
        this.fromFlightAirport = fromFlightAirport;
    }

    public Airport getToFlightAirport() {
        return toFlightAirport;
    }

    public void setToFlightAirport(Airport toFlightAirport) {
        this.toFlightAirport = toFlightAirport;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
