package com.example.airport.service;

import com.example.airport.dto.FlightCreateDto;
import com.example.airport.dto.FlightUpdateDto;

import com.example.airport.dto.FlightDto;
import java.util.List;

public interface FlightService {
  FlightDto findById(int id);
  List<FlightDto> findAll();
  FlightDto create(FlightCreateDto flightCreateDto);
  FlightDto update(FlightUpdateDto flightUpdateDto);
}
