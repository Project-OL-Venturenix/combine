package com.vtxlab.projectol.server_test_cases.infra.exception.setting;

import lombok.Getter;

// SysCode
@Getter
public enum Code {
  SUCCESS(0, "Success"), //
  CREATED(1, "Created"), //
  UPDATED(2, "Updated"), //
  DELETED(3, "Deleted"), //
  // 40000 - 49999
  NOT_FOUND(40000, "Resource NOT FOUND."), //
  FAIL(40001, "Fail"), //
  UN_AUTHORIZATION(40002, "Authorization Failed"), //
  UN_AUTHENTICATION(40003, "Authentication Failed"), //
  PARAMETER_ERROR(40004, "Parameters Error"), //
  TOKEN_INVALID(40005, "Token Invalid"), //
  TOKEN_EXPIRED(40006, "Token Expired"), //
  METHOD_NOT_ALLOWED(40007, "Method Not Allowed"), //
  REQUEST_LIMIT_EXCEEDED(40008, "Request Limit Exceeded"), //
  //Competition
  COMPETITION_NOT_FOUND(40009, "Competition Not Found"), //
  COMPETITION_DATE_NOT_FOUND(40010, "Competition Date Not Found"), //
  COMPETITION_NUMBER_NOT_FOUND(40011, "Competition Number Not Found"), //
  COMPETITION_ALREADY_EXISTS(40012, "Competition Already Exists"), //
  COMPETITION_DATE_WRONG_FORMAT(40013, "Competition Date Wrong Format"), //
  // Server
  SERVER_TIMEOUT(50000, "Server Timeout."), //
  THIRD_PARTY_SERVER_UNAVAILABLE(50001, "Third Party Service Unavailable."), //
  REDIS_SERVER_UNAVAILABLE(50002, "Redis unavailable."), INTERNAL_SERVER_ERROR(
      50003, "Internal Server Error."), //
  // Redis
  SHOP_CART_SKU_TYPE_COUNT_FULL(70000, "SHOP_CART_SKU_TYPE_COUNT_FULL"), //
  SKU_IS_NOT_EXISTS(70100, "SKU_IS_NOT_EXISTS"), //
  SKU_IS_OFF_THE_SHELVES(70101, "SKU_IS_OFF_THE_SHELVES"), //
  REDIS_ADD_ITEM_TO_CART_FAIL(70200, "REDIS_ADD_ITEM_TO_CART_FAIL"), //
  REDIS_GET_ITEM_FROM_CART_FAIL(70201, "REDIS_GET_ITEM_FROM_CART_FAIL"), //
  REDIS_DELETE_ITEM_FROM_CART_FAIL(70202, "REDIS_DELETE_ITEM_FROM_CART_FAIL"), //
  REDIS_SET_EXPIRE_TIME_FAIL(70203, "REDIS_SET_EXPIRE_TIME_FAIL"), //
  // RuntimeException: 90000 - 99999
  IAE_EXCEPTION(90000, "Illegal Argument Exception."), //
  ENTITY_NOT_FOUND(90001, "Entity Not Found."), //
  VALIDATOR_FAIL(90002, "Validator Fail.");

  private final int code;
  private final String desc;

  private Code(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static Code fromCode(int code) {
    for (Code c : Code.values()) {
      if (c.code == code) {
        return c;
      }
    }
    throw new IllegalArgumentException(
        "No matching constant for code: " + code);
  }

}
