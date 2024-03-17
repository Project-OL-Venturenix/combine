package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class InvalidDateInputException extends BusinessRuntimeException {

  public InvalidDateInputException(Syscode Syscode) {
    super(Syscode);
  }

}
