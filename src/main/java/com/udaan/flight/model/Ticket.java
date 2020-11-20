package com.udaan.flight.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private  long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "flight_number")
    private long flightnumer;

    @Column(name = "source")
    private String fromStation;

    @Column(name = "destination")
    private String toStation;

    @Column(name = "date")
    private Date date;

    @Column(name = "reserve_seat")
    private long reserveSeats;

    public Ticket() {
    }
    public Ticket(User userId,long flightnumer,String source, String destination, Date date, long reserveSeats) {
        this.user=userId;
        this.flightnumer=flightnumer;
        this.fromStation=source;
        this.toStation=destination;
        this.date=date;
        this.reserveSeats=reserveSeats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFlightnumer() {
        return flightnumer;
    }

    public void setFlightnumer(long flightnumer) {
        this.flightnumer = flightnumer;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getReserveSeats() {
        return reserveSeats;
    }

    public void setReserveSeats(long reserveSeats) {
        this.reserveSeats = reserveSeats;
    }
}
