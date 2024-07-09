package com.example.airport.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport_airlines")
public class AirportAirline extends BaseEntity{
  private Airline _airline;
  private Airport _airport;

  public AirportAirline(Airline airline, Airport airport) {
    _airline = airline;
    _airport = airport;
  }

  @ManyToOne
  @JoinColumn(name = "airline")
  public Airline getAirline() {
    return _airline;
  }

  @ManyToOne
  @JoinColumn(name = "airport")
  public Airport getAirport() {
    return _airport;
  }
}
