package com.venturenix.cmc.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.venturenix.cmc.exception.ApiResp;
import com.venturenix.cmc.exception.BusinessException;
import com.venturenix.cmc.exception.BusinessRuntimeException;
import com.venturenix.cmc.exception.InvalidEventIdInputException;
import com.venturenix.cmc.exception.InvalidGroupIdInputException;
import com.venturenix.cmc.exception.InvalidQuestionIdInputException;
import com.venturenix.cmc.exception.InvalidTestCaseIdInputException;
import com.venturenix.cmc.exception.InvalidUserIdInputException;
import com.venturenix.cmc.exception.QuestionInputFormatException;
import com.venturenix.cmc.exception.RestClientException;
import com.venturenix.cmc.exception.TestcaseInputFormatException;
import com.venturenix.cmc.exception.exceptionEnum.Syscode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = RestClientException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE) // 503
  public ApiResp<Void> bc2311ExceptionHandler(RestClientException e) {
    return ApiResp.<Void>builder() //
        .Syscode(e.getSyscode().getSyscode()) //
        .message(e.getMessage())//
        // .data(null) //
        .build();
  }


  @ExceptionHandler(value = BusinessException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> bc2311ExceptionHandler(BusinessException e) {
    return ApiResp.<Void>builder() //
        .Syscode(e.getSyscode().getSyscode()) //
        .message(e.getMessage())//
        // .data(null) //
        .build();
  }

  @ExceptionHandler(value = BusinessRuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> runtimeExceptionHandler(BusinessRuntimeException e) {
    return ApiResp.<Void>builder() //
        .Syscode(getRespCode(e).getSyscode()) //
        .message(e.getMessage())//
        // .data(null) //
        .build();
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> exceptionHandler(Exception e) {
    return ApiResp.<Void>builder() //
        .Syscode(Syscode.INVALID_OPERATION.getSyscode()) //
        .message(e.getMessage())//
        // .data(null) //
        .build();
  }

  private static Syscode getRespCode(Exception e) {

    if (e instanceof IllegalArgumentException) {
      return Syscode.INVALID_OPERATION;
    }
    if (e instanceof InvalidEventIdInputException) {
      return Syscode.INVALID_EVENT_ID_INPUT;
    }
    if (e instanceof InvalidGroupIdInputException) {
      return Syscode.INVALID_GROUP_ID_INPUT;
    }
    if (e instanceof InvalidQuestionIdInputException) {
      return Syscode.INVALID_QUESTION_ID_INPUT;
    }
    if (e instanceof InvalidTestCaseIdInputException) {
      return Syscode.INVALID_TESTECASE_ID_INPUT;
    }
    if (e instanceof InvalidUserIdInputException) {
      return Syscode.INVALID_USER_ID_INPUT;
    }
    if (e instanceof TestcaseInputFormatException) {
      return Syscode.INVALID_TESTCASE_FORMAT_INPUT;
    }
    if (e instanceof QuestionInputFormatException) {
      return Syscode.INVALID_QUESTION_FORMAT_INPUT;
    }
    // return null;
    return Syscode.INVALID_OPERATION;
  }
}
