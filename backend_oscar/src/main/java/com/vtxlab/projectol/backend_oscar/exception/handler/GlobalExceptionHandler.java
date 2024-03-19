package com.vtxlab.projectol.backend_oscar.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.projectol.backend_oscar.exception.ApiResp;
import com.vtxlab.projectol.backend_oscar.exception.BusinessException;
import com.vtxlab.projectol.backend_oscar.exception.BusinessRuntimeException;
import com.vtxlab.projectol.backend_oscar.exception.InvalidEventIdInputException;
import com.vtxlab.projectol.backend_oscar.exception.InvalidGroupIdInputException;
import com.vtxlab.projectol.backend_oscar.exception.InvalidQuestionIdInputException;
import com.vtxlab.projectol.backend_oscar.exception.InvalidTestCaseIdInputException;
import com.vtxlab.projectol.backend_oscar.exception.InvalidUserIdInputException;
import com.vtxlab.projectol.backend_oscar.exception.QuestionInputFormatException;
import com.vtxlab.projectol.backend_oscar.exception.RestClientException;
import com.vtxlab.projectol.backend_oscar.exception.TestcaseInputFormatException;
import com.vtxlab.projectol.backend_oscar.exception.UserNotInEventException;
import com.vtxlab.projectol.backend_oscar.exception.exceptionEnum.Syscode;
import io.jsonwebtoken.JwtException;

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

  @ExceptionHandler(value = JwtException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> JwtExceptionHandler(JwtException e) {
    return ApiResp.<Void>builder() //
        .Syscode(Syscode.INVALID_OPERATION.getSyscode()) //
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
    if (e instanceof UserNotInEventException) {
      return Syscode.USER_NOT_IN_EVENT;
    }
    // return null;
    return Syscode.INVALID_OPERATION;
  }
}
