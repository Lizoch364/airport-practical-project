package com.example.airport.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight extends BaseEntity{
  private Airline airline;
  private Airport departureAirport;
  private Date departureDateTime;
  private Airport arrivalAirport;
  private Date arrivalDateTime;
  private List<Ticket> tickets;

  public Flight(Airline airline, Airport departureAirport, Date departureDateTime, Airport arrivalAirport, Date arrivalDateTime) {
    this.airline = airline;
    this.departureAirport = departureAirport;
    this.departureDateTime = departureDateTime;
    this.arrivalAirport = arrivalAirport;
    this.arrivalDateTime = arrivalDateTime;
    this.tickets = new ArrayList<>();
  }

  public Flight(Airline airline, Airport departureAirport, Date departureDateTime, Airport arrivalAirport, Date arrivalDateTime, List<Ticket> tickets) {
    this(airline, departureAirport, departureDateTime, arrivalAirport, arrivalDateTime);
    this.tickets = tickets;
  }

  protected Flight(){}

  @ManyToOne
  @JoinColumn(name = "airline")
  public Airline getAirline() {
    return airline;
  }

  @ManyToOne
  @JoinColumn(name = "departure_airport")
  public Airport getDepartureAirport() {
    return departureAirport;
  }

  @Column(name = "departure_date")
  public Date getDepartureDateTime() {
    return departureDateTime;
  }

  @ManyToOne
  @JoinColumn(name = "arrival_airport")
  public Airport getArrivalAirport() {
    return arrivalAirport;
  }

  @Column(name = "arrival_date")
  public Date getArrivalDateTime() {
    return arrivalDateTime;
  }

  @OneToMany(fetch = FetchType.LAZY)
  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setAirline(Airline airline) {
    if (airline != null) {
      this.airline = airline;
    }
  }

  public void setDepartureAirport(Airport departureAirport) {
    if (departureAirport != null) {
      this.departureAirport = departureAirport;
    }
  }

  public void setDepartureDateTime(Date departureDateTime) {
    if (departureDateTime != null){
      this.departureDateTime = departureDateTime;
    }
  }

  public void setArrivalAirport(Airport arrivalAirport) {
    if (arrivalAirport != null) {
      this.arrivalAirport = arrivalAirport;
    }
  }

  public void setArrivalDateTime(Date arrivalDateTime) {
    if (arrivalDateTime != null) {
      this.arrivalDateTime = arrivalDateTime;
    }
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}
