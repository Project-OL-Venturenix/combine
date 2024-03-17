package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class InvalidGroupIdInputException extends BusinessRuntimeException {

  public InvalidGroupIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
