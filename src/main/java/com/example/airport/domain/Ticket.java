package com.example.airport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {
  private TariffClass tariffClass;
  private Flight flight;
  private String seat;
  private double price;
  private BookedTicket bookedTicket;

  public Ticket (Flight flight, String seat, double price) {
    this.tariffClass = TariffClass.BASIC;
    this.flight = flight;
    this.seat = seat;
    this.price = price;
    this.bookedTicket = null;
  }

  protected Ticket () {}

  @Column(name = "tariff_class")
  @Enumerated(EnumType.ORDINAL)
  public TariffClass getTariffClass() {
    return tariffClass;
  }

  @ManyToOne
  @JoinColumn(name = "flight")
  public Flight getFlight() {
    return flight;
  }

  @Column(name = "seat")
  public String getSeat() {
    return seat;
  }

  @Column(name = "price")
  public double getPrice() {
    return price;
  }

  @OneToOne
  @JoinColumn(name = "booked_ticket")
  public BookedTicket getBookedTicket() {
    return bookedTicket;
  }

  public void setTariffClass(TariffClass tariffClass) {
    this.tariffClass = tariffClass;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public void setSeat(String seat) {
    this.seat = seat;
  }

  public void setPrice(double price) {
    if (price >= 0) {
      this.price = price;
    }
  }

  public void setBookedTicket(BookedTicket bookedTicket) {
    this.bookedTicket = bookedTicket;
  }
}
