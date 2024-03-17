package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class InvalidTestCaseIdInputException extends BusinessRuntimeException {

  public InvalidTestCaseIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
