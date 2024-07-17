package com.example.airport.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.airport.domain.TariffClass;

@Repository
public interface TariffClassRepository {
  Optional<TariffClass> findById(int id);
}
