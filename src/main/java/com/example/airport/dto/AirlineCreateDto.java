package com.example.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirlineCreateDto {
  @NotNull(message = "Please provide airline name")
  @NotEmpty(message = "Line length should be > 0")
  private String name;
}
