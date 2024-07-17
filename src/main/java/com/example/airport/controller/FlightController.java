package com.example.airport.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.airport.dto.FlightCreateDto;
import com.example.airport.dto.FlightDto;
import com.example.airport.dto.FlightUpdateDto;
import com.example.airport.service.FlightService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
  @Autowired
  private FlightService flightService;

  @GetMapping("/{id}")
  public FlightDto getById(@PathVariable int id){
    return flightService.findById(id);
  }

  @GetMapping("")
  public List<FlightDto> getAll(){
    return flightService.findAll();
  }

  @PostMapping("")
  public FlightDto create(@RequestBody FlightCreateDto flightCreateDto) {
    return flightService.create(flightCreateDto);
  }

  @PatchMapping("")
  public FlightDto update(@RequestBody FlightUpdateDto flightUpdateDto) {
    return flightService.update(flightUpdateDto);
  }
}
