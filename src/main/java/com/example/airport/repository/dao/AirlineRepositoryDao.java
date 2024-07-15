package com.example.airport.repository.dao;

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
  public void create(Airline airline) {
    baseRepository.save(airline);
  }
}

@Repository
interface BaseAirlineRepository extends JpaRepository<Airline, Integer>{}
