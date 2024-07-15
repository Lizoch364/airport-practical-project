package com.example.airport.repository;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airline;

@Repository
public interface AirlineRepository {
  void create(Airline airline);
}
