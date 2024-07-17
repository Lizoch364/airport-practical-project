package com.example.airport.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketCreateDto {
  @NotNull(message = "Please provide ticket tariff class")
  private int tariffClass;

  @NotNull(message = "Please provide flight id ")
  private int flightId;

  @NotNull(message = "Please provide ticket seat")
  @NotEmpty(message = "Line length should be > 0")
  private String seat;

  @NotNull(message = "Please provide ticket price")
  private double price;
}
