package com.example.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
  private int id;
  private int tariffClass;
  private int flight;
  private String seat;
  private double price;
  private int bookedTicket;
}
