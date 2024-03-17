package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class InvalidEventIdInputException extends BusinessRuntimeException {

  public InvalidEventIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
