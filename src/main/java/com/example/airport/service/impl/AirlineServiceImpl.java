package com.example.airport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Airline;
import com.example.airport.repository.AirlineRepository;
import com.example.airport.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {
  @Autowired
  private AirlineRepository airlineRepository;

  @Override
  public void create(Airline airline) {
    airlineRepository.create(airline);
  }
}
