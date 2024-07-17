package com.example.airport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Passenger;

@Repository
public interface PassengerRepository {
  List<Passenger> findAll();
  Optional<Passenger> findById(int id);
  Passenger create(Passenger passenger);
  Passenger update (Passenger passenger);
  // void delete(int id);
}
