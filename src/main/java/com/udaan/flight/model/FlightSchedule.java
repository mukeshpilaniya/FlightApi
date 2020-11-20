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
    @JoinColumn(name = "from_flight_station")
    private Station fromFlightStation;

    @ManyToOne
    @JoinColumn(name = "to_flight_station")
    private Station toFlightStation;

    @Column(name = "day_of_the_week")
    private Day day;

    @Column(name = "departure_time")
    private Timestamp departureTime;

    @Column(name = "arrival_time")
    private Timestamp arrivalTime;

    public FlightSchedule() {
    }

    public FlightSchedule(FlightDetail flight, Station fromFlightStation, Station toFlightStation,Day day, Timestamp departureTime,Timestamp arrivalTime ){
        this.flight=flight;
        this.fromFlightStation=fromFlightStation;
        this.toFlightStation=toFlightStation;
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

    public Station getFromFlightStation() {
        return fromFlightStation;
    }

    public void setFromFlightStation(Station fromFlightStation) {
        this.fromFlightStation = fromFlightStation;
    }

    public Station getToFlightStation() {
        return toFlightStation;
    }

    public void setToFlightStation(Station toFlightStation) {
        this.toFlightStation = toFlightStation;
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
