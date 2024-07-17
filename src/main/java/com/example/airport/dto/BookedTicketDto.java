package com.example.airport.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookedTicketDto {
  private int ticketId;
  private int passengerId;
  private Date bookedAt;
}
