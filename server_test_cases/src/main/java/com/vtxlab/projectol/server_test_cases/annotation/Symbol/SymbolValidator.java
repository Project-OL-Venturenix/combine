package com.vtxlab.projectol.server_test_cases.annotation.Symbol;

import java.util.Objects;
// import com.hkjava.demo.demofinnhubdb.config.AppStartRunner;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SymbolValidator implements ConstraintValidator<SymbolCheck, SymbolReqDTO> {

  @Override
  public boolean isValid(SymbolReqDTO symbol,
      ConstraintValidatorContext context) {
    return Objects.nonNull(symbol.getSymbol());
        // && AppStartRunner.availableStockList.contains(symbol.getSymbol());
  }

}
