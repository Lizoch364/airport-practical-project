package com.example.airport.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport extends BaseEntity{
  private String _name;
  private String _city;
  private List<Airline> _airlines;

  public Airport(String name, String city, List<Airline> airlines) {
    _name = name;
    _city = city;
    _airlines = airlines;
  }

  protected Airport(){}

  @Column(name = "name")
  public String getName() {
    return _name;
  }

  @Column(name = "city")
  public String getCity() {
    return _city;
  }

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "airline")
  public List<Airline> getAirlines() {
    return _airlines;
  }
}
