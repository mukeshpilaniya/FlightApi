package com.udaan.flight.repository;

import com.udaan.flight.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> getByUserId(long userid);
    Ticket findById(long ticketId);
    List<Ticket> getByFlightnumerAndFromStationAndToStationAndAndDate(long flightno, String source, String destination, Date date);
}

