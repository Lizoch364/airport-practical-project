package com.example.airport.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Airport;
import com.example.airport.dto.AirportCreateDto;
import com.example.airport.dto.AirportDto;
import com.example.airport.dto.AirportUpdateDto;
import com.example.airport.exception.AirportNotFoundException;
import com.example.airport.repository.AirportRepository;
import com.example.airport.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{
  @Autowired
  private AirportRepository airportRepository;

  private ModelMapper modelMapper;

  public AirportServiceImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public AirportDto findById(int id) {
    Optional<Airport> airport = airportRepository.findById(id);

    if (!airport.isPresent()){
      throw new AirportNotFoundException(id);
    }

    return modelMapper.map(airport.get(), AirportDto.class);
  }

  @Override
  public List<AirportDto> findAll() {
    return airportRepository.findAll().stream().map((airport) -> modelMapper.map(airport, AirportDto.class)).toList();

  }
  @Override
  public AirportDto create(AirportCreateDto airportCreateDto) {
    Airport airport = modelMapper.map(airportCreateDto, Airport.class);
    airportRepository.create(airport);
    return modelMapper.map(airport, AirportDto.class);
  }

  @Override
  public AirportDto update(AirportUpdateDto airportUpdateDto) {
    Optional<Airport> airport = airportRepository.findById(airportUpdateDto.getId());

    if (!airport.isPresent()) {
      throw new AirportNotFoundException(airport.get().getId());
    }

    airport.get().setName(airportUpdateDto.getName());
    airport.get().setCity(airportUpdateDto.getCity());

    airportRepository.update(airport.get());

    return modelMapper.map(airport, AirportDto.class);
  }


}
