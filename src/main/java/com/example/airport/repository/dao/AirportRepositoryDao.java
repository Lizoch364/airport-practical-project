package com.example.airport.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.Airport;
import com.example.airport.domain.Ticket;
import com.example.airport.repository.AirportRepository;

@Repository
public class AirportRepositoryDao implements AirportRepository{
  @Autowired
  private BaseAirportRepository baseRepository;

  @Override
  public Optional<Airport> findById(int id) {
    return baseRepository.findById(id);
  }

  @Override
  public List<Airport> findAll() {
    return baseRepository.findAll();
  }

  @Override
  public Airport create(Airport airport) {
    return baseRepository.save(airport);
  }

  @Override
  public Airport update(Airport airport) {
    return baseRepository.save(airport);
  }

  @Override
  public Airport getDepartureAirportsByTicket (Ticket ticket){
   return baseRepository.getDepartureAirportsByTicket(ticket);
  }
}

@Repository
interface BaseAirportRepository extends JpaRepository<Airport, Integer>{
  @Query(value = "SELECT a FROM Airport a JOIN Flight f ON f.departureAirport = a JOIN f.tickets t WHERE :ticket = t")
  Airport getDepartureAirportsByTicket(@Param(value = "ticket") Ticket ticket);
}
