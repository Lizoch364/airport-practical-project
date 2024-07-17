package com.example.airport.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerUpdateDto {
  @NotNull(message = "Please provide passenger id")
  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String passport;
  private Date dateOfBirth;
}
