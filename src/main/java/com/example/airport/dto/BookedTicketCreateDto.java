package com.example.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookedTicketCreateDto {
  @NotNull(message = "Please provide ticket id")
  private int ticketId;

  @NotNull(message = "Please provide passenger id")
  private int passengerId;
}
