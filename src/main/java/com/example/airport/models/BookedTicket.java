package com.example.airport.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booked_ticket")
public class BookedTicket extends BaseEntity{
  private Ticket _ticket;
  private Passenger _passenger;
  private BookingStatus _status = BookingStatus.CREATED;
  private Date _bookedAt;
  private Date _updatedAt;

  public BookedTicket(Ticket ticket, Passenger passenger) {
    _ticket = ticket;
    _passenger = passenger;
    _status = BookingStatus.CREATED;
    _bookedAt = new Date();
    _updatedAt = new Date();
  }

  protected BookedTicket() {}

  @OneToOne
  @JoinColumn (name = "ticket")
  public Ticket getTicket() {
    return _ticket;
  }

  @ManyToOne
  @JoinColumn(name = "passenger")
  public Passenger getPassenger() {
    return _passenger;
  }

  @ManyToOne
  @JoinColumn(name = "status")
  public BookingStatus getStatus() {
    return _status;
  }

  @Column(name = "booked_at")
  public Date getBookedAt() {
    return _bookedAt;
  }

  @Column(name = "update_at")
  public Date getUpdatedAt() {
    return _updatedAt;
  }
}
