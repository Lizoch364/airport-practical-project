package com.example.airport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline extends BaseEntity{
  private String name;

  public Airline(String name){
    this.name = name;
  }

  protected Airline() {}

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    if(name != null) {
      this.name = name;
    }
  }
}
