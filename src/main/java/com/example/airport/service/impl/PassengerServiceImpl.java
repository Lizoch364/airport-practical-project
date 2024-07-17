package com.example.airport.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airport.domain.Passenger;
import com.example.airport.dto.PassengerCreateDto;
import com.example.airport.dto.PassengerDto;
import com.example.airport.dto.PassengerUpdateDto;
import com.example.airport.exception.PassengerNotFoundException;
import com.example.airport.repository.PassengerRepository;
import com.example.airport.service.PassengerService;
import com.example.airport.service.sale.Discount;

@Service
public class PassengerServiceImpl implements PassengerService {
  @Autowired
  private PassengerRepository passengerRepository;
  
  private ModelMapper modelMapper;

  public PassengerServiceImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public Optional<PassengerDto> findById(int id) {
    Optional<Passenger> passenger = passengerRepository.findById(id);

    if(!passenger.isPresent()){
      throw new PassengerNotFoundException(passenger.get().getId());
    }
    return Optional.of(modelMapper.map(passenger, PassengerDto.class));
  }

  @Override
  public List<PassengerDto> findAll() {
    return passengerRepository.findAll().stream().map((passenger) -> modelMapper.map(passenger, PassengerDto.class)).toList();
  }

  @Override
  public PassengerDto create(PassengerCreateDto passengerDto) {
    Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
    passengerRepository.create(passenger);
    return modelMapper.map(passenger, PassengerDto.class);
  }

  @Override
  public PassengerDto update(PassengerUpdateDto passengerUpdateDto) {
    Optional<Passenger> passenger = passengerRepository.findById(passengerUpdateDto.getId());

    if(!passenger.isPresent()) {
      throw new PassengerNotFoundException(passenger.get().getId());
    }

    passenger.get().setFirstName(passengerUpdateDto.getFirstName());
    passenger.get().setMiddleName(passengerUpdateDto.getMiddleName());
    passenger.get().setLastName(passengerUpdateDto.getLastName());
    passenger.get().setPassport(passengerUpdateDto.getPassport());
    passenger.get().setDateOfBirth(passengerUpdateDto.getDateOfBirth());

    passengerRepository.update(passenger.get());
    return modelMapper.map(passenger, PassengerDto.class);
  }

  @Override
  public float getDiscountByPassenger(int idPassenger){
    Optional<Passenger> passenger = passengerRepository.findById(idPassenger);

    if (!passenger.isPresent()){
      throw new PassengerNotFoundException(idPassenger);
    }

    return Discount.getInstance().findDiscountRateForPassenger(passenger.get());
  }
}
