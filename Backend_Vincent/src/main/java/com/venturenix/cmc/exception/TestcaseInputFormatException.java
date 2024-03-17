package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class TestcaseInputFormatException extends BusinessRuntimeException {

  public TestcaseInputFormatException(Syscode Syscode) {
    super(Syscode);
  }

}
