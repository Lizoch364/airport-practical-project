package com.example.airport.service.sale;

import java.util.Date;

import com.example.airport.domain.Passenger;
import com.example.airport.utils.DatetimeUtils;

public class YouthDiscountCounter extends DiscountCounter {
  public YouthDiscountCounter() {
      super(0.08f);
  }

  @Override
  public boolean canGetDiscount(Passenger passenger) {
      return DatetimeUtils.getDifferenceInYears(new Date(), passenger.getDateOfBirth()) < 18;
  }
}
