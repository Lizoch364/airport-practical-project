package com.example.airport.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.airport.dto.TicketCreateDto;
import com.example.airport.dto.TicketDto;
import com.example.airport.dto.TicketUpdateDto;
import com.example.airport.service.TicketDomainService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
  @Autowired
  private TicketDomainService ticketService;

  @GetMapping("/{id}")
  public TicketDto getById(@PathVariable int id) {
    return ticketService.findById(id);
  }

  @GetMapping("")
  public List<TicketDto> getAll() {
      return ticketService.findAll();
  }

  @PostMapping("")
  public TicketDto create(@RequestBody TicketCreateDto ticketCreateDto) {
    return ticketService.create(ticketCreateDto);
  }

  @PatchMapping
  public TicketDto update(@RequestBody TicketUpdateDto ticketUpdateDto) {
    return ticketService.update(ticketUpdateDto);
  }

  @GetMapping("/timeBetweenAirport")
  public long getTimeBetweenAirports(@RequestParam(name = "departureAirportId") int departureAirportId, @RequestParam(name = "arrivalAirportId") int arrivalAirportId) {
      return ticketService.getTimeBetweenAirports(departureAirportId, arrivalAirportId);
  }

  @GetMapping("/recommendation/{passengerId}")
  public List<TicketDto> getRecommendationsTickets(@PathVariable int passengerId) {
      return ticketService.getRecommendationsTickets(passengerId);
  }
}
