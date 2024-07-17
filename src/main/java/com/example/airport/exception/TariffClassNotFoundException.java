package com.example.airport.exception;

public class TariffClassNotFoundException extends CustomNotFoundException {
  public TariffClassNotFoundException(int id) {
    super("Tariff class id = " + id + " not found");
  }

  public TariffClassNotFoundException() {
    super("Tariff class not found");
  }
}
