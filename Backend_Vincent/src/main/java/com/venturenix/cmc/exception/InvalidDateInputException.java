package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class InvalidDateInputException extends BusinessRuntimeException {

  public InvalidDateInputException(Syscode Syscode) {
    super(Syscode);
  }

}
