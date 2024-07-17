package com.example.airport.service;

import java.util.List;

import com.example.airport.dto.TicketCreateDto;
import com.example.airport.dto.TicketDto;
import com.example.airport.dto.TicketUpdateDto;

public interface TicketDomainService {
  long getTimeBetweenAirports (int departureAirportId, int arrivalAirportId);
  List<TicketDto> getRecommendationsTickets (int passengerId);
  TicketDto findById (int id);
  List<TicketDto> findAll();
  TicketDto update(TicketUpdateDto ticketUpdateDto);
  TicketDto create (TicketCreateDto ticketCreateDto);
}
