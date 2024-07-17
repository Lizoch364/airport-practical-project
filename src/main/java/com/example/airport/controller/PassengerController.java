package com.example.airport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.airport.dto.PassengerCreateDto;
import com.example.airport.dto.PassengerDto;
import com.example.airport.dto.PassengerUpdateDto;
import com.example.airport.service.PassengerService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
  @Autowired
  private PassengerService passengerService;

  @GetMapping("/{id}")
  public PassengerDto getById(@PathVariable int id){
    Optional<PassengerDto> passengerDto = passengerService.findById(id);
    return passengerDto.get();
  }

  @GetMapping("")
  public List<PassengerDto> getAll(){
    return passengerService.findAll();
  }

  @PostMapping("")
  public PassengerDto create(@RequestBody PassengerCreateDto passengerCreateDto){
    return passengerService.create(passengerCreateDto);
  }

  @PatchMapping("")
  public PassengerDto update(@RequestBody PassengerUpdateDto passengerUpdateDto){
    return passengerService.update(passengerUpdateDto);
  }

  @GetMapping("/passenger/{id}")
  public float getDiscountByPassenger(@PathVariable int id) {
      return passengerService.getDiscountByPassenger(id);
  }
}
