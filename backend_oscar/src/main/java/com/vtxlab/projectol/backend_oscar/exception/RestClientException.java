package com.vtxlab.projectol.backend_oscar.exception;

import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;
import lombok.Getter;

@Getter
public class RestClientException extends BusinessException {
  private Syscode Syscode;

  public RestClientException(Syscode Syscode) {
    super(Syscode);
    this.Syscode = Syscode;
  }
}
