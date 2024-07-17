package com.example.airport.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airport.dto.AirportCreateDto;
import com.example.airport.dto.AirportDto;
import com.example.airport.dto.AirportUpdateDto;
import com.example.airport.service.AirportService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/airports")
@RestController
public class AirportController {
  @Autowired
  private AirportService airportService;

  @GetMapping("/{id}")
  public AirportDto getBuId(@PathVariable int id) {
    return airportService.findById(id);
  }

  @GetMapping("")
  public List<AirportDto> getAll(){
    return airportService.findAll();
  }

  @PostMapping("")
  public AirportDto create(@RequestBody AirportCreateDto airportCreateDto) {
    return airportService.create(airportCreateDto);
  }

  @PatchMapping("")
  public AirportDto update(@RequestBody AirportUpdateDto airportUpdateDto) {
    return airportService.update(airportUpdateDto);
  }
}
