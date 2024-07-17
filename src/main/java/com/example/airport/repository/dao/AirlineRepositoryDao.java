package com.example.airport.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airline;
import com.example.airport.repository.AirlineRepository;

@Repository
public class AirlineRepositoryDao implements AirlineRepository{
  @Autowired
  private BaseAirlineRepository baseRepository;

  @Override
  public Optional<Airline> findById(int id) {
    return baseRepository.findById(id);
  }

  @Override
  public List<Airline> findAll() {
    return baseRepository.findAll();
  }

  @Override
  public Airline create(Airline airline) {
    baseRepository.save(airline);
    return airline;
  }

  @Override
  public Airline update(Airline airline) {
    return baseRepository.save(airline);
  }
}

@Repository
interface BaseAirlineRepository extends JpaRepository<Airline, Integer>{}
