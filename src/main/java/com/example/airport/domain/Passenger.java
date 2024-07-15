package com.example.airport.domain;

import java.util.Date;

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
  private Date dateOfBirth;

  public Passenger(String firstName, String middleName, String lastName, String passport, Date dateOfBirth) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.passport = passport;
    this.dateOfBirth = dateOfBirth;
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

  @Column(name = "date_of_birth")
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
