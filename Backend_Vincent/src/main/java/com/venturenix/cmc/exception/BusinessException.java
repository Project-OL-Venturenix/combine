package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;
import lombok.Getter;

@Getter
public class BusinessException extends Exception {
  private Syscode Syscode;

  public BusinessException(Syscode Syscode) {
    super(Syscode.getMessage());
    this.Syscode = Syscode;
  }
}
