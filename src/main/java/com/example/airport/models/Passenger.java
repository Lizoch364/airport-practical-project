package com.example.airport.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger extends BaseEntity{
  private String _firstName;
  private String _middleName;
  private String _lastName;
  private String _passport;

  public Passenger(String firstName, String middleName, String lastName, String passport) {
    _firstName = firstName;
    _middleName = middleName;
    _lastName = lastName;
    _passport = passport;
  }

  protected Passenger() {}

  @Column(name = "first_name")
  public String getFirstName() {
    return _firstName;
  }

  @Column(name = "middle_name")
  public String getMiddleName() {
    return _middleName;
  }

  @Column(name = "last_name")
  public String getLastName() {
    return _lastName;
  }

  @Column(name = "passport")
  public String getPassport() {
    return _passport;
  }
}
