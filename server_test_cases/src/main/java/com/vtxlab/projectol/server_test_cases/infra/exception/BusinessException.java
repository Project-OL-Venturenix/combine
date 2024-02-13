package com.vtxlab.projectol.server_test_cases.infra.exception;

import com.vtxlab.projectol.server_test_cases.infra.exception.setting.Code;

public class BusinessException extends Exception {

  private Code code;

  public int getCode() {
    return this.code.getCode();
  }
  
  public BusinessException(Code code) {
    super(code.getDesc());
    this.code = code;
  }

}
