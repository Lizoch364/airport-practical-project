package com.example.airport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.BookedTicket;
import com.example.airport.domain.Ticket;

@Repository
public interface BookedTicketRepository {
  Optional<BookedTicket> findById(int id);
  List<BookedTicket> findAll();
  BookedTicket create(BookedTicket bookedTicket);
  BookedTicket update(BookedTicket bookedTicket);
  Optional<BookedTicket> findByTicket(Ticket ticket);
}
