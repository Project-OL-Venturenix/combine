package com.vtxlab.projectol.server_test_cases.infra.exception.handler;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.projectol.server_test_cases.infra.exception.BusinessException;
import com.vtxlab.projectol.server_test_cases.infra.exception.BussinessRuntimeException;
import com.vtxlab.projectol.server_test_cases.infra.exception.setting.ApiResp;
import com.vtxlab.projectol.server_test_cases.infra.exception.setting.Code;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // @ExceptionHandler(value = BusinessException.class)
  // @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  // public ApiResp<Void> projectOLExceptionHandler(BusinessException e) {
  //   return ApiResp.<Void>builder() //
  //       .status(Code.fromCode(e.getCode())) //
  //       .concatMessageIfPresent(e.getMessage())//
  //       .build();
  // }

  // @ExceptionHandler(value = BussinessRuntimeException.class)
  // @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
  // public ApiResp<Void> projectOLExceptionHandler(BussinessRuntimeException e) {
  //   return ApiResp.<Void>builder() //
  //       .status(Code.fromCode(e.getCode())) //
  //       .concatMessageIfPresent(e.getMessage())//
  //       .build();
  // }

  // @ExceptionHandler(value = IOException.class)
  // @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
  // public ApiResp<Void> projectOLExceptionHandler(IOException e) {
  //   return ApiResp.<Void>builder() //
  //       .status(Code.fromCode(e.getCode())) //
  //       .concatMessageIfPresent(e.getMessage())//
  //       .build();
  // }

  // @ExceptionHandler(value = InterruptedException.class)
  // @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
  // public ApiResp<Void> projectOLExceptionHandler(InterruptedException e) {
  //   return ApiResp.<Void>builder() //
  //       .status(Code.fromCode(e.getCode())) //
  //       .concatMessageIfPresent(e.getMessage())//
  //       .build();
  // }

  // @ExceptionHandler(value = RuntimeException.class)
  // @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  // public ApiResp<Void> runtimeExceptionHandler(RuntimeException e) {
  //   return ApiResp.<Void>builder() //
  //       .status(getRespCode(e)) //
  //       .concatMessageIfPresent(e.getMessage())//
  //       .build();
  // }

  // @ExceptionHandler(value = Exception.class)
  // @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  // public ApiResp<Void> exceptionHandler(Exception e) {
  //   return ApiResp.<Void>builder() //
  //       .status(getRespCode(e)) //
  //       .concatMessageIfPresent(e.getMessage())//
  //       .build();
  // }

  private static Code getRespCode(Exception e) {
    if (e instanceof IllegalArgumentException) {
      return Code.IAE_EXCEPTION;
    }
    if (e instanceof NoSuchElementException) {
      return Code.NOT_FOUND;
    }
    return Code.FAIL;
  }
}
