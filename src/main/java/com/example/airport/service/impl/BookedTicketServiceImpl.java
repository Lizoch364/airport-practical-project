package com.example.airport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.BookedTicket;
import com.example.airport.repository.BookedTicketRepository;
import com.example.airport.service.BookedTicketService;

@Service
public class BookedTicketServiceImpl implements BookedTicketService{
  @Autowired
  private BookedTicketRepository bookedTicketRepository;

  @Override
  public void create(BookedTicket bookedTicket) {
    bookedTicketRepository.create(bookedTicket);
  }
}
