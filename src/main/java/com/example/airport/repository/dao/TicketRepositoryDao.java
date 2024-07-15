package com.example.airport.repository.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airport;
import com.example.airport.domain.Passenger;
import com.example.airport.domain.Ticket;
import com.example.airport.repository.TicketRepository;

@Repository
public class TicketRepositoryDao implements TicketRepository {
  @Autowired
  private BaseTicketRepository baseRepository;

  @Override
  public Optional<Ticket> findById(int id) {
    return baseRepository.findById(id);
  }

  @Override
  public List<Ticket> findAll() {
    return baseRepository.findAll();
  }

  @Override
  public void create(Ticket ticket) {
    baseRepository.save(ticket);
  }

  @Override
  public void deleteById(int id) {
    baseRepository.deleteById(id);
  }

  @Override
  public List<Ticket> findAllTicketsByAirports(Airport departureAirport, Airport arrivalAirport) {
    return baseRepository.findAllTicketsByAirports(departureAirport, arrivalAirport);
  }

  @Override
  public List<Ticket> findAllTicketsByDepartureAirport(Airport departureAirport) {
    return baseRepository.findAllTicketsByDepartureAirport(departureAirport);
  }

  @Override
  public List<Ticket> findAllTicketsByArrivalAirport(Airport arrivalAirport) {
    return baseRepository.findAllTicketsByArrivalAirport(arrivalAirport);
  }

  @Override
  public Set<Ticket> findTicketByPassenger(Passenger passenger) {
    return baseRepository.findTicketByPassenger(passenger);
  }
}

@Repository
interface BaseTicketRepository extends JpaRepository<Ticket, Integer>{
  @Query(value = "select t from Ticket t join t.flight as f where (f.departureAirport = :departureAirport and f.arrivalAirport = :arrivalAirport)")
  List<Ticket> findAllTicketsByAirports(@Param(value = "departureAirport") Airport departureAirport, @Param(value = "arrivalAirport") Airport arrivalAirport);

  @Query(value = "select t from Ticket t join t.flight as f where f.departureAirport = :departureAirport")
  List<Ticket> findAllTicketsByDepartureAirport(@Param(value = "departureAirport") Airport departureAirport);

  @Query(value = "select t from Ticket t join t.flight as f where f.arrivalAirport = :arrivalAirport")
  List<Ticket> findAllTicketsByArrivalAirport(@Param(value = "arrivalAirport") Airport arrivalAirport);

  @Query(value = "select t from Ticket as t join BookedTicket as b where b.passenger = passenger")
  Set<Ticket> findTicketByPassenger(@Param(value = "passenger") Passenger passenger);
}
