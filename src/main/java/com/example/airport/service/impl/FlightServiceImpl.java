package com.example.airport.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Airline;
import com.example.airport.domain.Airport;
import com.example.airport.domain.Flight;
import com.example.airport.dto.FlightCreateDto;
import com.example.airport.dto.FlightDto;
import com.example.airport.dto.FlightUpdateDto;
import com.example.airport.exception.AirlineNotFoundException;
import com.example.airport.exception.AirportNotFoundException;
import com.example.airport.exception.FlightNotFoundException;
import com.example.airport.repository.AirlineRepository;
import com.example.airport.repository.AirportRepository;
import com.example.airport.repository.FlightRepository;
import com.example.airport.repository.TicketRepository;
import com.example.airport.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
  @Autowired
  private FlightRepository flightRepository;
  @Autowired
  private AirlineRepository airlineRepository;
  @Autowired
  private AirportRepository airportRepository;
  @Autowired
  private TicketRepository ticketRepository;

  private ModelMapper modelMapper;

  public FlightServiceImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public FlightDto findById(int id) {
    Optional<Flight> flight = flightRepository.findById(id);

    if (!flight.isPresent()){
      throw new FlightNotFoundException(id);
    }

    return modelMapper.map(flight, FlightDto.class);
  }

  @Override
  public List<FlightDto> findAll() {
    return flightRepository.findAll().stream().map((flight) -> modelMapper.map(flight, FlightDto.class)).toList();
  }

  @Override
  public FlightDto create(FlightCreateDto flightCreateDto) {
    Airline airline = airlineRepository.findById(flightCreateDto.getAirlineId()).orElseThrow(() -> new AirlineNotFoundException());
    Airport departureAirport = airportRepository.findById(flightCreateDto.getDepartureAirportId()).orElseThrow(() -> new AirlineNotFoundException());
    Airport arrivalAirport = airportRepository.findById(flightCreateDto.getArrivalAirportId()).orElseThrow(() -> new AirlineNotFoundException());

    Flight flight = new Flight(airline, departureAirport, flightCreateDto.getDepartureDateTime(), arrivalAirport, flightCreateDto.getArrivalDateTime());
    flightRepository.create(flight);

    return modelMapper.map(flight, FlightDto.class);
  }

  @Override
  public FlightDto update(FlightUpdateDto flightUpdateDto) {
    Optional<Flight> flight = flightRepository.findById(flightUpdateDto.getId());

    if (!flight.isPresent()) {
      throw new FlightNotFoundException();
    }

    if(flightUpdateDto.getAirlineId() != 0) {
      Airline airline = airlineRepository.findById(flightUpdateDto.getAirlineId()).orElseThrow(() -> new AirlineNotFoundException(flightUpdateDto.getAirlineId()));
      flight.get().setAirline(airline);
    }

    if (flightUpdateDto.getDepartureAirportId() != 0) {
      Airport departureAirport = airportRepository.findById(flightUpdateDto.getDepartureAirportId()).orElseThrow(() -> new AirportNotFoundException(flightUpdateDto.getDepartureAirportId()));
      flight.get().setDepartureAirport(departureAirport);
    }

    if (flightUpdateDto.getArrivalAirportId() != 0) {
      Airport arrivalAirport = airportRepository.findById(flightUpdateDto.getArrivalAirportId()).orElseThrow(() -> new AirportNotFoundException(flightUpdateDto.getArrivalAirportId()));
      flight.get().setArrivalAirport(arrivalAirport);
    }


    flight.get().setDepartureDateTime(flightUpdateDto.getDepartureDateTime());
    flight.get().setArrivalDateTime(flightUpdateDto.getArrivalDateTime());
    flightRepository.update(flight.get());

    return modelMapper.map(flight, FlightDto.class);
  }
}
