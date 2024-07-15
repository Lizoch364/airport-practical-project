package com.example.airport.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.BookedTicket;
import com.example.airport.repository.BookedTicketRepository;

@Repository
public class BookedTicketDao implements BookedTicketRepository{
  @Autowired
  private BaseBookedTicketRepository baseRepository;

  @Override
  public void create(BookedTicket bookedTicket) {
    baseRepository.save(bookedTicket);
  }
}

interface BaseBookedTicketRepository extends JpaRepository<BookedTicket, Integer> {}
