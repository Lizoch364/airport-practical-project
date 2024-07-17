package com.example.airport.exception;

public class PassengerNotFoundException extends CustomNotFoundException {
  public PassengerNotFoundException(int id) {
    super("Passenger id = " + id + " not found");
  }

  public PassengerNotFoundException() {
    super("Passenger not found");
  }
}
