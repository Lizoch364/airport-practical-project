package com.example.airport.repository.dao;

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
  public void create(Airport airport) {
    baseRepository.save(airport);
  }

  @Override
  public Airport getDepartureAirportsByTicket (Ticket ticket){
   return baseRepository.getDepartureAirportsByTicket(ticket);
  }
}

@Repository
interface BaseAirportRepository extends JpaRepository<Airport, Integer>{
  @Query(value = "select f.departureAirport from Flight as f join Ticket where :ticket in f.tickets")
  Airport getDepartureAirportsByTicket(@Param(value = "ticket") Ticket ticket);
}
