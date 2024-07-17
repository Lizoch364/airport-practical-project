package com.example.airport.service;

import java.util.List;

import com.example.airport.dto.AirlineCreateDto;
import com.example.airport.dto.AirlineDto;
import com.example.airport.dto.AirlineUpdateDto;

public interface AirlineService {
  AirlineDto findById(int id);
  List<AirlineDto> findAll();
  AirlineDto create(AirlineCreateDto airlineCreateDto);
  AirlineDto update(AirlineUpdateDto airlineUpdateDto);
}
