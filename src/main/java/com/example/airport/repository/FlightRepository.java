package com.example.airport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Flight;

@Repository
public interface FlightRepository{

  Optional<Flight> findById(int id);
  List<Flight> findAll();
  Flight create(Flight flight);
  Flight update(Flight flight);
}
