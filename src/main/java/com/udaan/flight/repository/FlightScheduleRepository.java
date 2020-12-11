package com.udaan.flight.repository;

import com.udaan.flight.model.Day;
import com.udaan.flight.model.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule,Long> {

    List<FlightSchedule> getByFromFlightAirportNameAndToFlightAirportNameAndDay(String source, String destination, Day day);
}
