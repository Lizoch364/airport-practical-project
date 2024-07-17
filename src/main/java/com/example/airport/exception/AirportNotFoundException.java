package com.example.airport.exception;

public class AirportNotFoundException extends CustomNotFoundException {
  public AirportNotFoundException(int id) {
    super("Airport id = " + id + " not found");
  }

  public AirportNotFoundException() {
    super("Airport not found");
  }
}
