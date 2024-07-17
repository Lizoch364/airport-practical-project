package com.example.airport.exception;

public class TicketNotFoundException extends CustomNotFoundException {
  public TicketNotFoundException (int id) {
    super("Ticket id = " + id + " not found");
  }

  public TicketNotFoundException () {
    super("Ticket not found");
  }
}
