package com.example.airport.service.sale;

import java.util.ArrayList;
import java.util.List;

import com.example.airport.domain.Passenger;

public class Discount {
  private static Discount INSTANCE;

  private List<DiscountCounter> discounts;

  public static Discount getInstance() {
      if (INSTANCE == null) {
          INSTANCE = new Discount();
      }

      return INSTANCE;
  }

  private Discount() {
      discounts = new ArrayList<>();
  }

  public void addDiscount(DiscountCounter discount) {
      discounts.add(discount);
  }

  public float findDiscountRateForPassenger(Passenger passenger) {
      for (var discount : discounts) {
          if (discount.canGetDiscount(passenger)) {
              return discount.countDiscountRate(passenger);
          }
      }

      return DiscountCounter.DEFAULT_DISCOUNT;
  }
}
