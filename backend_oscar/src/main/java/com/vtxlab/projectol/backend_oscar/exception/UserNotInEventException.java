package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class UserNotInEventException extends BusinessRuntimeException {

  public UserNotInEventException(Syscode Syscode) {
    super(Syscode);
  }

}
