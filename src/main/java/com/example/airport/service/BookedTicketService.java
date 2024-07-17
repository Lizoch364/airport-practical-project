package com.example.airport.service;

import java.util.List;

import com.example.airport.dto.BookedTicketCreateDto;
import com.example.airport.dto.BookedTicketDto;
import com.example.airport.dto.BookedTicketUpdateDto;

public interface BookedTicketService {
  BookedTicketDto findById(int id);
  List<BookedTicketDto> findAll();
  BookedTicketDto create(BookedTicketCreateDto bookedTicketCreateDto);
  BookedTicketDto update(BookedTicketUpdateDto bookedTicketUpdateDto);
}
