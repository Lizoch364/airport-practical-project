package com.example.airport.dto;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.NotFound;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightUpdateDto {
  @NotNull(message = "Please provide flight id")
  private int id;
  private int airlineId;
  private int departureAirportId;
  private Date departureDateTime;
  private int arrivalAirportId;
  private Date arrivalDateTime;
}
