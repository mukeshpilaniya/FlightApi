package com.udaan.flight.repository;

import com.udaan.flight.model.FlightDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDetailRepository extends JpaRepository<FlightDetail,Long> {
    FlightDetail findByFlightno(long no);
}
