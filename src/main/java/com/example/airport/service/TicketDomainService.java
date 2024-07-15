package com.example.airport.service;

import java.util.List;
import java.util.Optional;

import com.example.airport.domain.Airport;
import com.example.airport.domain.Passenger;
import com.example.airport.domain.Ticket;

public interface TicketDomainService {
  long getTimeBetweenAirports (Airport departureAirport, Airport arrivalAirport);
  List<Ticket> getRecommendationsTickets (Passenger passenger);
  Optional<Ticket> findById (int id);
  void create (Ticket ticket);
}
