package com.udaan.flight.repository;

import com.udaan.flight.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {

    Airport findByName(String name);
}
