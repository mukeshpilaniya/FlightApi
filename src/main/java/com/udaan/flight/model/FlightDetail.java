package com.udaan.flight.model;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class FlightDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private long id;

    @Column(name ="flight_number" )
    private long flightno;

    @Column(name = "flight_name")
    private String name;

    @Column(name = "number_of_seats")
    private long numberOfSeats;

    public FlightDetail() {
    }

    public FlightDetail(long flightno, String name,long numberOfSeats) {
        this.flightno=flightno;
        this.name=name;
        this.numberOfSeats=numberOfSeats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getflightno() {
        return flightno;
    }

    public void setflightno(long flightno) {
        this.flightno = flightno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

}
