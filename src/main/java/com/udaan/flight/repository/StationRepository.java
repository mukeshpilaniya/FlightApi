package com.udaan.flight.repository;

import com.udaan.flight.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Long> {

    Station findByName(String name);
}
