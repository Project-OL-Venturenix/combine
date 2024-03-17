package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class InvalidUserIdInputException extends BusinessRuntimeException {

  public InvalidUserIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
