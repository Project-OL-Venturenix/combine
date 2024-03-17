package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class InvalidGroupIdInputException extends BusinessRuntimeException {

  public InvalidGroupIdInputException(Syscode Syscode) {
    super(Syscode);
  }

}
