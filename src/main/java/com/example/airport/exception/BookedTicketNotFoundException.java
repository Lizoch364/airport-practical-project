package com.example.airport.exception;

public class BookedTicketNotFoundException extends RuntimeException{
  public BookedTicketNotFoundException(int id) {
    super("Booked ticket id = " + id + " not found");
  }

  public BookedTicketNotFoundException() {
    super("Booked ticket not found");
  }
}
