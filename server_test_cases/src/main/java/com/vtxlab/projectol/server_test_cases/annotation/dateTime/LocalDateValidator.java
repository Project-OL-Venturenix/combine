package com.vtxlab.projectol.server_test_cases.annotation.dateTime;

import java.time.LocalDate;
import java.util.Objects;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LocalDateValidator
    implements ConstraintValidator<LocalDateCheck, LocalDateReqDTO> {


  @Override
  public boolean isValid(LocalDateReqDTO date,
      ConstraintValidatorContext context) {
    String symbol = date.getSymbol();
    if (Objects.isNull(symbol))
      return false;

    date.setSymbolDate(LocalDate.parse(symbol));
    return true;
  }
}

