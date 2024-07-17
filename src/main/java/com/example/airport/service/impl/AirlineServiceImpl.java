package com.example.airport.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Airline;
import com.example.airport.dto.AirlineCreateDto;
import com.example.airport.dto.AirlineDto;
import com.example.airport.dto.AirlineUpdateDto;
import com.example.airport.exception.AirlineNotFoundException;
import com.example.airport.repository.AirlineRepository;
import com.example.airport.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {
  @Autowired
  private AirlineRepository airlineRepository;

  private ModelMapper modelMapper;

  public AirlineServiceImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public AirlineDto findById(int id) {
    Optional<Airline> airline = airlineRepository.findById(id);

    if(!airline.isPresent()){
      throw new AirlineNotFoundException(airline.get().getId());
    }

    return modelMapper.map(airline, AirlineDto.class);
  }

  @Override
  public List<AirlineDto> findAll() {
    return airlineRepository.findAll().stream().map((airline) -> modelMapper.map(airline, AirlineDto.class)).toList();
  }

  @Override
  public AirlineDto create(AirlineCreateDto airlineCreateDto) {
    Airline airline = modelMapper.map(airlineCreateDto, Airline.class);
    airlineRepository.create(airline);

    return modelMapper.map(airline, AirlineDto.class);
  }

  @Override
  public AirlineDto update(AirlineUpdateDto airlineUpdateDto) {
    Optional<Airline> airline = airlineRepository.findById(airlineUpdateDto.getId());

    if(!airline.isPresent()){
      throw new AirlineNotFoundException(airline.get().getId());
    }

    airline.get().setName(airlineUpdateDto.getName());
    airlineRepository.update(airline.get());

    return modelMapper.map(airline, AirlineDto.class);
  }
}
