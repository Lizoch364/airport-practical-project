package com.example.airport.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Airport;
import com.example.airport.domain.BookedTicket;
import com.example.airport.domain.Flight;
import com.example.airport.domain.Passenger;
import com.example.airport.domain.TariffClass;
import com.example.airport.domain.Ticket;
import com.example.airport.dto.TicketCreateDto;
import com.example.airport.dto.TicketDto;
import com.example.airport.dto.TicketUpdateDto;
import com.example.airport.exception.AirportNotFoundException;
import com.example.airport.exception.BookedTicketNotFoundException;
import com.example.airport.exception.FlightNotFoundException;
import com.example.airport.exception.PassengerNotFoundException;
import com.example.airport.exception.TariffClassNotFoundException;
import com.example.airport.exception.TicketNotFoundException;
import com.example.airport.repository.TicketRepository;
import com.example.airport.repository.AirportRepository;
import com.example.airport.repository.BookedTicketRepository;
import com.example.airport.repository.FlightRepository;
import com.example.airport.repository.PassengerRepository;
import com.example.airport.repository.TariffClassRepository;
import com.example.airport.service.TicketDomainService;
import com.example.airport.utils.DatetimeUtils;

@Service
public class TicketDomainServiceImpl implements TicketDomainService {
  @Autowired
  private TicketRepository ticketRepository;

  @Autowired
  private AirportRepository airportRepository;

  @Autowired
  private TariffClassRepository tariffClassRepository;

  @Autowired
  private FlightRepository flightRepository;

  @Autowired
  private BookedTicketRepository bookedTicketRepository;

  @Autowired
  private PassengerRepository passengerRepository;

  private ModelMapper modelMapper;

  public TicketDomainServiceImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public TicketDto findById(int id) {
    Optional<Ticket> ticket = ticketRepository.findById(id);

    if(!ticket.isPresent()) {
      throw new TicketNotFoundException(id);
    }
    return modelMapper.map(ticket, TicketDto.class);
  }

  @Override
  public List<TicketDto> findAll() {
    return ticketRepository.findAll().stream().map((ticket) -> modelMapper.map(ticket, TicketDto.class)).toList();
  }

  @Override
  public TicketDto create(TicketCreateDto ticketCreateDto) {
    TariffClass tariffClass = tariffClassRepository.findById(ticketCreateDto.getTariffClass()).orElseThrow(() -> new TariffClassNotFoundException());
    Flight flight = flightRepository.findById(ticketCreateDto.getFlightId()).orElseThrow(() -> new FlightNotFoundException());

    Ticket ticket = new Ticket(flight, ticketCreateDto.getSeat(), ticketCreateDto.getPrice(), tariffClass);

    flight.getTickets().add(ticket);

    ticketRepository.create(ticket);

    return modelMapper.map(ticket, TicketDto.class);
  }

  @Override
  public TicketDto update(TicketUpdateDto ticketUpdateDto) {
    Optional<Ticket> ticket = ticketRepository.findById(ticketUpdateDto.getId());

    if (!ticket.isPresent()) {
      throw new TicketNotFoundException();
    }

    if (ticketUpdateDto.getTariffClass() != 0) {
      TariffClass tariffClass = tariffClassRepository.findById(ticketUpdateDto.getTariffClass()).orElseThrow(() -> new TariffClassNotFoundException());
      ticket.get().setTariffClass(tariffClass);
    }

    if (ticketUpdateDto.getFlight() != 0) {
      Flight flight = flightRepository.findById(ticketUpdateDto.getFlight()).orElseThrow(() -> new FlightNotFoundException());
      ticket.get().setFlight(flight);
    }

    if (ticketUpdateDto.getBookedTicket() != 0) {
      BookedTicket bookedTicket = bookedTicketRepository.findById(ticketUpdateDto.getBookedTicket()).orElseThrow(() -> new BookedTicketNotFoundException());
      ticket.get().setBookedTicket(bookedTicket);
    }

    ticket.get().setSeat(ticketUpdateDto.getSeat());
    ticket.get().setPrice(ticketUpdateDto.getPrice());

    ticketRepository.update(ticket.get());

    return modelMapper.map(ticket.get(), TicketDto.class);
  }

  @Override
  public List<TicketDto> getRecommendationsTickets(int passengerId) {
    Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException());
    Set<Ticket> tickets = ticketRepository.findTicketByPassenger(passenger);
    Set<Airport> airports = new HashSet<>();

    List<TicketDto> recommendationTickets = new ArrayList<>();

    for (Ticket ticket : tickets) {
      airports.add(airportRepository.getDepartureAirportsByTicket(ticket));
    }

    for (Airport airport : airports) {
      List<Ticket> recommendation = ticketRepository.findAllTicketsByDepartureAirport(airport);

      for (Ticket ticket : recommendation) {
        if (ticket.getBookedTicket() != null) {
          continue;
        }

        recommendationTickets.add(modelMapper.map(ticket, TicketDto.class));
      }
    }

    return recommendationTickets;
  }

  @Override
  public long getTimeBetweenAirports(int departureAirportId, int arrivalAirporId) {
    Airport departureAirport = airportRepository.findById(departureAirportId).orElseThrow(() -> new AirportNotFoundException());
    Airport arrivalAirport = airportRepository.findById(arrivalAirporId).orElseThrow(() -> new AirportNotFoundException());
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
}

