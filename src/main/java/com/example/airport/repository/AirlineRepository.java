package com.example.airport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airline;

@Repository
public interface AirlineRepository {
  Optional<Airline> findById(int id);
  List<Airline> findAll();
  Airline create(Airline airline);
  Airline update(Airline airline);
}
