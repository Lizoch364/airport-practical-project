package com.example.airport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Flight;
import com.example.airport.repository.FlightRepository;
import com.example.airport.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
  @Autowired
  private FlightRepository flightRepository;

  @Override
  public void create(Flight flight) {
    flightRepository.create(flight);
  }
}
