package com.example.airport.service;

import com.example.airport.domain.Passenger;

public interface PassengerService {
  void create(Passenger passenger);
  float getDiscountByPassenger(Passenger passenger);
}
