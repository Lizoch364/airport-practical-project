package com.example.airport.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.Flight;
import com.example.airport.repository.FlightRepository;

@Repository
public class FlightRepositoryDao implements FlightRepository{
  @Autowired
  private BaseFlightRepository baseRepository;

  @Override
  public void create(Flight flight) {
    baseRepository.save(flight);
  }
}

@Repository
interface BaseFlightRepository extends JpaRepository<Flight, Integer> {}
