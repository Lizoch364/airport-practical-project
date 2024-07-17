package com.example.airport.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booked_ticket")
public class BookedTicket extends BaseEntity{
  private Ticket ticket;
  private Passenger passenger;
  private Date bookedAt;

  public BookedTicket(Ticket ticket, Passenger passenger) {
    this.ticket = ticket;
    this.passenger = passenger;
    this.bookedAt = new Date();
  }

  protected BookedTicket() {}

  @OneToOne
  @JoinColumn (name = "ticket")
  public Ticket getTicket() {
    return ticket;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "passenger")
  public Passenger getPassenger() {
    return passenger;
  }

  @Column(name = "booked_at")
  public Date getBookedAt() {
    return bookedAt;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  public void setBookedAt(Date bookedAt) {
    this.bookedAt = bookedAt;
  }
}
