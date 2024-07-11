package com.example.airport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
  private int id;

  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }
}
