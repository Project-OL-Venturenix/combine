package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class InvalidQuestionIdInputException extends BusinessRuntimeException {

  public InvalidQuestionIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
