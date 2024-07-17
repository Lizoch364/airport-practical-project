package com.example.airport.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import com.example.airport.domain.BookedTicket;
import com.example.airport.domain.Flight;
import com.example.airport.domain.Ticket;
import com.example.airport.dto.BookedTicketDto;
import com.example.airport.dto.FlightDto;
import com.example.airport.dto.TicketDto;

public class Mapper {
  private static ModelMapper modelMapperInstance;

  public static ModelMapper getModelMapper() {
    if (modelMapperInstance == null) {
      modelMapperInstance = new Mapper().createMapper(new ModelMapper());
    }

    return modelMapperInstance;
  }

  private ModelMapper createMapper(ModelMapper modelMapper) {
    TypeMap<Flight, FlightDto> flightToDto = modelMapper.createTypeMap(Flight.class, FlightDto.class);

    flightToDto.addMappings(mapper -> {
      mapper.map(flight -> flight.getAirline().getId(), FlightDto::setAirline);
      mapper.map(flight -> flight.getDepartureAirport().getId(), FlightDto::setDepartureAirport);
      mapper.map(flight -> flight.getDepartureDateTime(), FlightDto::setDepartureDateTime);
      mapper.map(flight -> flight.getArrivalAirport().getId(), FlightDto::setArrivalAirport);
      mapper.map(flight -> flight.getArrivalDateTime(), FlightDto::setArrivalDateTime);
      mapper.map(flight -> flight.getAirline().getId(), FlightDto::setAirline);
    });

    TypeMap<Ticket, TicketDto> ticketToDto = modelMapper.createTypeMap(Ticket.class, TicketDto.class);

    ticketToDto.addMappings(mapper -> {
      mapper.map(ticket -> ticket.getTariffClass().getId(), TicketDto::setTariffClass);
      mapper.map(ticket -> ticket.getFlight().getId(), TicketDto::setFlight);
      mapper.map(ticket -> ticket.getSeat(), TicketDto::setSeat);
      mapper.map(ticket -> ticket.getPrice(), TicketDto::setPrice);
      mapper.map(ticket -> ticket.getBookedTicket().getId(), TicketDto::setBookedTicket);
    });

    TypeMap<BookedTicket, BookedTicketDto> bookedTicketToDto = modelMapper.createTypeMap(BookedTicket.class, BookedTicketDto.class);

    bookedTicketToDto.addMappings(mapper -> {
      mapper.map(bookedTicket -> bookedTicket.getPassenger().getId(), BookedTicketDto::setPassengerId);
      mapper.map(bookedTicket -> bookedTicket.getTicket().getId(), BookedTicketDto::setTicketId);
    });

    return modelMapper;
  }
}
