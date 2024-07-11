package com.example.airport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport_airlines")
public class AirportAirline extends BaseEntity{
  private Airline airline;
  private Airport airport;

  public AirportAirline(Airline airline, Airport airport) {
    this.airline = airline;
    this.airport = airport;
  }

  @ManyToOne
  @JoinColumn(name = "airline")
  public Airline getAirline() {
    return airline;
  }

  @ManyToOne
  @JoinColumn(name = "airport")
  public Airport getAirport() {
    return airport;
  }
}
