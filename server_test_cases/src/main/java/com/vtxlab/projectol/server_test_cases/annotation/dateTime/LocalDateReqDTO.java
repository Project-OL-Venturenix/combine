package com.vtxlab.projectol.server_test_cases.annotation.dateTime;

import java.time.LocalDate;
import com.vtxlab.projectol.server_test_cases.annotation.Symbol.SymbolCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocalDateReqDTO {
    @SymbolCheck
    String symbol;

    LocalDate symbolDate;
}
