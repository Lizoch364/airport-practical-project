package com.example.airport.repository;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.BookedTicket;

@Repository
public interface BookedTicketRepository {
  void create(BookedTicket bookedTicket);
}
