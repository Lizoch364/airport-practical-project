package com.example.airport.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
  private BookingStatus status;
  private Date bookedAt;
  private Date updatedAt;

  public BookedTicket(Ticket ticket, Passenger passenger) {
    this.ticket = ticket;
    this.passenger = passenger;
    this.status = BookingStatus.CREATED;
    this.bookedAt = new Date();
    this.updatedAt = new Date();
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

  @Column(name = "status")
  @Enumerated(EnumType.ORDINAL)
  public BookingStatus getStatus() {
    return status;
  }

  @Column(name = "booked_at")
  public Date getBookedAt() {
    return bookedAt;
  }

  @Column(name = "update_at")
  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }

  public void setBookedAt(Date bookedAt) {
    this.bookedAt = bookedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
