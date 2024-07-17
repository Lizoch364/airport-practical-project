package com.example.airport.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.BookedTicket;
import com.example.airport.domain.Passenger;
import com.example.airport.domain.Ticket;
import com.example.airport.dto.BookedTicketCreateDto;
import com.example.airport.dto.BookedTicketDto;
import com.example.airport.dto.BookedTicketUpdateDto;
import com.example.airport.exception.TicketIsBookedException;
import com.example.airport.exception.BookedTicketNotFoundException;
import com.example.airport.exception.PassengerNotFoundException;
import com.example.airport.exception.TicketNotFoundException;
import com.example.airport.repository.BookedTicketRepository;
import com.example.airport.repository.PassengerRepository;
import com.example.airport.repository.TicketRepository;
import com.example.airport.service.BookedTicketService;

@Service
public class BookedTicketServiceImpl implements BookedTicketService{
  @Autowired
  private BookedTicketRepository bookedTicketRepository;

  @Autowired
  private PassengerRepository passengerRepository;

  @Autowired
  private TicketRepository ticketRepository;

  private ModelMapper modelMapper;

  public BookedTicketServiceImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public BookedTicketDto findById(int id) {
    Optional<BookedTicket> bookedTicket = bookedTicketRepository.findById(id);

    if (!bookedTicket.isPresent()){
      throw new BookedTicketNotFoundException(id);
    }

    return modelMapper.map(bookedTicket.get(), BookedTicketDto.class);
  }

  @Override
  public List<BookedTicketDto> findAll() {
    return bookedTicketRepository.findAll().stream().map((bookedTicket) -> modelMapper.map(bookedTicket, BookedTicketDto.class)).toList();
  }

  @Override
  public BookedTicketDto create(BookedTicketCreateDto bookedTicketCreateDto) {
    Passenger passenger = passengerRepository.findById(bookedTicketCreateDto.getPassengerId()).orElseThrow(() -> new PassengerNotFoundException());
    Ticket ticket = ticketRepository.findById(bookedTicketCreateDto.getTicketId()).orElseThrow(() -> new TicketNotFoundException());

    if(ticket.getBookedTicket() != null){
      throw new TicketIsBookedException();
    }

    BookedTicket bookedTicket = new BookedTicket(ticket, passenger);
    bookedTicket.setBookedAt(new Date());

    bookedTicketRepository.create(bookedTicket);

    ticket.setBookedTicket(bookedTicket);
    ticketRepository.update(ticket);

    return modelMapper.map(bookedTicket, BookedTicketDto.class);
  }

  @Override
  public BookedTicketDto update(BookedTicketUpdateDto bookedTicketUpdateDto) {
    Optional<BookedTicket> bookedTicket = bookedTicketRepository.findById(bookedTicketUpdateDto.getId());

    if (!bookedTicket.isPresent()) {
      throw new BookedTicketNotFoundException();
    }

    if (bookedTicketUpdateDto.getPassengerId() != 0) {
      Passenger passenger = passengerRepository.findById(bookedTicketUpdateDto.getPassengerId()).orElseThrow(() -> new PassengerNotFoundException());
      bookedTicket.get().setPassenger(passenger);
    }

    if (bookedTicketUpdateDto.getTicketId() != 0) {
      Ticket ticket = ticketRepository.findById(bookedTicketUpdateDto.getTicketId()).orElseThrow(() -> new TicketNotFoundException());
      bookedTicket.get().setTicket(ticket);
    }

    bookedTicketRepository.update(bookedTicket.get());

    return modelMapper.map(bookedTicket.get(), BookedTicketDto.class);
  }
}
