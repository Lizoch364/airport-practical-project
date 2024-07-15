package com.example.airport.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airport;
import com.example.airport.domain.Passenger;
import com.example.airport.domain.Ticket;

@Repository
public interface TicketRepository {
  Optional<Ticket> findById(int id);
  List<Ticket> findAll();
  void create(Ticket ticket);
  void deleteById(int id);
  List<Ticket> findAllTicketsByAirports(Airport departureAirport, Airport arrivalAirport);
  List<Ticket> findAllTicketsByDepartureAirport(Airport departureAirport);
  List<Ticket> findAllTicketsByArrivalAirport(Airport arrivalAirport);
  Set<Ticket> findTicketByPassenger(Passenger passenger);
}
