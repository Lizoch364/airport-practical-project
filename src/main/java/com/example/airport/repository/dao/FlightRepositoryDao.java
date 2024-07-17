package com.example.airport.repository.dao;

import java.util.List;
import java.util.Optional;

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
  public Optional<Flight> findById(int id) {
    return baseRepository.findById(id);
  }

  @Override
  public List<Flight> findAll() {
   return baseRepository.findAll();
  }

  @Override
  public Flight create(Flight flight) {
    return baseRepository.save(flight);
  }

  @Override
  public Flight update(Flight flight) {
    return baseRepository.save(flight);
  }
}

@Repository
interface BaseFlightRepository extends JpaRepository<Flight, Integer> {}
