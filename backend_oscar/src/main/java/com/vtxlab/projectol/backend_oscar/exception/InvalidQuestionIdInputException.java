package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class InvalidQuestionIdInputException extends BusinessRuntimeException {

  public InvalidQuestionIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
