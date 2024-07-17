package com.example.airport.controller.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.airport.exception.CustomNotFoundException;

@ControllerAdvice
public class NotFoundExceptionAdvice {
  @ResponseBody
  @ExceptionHandler(CustomNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)

  public String badRequestHandler(CustomNotFoundException exception) {
    return exception.getMessage();
  }
}
