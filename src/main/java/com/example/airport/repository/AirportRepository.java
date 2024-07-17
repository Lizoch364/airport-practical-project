package com.example.airport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airport;
import com.example.airport.domain.Ticket;

@Repository
public interface AirportRepository{
  Optional<Airport> findById(int id);
  List<Airport> findAll();
  Airport create(Airport airport);
  Airport update(Airport airport);
  Airport getDepartureAirportsByTicket (Ticket ticket);
}
