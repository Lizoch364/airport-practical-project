package com.example.airport.service;

import java.util.List;
import java.util.Optional;

import com.example.airport.dto.PassengerCreateDto;
import com.example.airport.dto.PassengerDto;
import com.example.airport.dto.PassengerUpdateDto;

public interface PassengerService {
  Optional<PassengerDto> findById(int id);
  List<PassengerDto> findAll();
  PassengerDto create(PassengerCreateDto passengerDto);
  PassengerDto update(PassengerUpdateDto passengerUpdateDto);
  float getDiscountByPassenger(int idPassenger);
}
