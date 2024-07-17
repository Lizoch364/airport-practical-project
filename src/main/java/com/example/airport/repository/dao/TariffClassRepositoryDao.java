package com.example.airport.repository.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airport.domain.TariffClass;
import com.example.airport.repository.TariffClassRepository;

@Repository
public class TariffClassRepositoryDao implements TariffClassRepository{
  @Autowired
  private BaseTariffClassRepository baseRepository;
  
  @Override
  public Optional<TariffClass> findById(int id) {
    return baseRepository.findById(id);
  }
}

@Repository
interface BaseTariffClassRepository extends JpaRepository<TariffClass, Integer>{
}

