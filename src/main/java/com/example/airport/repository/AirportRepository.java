package com.example.airport.repository;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airport;
import com.example.airport.domain.Ticket;

@Repository
public interface AirportRepository{
  void create (Airport airport);
  Airport getDepartureAirportsByTicket (Ticket ticket);
}
