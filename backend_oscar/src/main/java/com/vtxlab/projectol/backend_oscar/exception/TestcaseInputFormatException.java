package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;

public class TestcaseInputFormatException extends BusinessRuntimeException {

  public TestcaseInputFormatException(Syscode Syscode) {
    super(Syscode);
  }

}
