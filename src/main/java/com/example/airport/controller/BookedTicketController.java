package com.example.airport.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.airport.dto.BookedTicketCreateDto;
import com.example.airport.dto.BookedTicketDto;
import com.example.airport.dto.BookedTicketUpdateDto;
import com.example.airport.service.BookedTicketService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/bookedTickets")
public class BookedTicketController {
  @Autowired
  private BookedTicketService bookedTicketService;

  @GetMapping("{id}")
  public BookedTicketDto getById(@PathVariable int id) {
      return bookedTicketService.findById(id);
  }

  @GetMapping("")
  public List<BookedTicketDto> getAll() {
      return bookedTicketService.findAll();
  }

  @PostMapping("")
  public BookedTicketDto create(@RequestBody BookedTicketCreateDto bookedTicketCreateDto) {
      return bookedTicketService.create(bookedTicketCreateDto);
  }

  @PatchMapping("")
  public BookedTicketDto update(@RequestBody BookedTicketUpdateDto bookedTicketCreateDto) {
    return bookedTicketService.update(bookedTicketCreateDto);
  }
}
