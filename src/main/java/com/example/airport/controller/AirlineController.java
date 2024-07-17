package com.example.airport.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airport.dto.AirlineCreateDto;
import com.example.airport.dto.AirlineDto;
import com.example.airport.dto.AirlineUpdateDto;
import com.example.airport.service.AirlineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/airlines")
@RestController
public class AirlineController {
  @Autowired
  private AirlineService airlineService;

  @GetMapping("/{id}")
  public AirlineDto getById(@PathVariable int id){
    return airlineService.findById(id);
  }

  @GetMapping("")
  public List<AirlineDto> getAll(){
    return airlineService.findAll();
  }

  @PostMapping("")
  public AirlineDto create(@RequestBody AirlineCreateDto airlineCreateDto){
    return airlineService.create(airlineCreateDto);
  }

  @PatchMapping("")
  public AirlineDto update(@RequestBody AirlineUpdateDto airlineUpdateDto){
    return airlineService.update(airlineUpdateDto);
  }
}
