package com.vtxlab.projectol.server_test_cases.infra.exception;

import com.vtxlab.projectol.server_test_cases.infra.exception.setting.Code;

public class BussinessRuntimeException extends RuntimeException {

  private Code code;

  public int getCode() {
    return this.code.getCode();
  }

  public BussinessRuntimeException(Code code) {
    super(code.getDesc());
    this.code = code;
  }
}
