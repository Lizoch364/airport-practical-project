package com.example.airport.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity{
  private TariffClass _tariffClass;
  private Flight _flight;
  private String _seat;
  private double _price;
  private BookedTicket _bookedTicket;

  public Ticket (Flight flight, String seat, double price) {
    _tariffClass = TariffClass.BASIC;
    _flight = flight;
    _seat = seat;
    _price = price;
    _bookedTicket = null;
  }

  protected Ticket () {}

  @ManyToOne
  @JoinColumn(name = "tariff_class")
  public TariffClass getTariffClass() {
    return _tariffClass;
  }

  @ManyToOne
  @JoinColumn(name = "flight")
  public Flight getFlight() {
    return _flight;
  }

  @Column(name = "seat")
  public String getSeat() {
    return _seat;
  }

  @Column(name = "price")
  public double getPrice() {
    return _price;
  }

  @OneToOne
  @JoinColumn(name = "booked_ticket")
  public BookedTicket getBookedTicket() {
    return _bookedTicket;
  }
}
