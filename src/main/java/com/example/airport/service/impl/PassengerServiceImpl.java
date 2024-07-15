package com.example.airport.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Passenger;
import com.example.airport.repository.PassengerRepository;
import com.example.airport.service.PassengerService;
import com.example.airport.service.sale.Discount;

@Service
public class PassengerServiceImpl implements PassengerService{
  @Autowired
  private PassengerRepository passengerRepository;

  @Override
  public void create(Passenger passenger) {
    passengerRepository.create(passenger);
  }

  @Override
  public float getDiscountByPassenger(Passenger passenger){
  return Discount.getInstance().findDiscountRateForPassenger(passenger);
  }
}
