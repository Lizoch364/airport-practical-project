package com.example.airport.service;

import java.util.List;

import com.example.airport.dto.AirportCreateDto;
import com.example.airport.dto.AirportDto;
import com.example.airport.dto.AirportUpdateDto;

public interface AirportService {
  AirportDto findById(int id);
  List<AirportDto> findAll();
  AirportDto create(AirportCreateDto airportcreateDto);
  AirportDto update(AirportUpdateDto airportUpdateDto);
}
