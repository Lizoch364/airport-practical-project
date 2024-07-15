package com.example.airport.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Passenger;

@Repository
public interface PassengerRepository {
  void create(Passenger passenger);
  Optional<Passenger> findById (int id);
}
