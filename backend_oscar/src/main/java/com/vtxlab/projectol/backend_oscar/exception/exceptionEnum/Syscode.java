package com.vtxlab.projectol.backend_oscar.exception.exceptionEnum;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK"), //
  INVALID_EVENT_ID_INPUT("9", "Invalid event input"), //
  INVALID_GROUP_ID_INPUT("10", "Invalid group id input"), //
  INVALID_USER_ID_INPUT("11", "Invalid user id input"), //
  INVALID_TESTECASE_ID_INPUT("12", "Invalid testcase id input"), //
  INVALID_QUESTION_ID_INPUT("13", "Invalid question id input"), //
  INVALID_DATE_INPUT("13", "Invalid Date input"), //
  // User error
  INVALID_QUESTION_FORMAT_INPUT("21", "Invalid question format input"), //
  INVALID_TESTCASE_FORMAT_INPUT("22", "Invalid testcase format input"), //
  INVALID_METHOD_SIGNATURE_INPUT("23", "Invalid method signature input"), //
  INVALID_OPERATION("1000", "Invalid operation"), //
  // jwt
  INVALID_JWT("1001", "Invalid jwt"), //
  JWT_EXPIRED_EXCEPTION("1002", "JWT token is expired"), //
  JWT_UNSUPPORTED_EXCEPTION("1003", "JWT token is unsupported"), //
  JWT_ILLEGALARGUMENT_EXCEPTION("1004", "JWT token is unsupported"), //
  //
  USER_NOT_IN_EVENT("1005", "User not in event"), //
  // Api error
  API_ERROR("100", "API error"); //

  private String syscode;
  private String message;

  private Syscode(String syscode, String message) {
    this.syscode = syscode;
    this.message = message;
  }

  public static Syscode fromCode(String syscode) {
    for (Syscode c : Syscode.values()) {
      if (c.getSyscode().equals(syscode)) {
        return c;
      }
    }
    return null;
  }

}
