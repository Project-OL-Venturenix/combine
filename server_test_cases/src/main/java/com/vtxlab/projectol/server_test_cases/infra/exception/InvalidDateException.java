package com.vtxlab.projectol.server_test_cases.infra.exception;

import com.vtxlab.projectol.server_test_cases.infra.exception.setting.Code;

public class InvalidDateException extends BussinessRuntimeException {

  public InvalidDateException(Code code) {
    super(code);
  }
}
