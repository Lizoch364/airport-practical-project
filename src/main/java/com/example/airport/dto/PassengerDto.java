package com.example.airport.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String passport;
  private Date dateOfBirth;
}

