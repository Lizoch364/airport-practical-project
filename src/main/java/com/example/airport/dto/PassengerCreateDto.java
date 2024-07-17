package com.example.airport.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerCreateDto {
  @NotNull(message = "Please provide passenger first name")
  @NotEmpty(message = "Line length should be > 0")
  private String firstName;

  @NotNull(message = "Please provide passenger middle name")
  @NotEmpty(message = "Line length should be > 0")
  private String middleName;

  @NotNull(message = "Please provide passenger last name")
  @NotEmpty(message = "Line length should be > 0")
  private String lastName;

  @NotNull(message = "Please provide passenger passport")
  @NotEmpty(message = "Line length should be > 0")
  private String passport;

  @NotNull(message = "Please provide passenger date of birth")
  private Date dateOfBirth;
}
