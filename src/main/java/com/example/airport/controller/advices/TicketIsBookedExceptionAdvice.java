package com.example.airport.controller.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;

import com.example.airport.exception.TicketIsBookedException;

@ControllerAdvice
public class TicketIsBookedExceptionAdvice {
  @ResponseBody
  @ExceptionHandler(TicketIsBookedException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String ticketIsBooked( TicketIsBookedException exception) {
    return exception.getMessage();
  }
}
