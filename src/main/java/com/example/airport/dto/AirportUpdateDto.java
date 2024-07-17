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
public class AirportUpdateDto {
  @NotNull(message = "Please provide airport id")
  private int id;
  private String name;
  private String city;
}
