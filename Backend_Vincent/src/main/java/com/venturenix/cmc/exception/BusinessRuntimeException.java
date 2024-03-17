package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;
import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException {
  private Syscode Syscode;

  public BusinessRuntimeException(Syscode Syscode) {
    super(Syscode.getMessage());
    this.Syscode = Syscode;
  }

}
