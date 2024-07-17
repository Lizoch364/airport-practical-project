package com.example.airport.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.BookedTicket;
import com.example.airport.domain.Ticket;
import com.example.airport.repository.BookedTicketRepository;

@Repository
public class BookedTicketDao implements BookedTicketRepository{
  @Autowired
  private BaseBookedTicketRepository baseRepository;

  @Override
  public Optional<BookedTicket> findById(int id) {
    return baseRepository.findById(id);
  }

  @Override
  public List<BookedTicket> findAll() {
    return baseRepository.findAll();
  }

  @Override
  public BookedTicket create(BookedTicket bookedTicket) {
    return baseRepository.save(bookedTicket);
  }

  @Override
  public BookedTicket update(BookedTicket bookedTicket) {
    return baseRepository.save(bookedTicket);
  }

  @Override
  public Optional<BookedTicket> findByTicket(Ticket ticket) {
    return baseRepository.findByTicket(ticket);
  }
}

@Repository
interface BaseBookedTicketRepository extends JpaRepository<BookedTicket, Integer> {
  @Query(value = "SELECT b FROM BookedTicket b JOIN Ticket t WHERE b.ticket = ticket")
  Optional<BookedTicket> findByTicket(@Param(value = "ticket") Ticket ticket);
}
