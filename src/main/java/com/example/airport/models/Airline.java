package com.example.airport.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline extends BaseEntity{
  private String _name;

  public Airline(String name){
    _name = name;
  }

  protected Airline() {}

  @Column(name = "name")
  public String getName() {
    return _name;
  }
}
