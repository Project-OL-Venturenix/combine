package com.venturenix.cmc.exception;

import com.venturenix.cmc.exception.exceptionEnum.Syscode;
import lombok.Getter;

@Getter
public class RestClientException extends BusinessException {
  private Syscode Syscode;

  public RestClientException(Syscode Syscode) {
    super(Syscode);
    this.Syscode = Syscode;
  }
}
