package com.example.airport.repository.dao;

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
  public void create(Passenger passenger) {
    baseRepository.save(passenger);
  }

  @Override
  public Optional<Passenger> findById(int id) {
    return baseRepository.findById(id);
  }
}

@Repository
interface BasePassengerRepository extends JpaRepository<Passenger, Integer>{}
