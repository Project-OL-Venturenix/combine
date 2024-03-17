package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;

public class QuestionInputFormatException extends BusinessRuntimeException {

  public QuestionInputFormatException(Syscode Syscode) {
    super(Syscode);
  }

}
