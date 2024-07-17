package com.example.airport.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketUpdateDto {
  @NotNull(message = "Please provide ticket id")
  private int id;
  private int tariffClass;
  private int flight;
  private String seat;
  private double price;
  private int bookedTicket;
}
