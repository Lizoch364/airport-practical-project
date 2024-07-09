package com.example.airport.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport extends BaseEntity{
  private String _name;
  private String _city;

  public Airport(String name, String city) {
    _name = name;
    _city = city;
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
}
