package com.vtxlab.projectol.server_test_cases.annotation.Symbol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class SymbolReqDTO {
  @SymbolCheck
  String symbol;

}
