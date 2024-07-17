package com.example.airport.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
  private int id;
  private int airline;
  private int departureAirport;
  private Date departureDateTime;
  private int arrivalAirport;
  private Date arrivalDateTime;
}
