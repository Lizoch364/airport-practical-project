package com.example.airport.service.sale;

import java.util.Date;

import com.example.airport.domain.Passenger;
import com.example.airport.utils.DatetimeUtils;

public class ElderlyDiscountCounter extends DiscountCounter {
  public ElderlyDiscountCounter() {
      super(0.1f);
  }

  public boolean canGetDiscount(Passenger passenger) {
      return DatetimeUtils.getDifferenceInYears(new Date(), passenger.getDateOfBirth()) > 65;
  }
}
