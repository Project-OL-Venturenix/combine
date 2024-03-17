package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class InvalidUserIdInputException extends BusinessRuntimeException {

  public InvalidUserIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
