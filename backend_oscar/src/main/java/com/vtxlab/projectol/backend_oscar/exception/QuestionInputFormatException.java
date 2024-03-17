package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class QuestionInputFormatException extends BusinessRuntimeException {

  public QuestionInputFormatException(Syscode Syscode) {
    super(Syscode);
  }

}
