package com.example.airport.exception;

public class FlightNotFoundException extends CustomNotFoundException {
  public FlightNotFoundException (int id){
    super("Flight id = " + id + " not found");
  }

  public FlightNotFoundException (){
    super("Flight not found");
  }
}
