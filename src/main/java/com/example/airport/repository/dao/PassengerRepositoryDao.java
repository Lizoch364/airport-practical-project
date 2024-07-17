package com.example.airport.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.Passenger;
import com.example.airport.repository.PassengerRepository;

@Repository
public class PassengerRepositoryDao implements PassengerRepository {
  @Autowired
  private BasePassengerRepository baseRepository;

  @Override
  public Optional<Passenger> findById(int id) {
    return baseRepository.findById(id);
  }

  @Override
  public List<Passenger> findAll() {
    return baseRepository.findAll();
  }

  @Override
  public Passenger create(Passenger passenger) {
    return baseRepository.save(passenger);
  }

  @Override
  public Passenger update(Passenger passenger) {
    return baseRepository.save(passenger);
  }
}

@Repository
interface BasePassengerRepository extends JpaRepository<Passenger, Integer>{}
