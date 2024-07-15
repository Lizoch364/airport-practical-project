package com.example.airport.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Airport;
import com.example.airport.domain.Passenger;
import com.example.airport.domain.Ticket;
import com.example.airport.repository.TicketRepository;
import com.example.airport.repository.AirportRepository;

import com.example.airport.service.TicketDomainService;
import com.example.airport.utils.DatetimeUtils;

@Service
public class TicketDomainServiceImpl implements TicketDomainService {
  @Autowired
  private TicketRepository ticketRepository;

  @Autowired
  private AirportRepository airportRepository;

  @Override
  public long getTimeBetweenAirports(Airport departureAirport, Airport arrivalAirport) {
    List<Ticket> tickets = ticketRepository.findAllTicketsByAirports(departureAirport, arrivalAirport);
    long time = 0;

    for (Ticket ticket : tickets) {
      time += DatetimeUtils.getDifferenceInMinutes(
        ticket.getFlight().getArrivalDateTime(),
        ticket.getFlight().getDepartureDateTime()
      );
    }

    return time / tickets.size();
  }

  @Override
  public Optional<Ticket> findById(int id) {
    return ticketRepository.findById(id);
  }

  @Override
  public void create(Ticket ticket) {
    ticketRepository.create(ticket);
  }

  @Override
  public List<Ticket> getRecommendationsTickets(Passenger passenger) {
    Set<Ticket> tickets = ticketRepository.findTicketByPassenger(passenger);
    Set<Airport> airports = new TreeSet<>();
    List<Ticket> recommendationTickets = new ArrayList<>();

    for (Ticket ticket : tickets) {
      airports.add(airportRepository.getDepartureAirportsByTicket(ticket));
    }

    for (Airport airport : airports) {
      List<Ticket> recommendation = ticketRepository.findAllTicketsByDepartureAirport(airport);

      for (Ticket ticket : recommendation) {
        recommendationTickets.add(ticket);
      }
    }
    
    return recommendationTickets;
  }
}

