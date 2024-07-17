package com.example.airport.exception;

public abstract class CustomNotFoundException extends RuntimeException {
  protected CustomNotFoundException(String message) {
    super(message);
  }
}
