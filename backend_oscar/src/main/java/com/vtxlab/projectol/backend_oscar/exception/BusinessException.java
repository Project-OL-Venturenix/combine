package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;
import lombok.Getter;

@Getter
public class BusinessException extends Exception {
  private Syscode Syscode;

  public BusinessException(Syscode Syscode) {
    super(Syscode.getMessage());
    this.Syscode = Syscode;
  }
}
