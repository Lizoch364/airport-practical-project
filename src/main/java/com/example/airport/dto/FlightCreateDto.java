package com.example.airport.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class FlightCreateDto {
  @NotNull(message = "Please provide airline id")
  private int airlineId;

  @NotNull(message = "Please provide departure airport id")
  private int departureAirportId;

  @NotNull(message = "Please provide flight departure date time")
  private Date departureDateTime;

  @NotNull(message = "Please provide arrival airport id")
  private int arrivalAirportId;

  @NotNull(message = "Please provide flight arrival date time")
  private Date arrivalDateTime;
}
