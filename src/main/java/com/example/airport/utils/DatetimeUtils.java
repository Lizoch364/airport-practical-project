package com.example.airport.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatetimeUtils {
  public static long getDifferenceInYears(Date firstDate, Date secondDate) {
      return Math.abs(ChronoUnit.YEARS.between(
          convertToLocalDate(firstDate),
          convertToLocalDate(secondDate)
      ));
  }
  public static long getDifferenceInMinutes(Date firstDate, Date secondDate) {
    return TimeUnit.MILLISECONDS.toMinutes(Math.abs(firstDate.getTime() - secondDate.getTime()));
}

  private static LocalDate convertToLocalDate(Date dateToConvert) {
      return dateToConvert.toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
  }
}

