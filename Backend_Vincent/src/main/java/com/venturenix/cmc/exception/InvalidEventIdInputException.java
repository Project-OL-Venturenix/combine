package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class InvalidEventIdInputException extends BusinessRuntimeException {

  public InvalidEventIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
