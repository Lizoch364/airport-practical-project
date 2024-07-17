// package com.example.airport.service.impl;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.airport.domain.TariffClass;
// import com.example.airport.exception.TariffClassNotFoundException;
// import com.example.airport.repository.TariffClassRepository;
// import com.example.airport.service.TariffClassService;

// @Service
// public class TariffClassServiceImpl implements TariffClassService{
//   @Autowired
//   private TariffClassRepository tariffClassRepository;

//   @Override
//   public TariffClass findById(int id) {
//     Optional<TariffClass> tariffClass = tariffClassRepository.findById(id);

//     if(!tariffClass.isPresent()) {
//       throw new TariffClassNotFoundException(id);
//     }

//     return tariffClass.get();
//   }
// }
