package com.example.airport.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookedTicketUpdateDto {
  @NotNull(message = "Please provide booked ticket id")
  private int id;
  private int ticketId;
  private int passengerId;
}
