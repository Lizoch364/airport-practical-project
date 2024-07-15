package com.example.airport.service.sale;

import com.example.airport.domain.Passenger;
public abstract class DiscountCounter {
  public static final float DEFAULT_DISCOUNT = 0f;

  private float discountRate;

  protected DiscountCounter(float discountRate) {
      this.discountRate = discountRate;
  }

  public abstract boolean canGetDiscount(Passenger passenger);

  public float countDiscountRate(Passenger passenger) {
      if (canGetDiscount(passenger)) {
          return getCurrentDiscountRate();
      }

      return DEFAULT_DISCOUNT;
  }

  protected float getCurrentDiscountRate() {
      return discountRate;
  }
}
