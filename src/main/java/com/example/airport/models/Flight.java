package com.example.airport.models;

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
  private Airline _airline;
  private Airport _departureAirport;
  private Date _departureDateTime;
  private Airport _arrivalAirport;
  private Date _arrivalDateTime;
  private List<Ticket> _tickets;

  public Flight(Airline airline, Airport departureAirport, Date departureDateTime, Airport arrivalAirport, Date arrivalDateTime, List<Ticket> tickets) {
    _airline = airline;
    _departureAirport = departureAirport;
    _departureDateTime = departureDateTime;
    _arrivalAirport = arrivalAirport;
    _arrivalDateTime = arrivalDateTime;
    _tickets = tickets;
  }

  protected Flight(){}

  @ManyToOne
  @JoinColumn(name = "airline")
  public Airline getAirline() {
    return _airline;
  }

  @ManyToOne
  @JoinColumn(name = "departure_airport")
  public Airport getDepartureAirport() {
    return _departureAirport;
  }

  @Column(name = "departure_date")
  public Date getDepartureDateTime() {
    return _departureDateTime;
  }

  @ManyToOne
  @JoinColumn(name = "arrival_airport")
  public Airport getArrivalAirport() {
    return _arrivalAirport;
  }

  @Column(name = "arrival_date")
  public Date getArrivalDateTime() {
    return _arrivalDateTime;
  }

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "tickets")
  public List<Ticket> getTickets() {
    return _tickets;
  }
}
