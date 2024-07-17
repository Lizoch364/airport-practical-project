package com.example.airport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tariff_class")
public class TariffClass extends BaseEntity{
  private String name;

  @JoinColumn(name = "name")
  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }
}
