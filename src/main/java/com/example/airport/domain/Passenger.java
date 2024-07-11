package com.example.airport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger extends BaseEntity{
  private String firstName;
  private String middleName;
  private String lastName;
  private String passport;

  public Passenger(String firstName, String middleName, String lastName, String passport) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.passport = passport;
  }

  protected Passenger() {}

  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "middle_name")
  public String getMiddleName() {
    return middleName;
  }

  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  @Column(name = "passport")
  public String getPassport() {
    return passport;
  }
}
