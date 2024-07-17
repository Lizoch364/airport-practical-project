package com.example.airport.exception;

public class TicketIsBookedException extends RuntimeException {
  public TicketIsBookedException() {
    super("Ticket is already booked");
  }
}
