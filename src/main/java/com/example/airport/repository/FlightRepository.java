package com.example.airport.repository;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Flight;

@Repository
public interface FlightRepository{

  void create(Flight flight);
}
