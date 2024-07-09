package com.example.airport.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline extends BaseEntity{
  private String _name;
  private List<Airport> _airports;

  public Airline(String name, List<Airport> airports){
    _name = name;
    _airports = airports;
  }

  protected Airline() {}

  @Column(name = "name")
  public String getName() {
    return _name;
  }

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "airports")
  public List<Airport> getAirports() {
    return _airports;
  }
}
