package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;
import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException {
  private Syscode Syscode;

  public BusinessRuntimeException(Syscode Syscode) {
    super(Syscode.getMessage());
    this.Syscode = Syscode;
  }

}
