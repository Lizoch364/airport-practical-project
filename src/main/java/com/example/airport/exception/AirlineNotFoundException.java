package com.example.airport.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AirlineNotFoundException extends CustomNotFoundException {
  public AirlineNotFoundException(int id){
    super("Airline id = " + id + " not found");
  }

  public AirlineNotFoundException(){
    super("Airline not found");
  }
}
