package com.example.airport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Airport;
import com.example.airport.repository.AirportRepository;
import com.example.airport.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{
  @Autowired
  private AirportRepository airportRepository;

  @Override
  public void create(Airport airport) {
    airportRepository.create(airport);
  }

  
}
