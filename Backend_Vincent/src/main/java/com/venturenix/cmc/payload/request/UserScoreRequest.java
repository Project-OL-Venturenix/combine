package com.venturenix.cmc.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserScoreRequest {

  // @NotBlank
  private Long eventId;

  // @NotBlank
  private Long userId;

  // @NotBlank
  private Long questionId;

  // @NotBlank
  private Integer testcasepassTotal;

  // @NotBlank
  private Double testcasescoreTotal;

  // @NotBlank
  private Integer testcaseTotal = 10;



  private Integer createdBy;



  private Integer updatedBy;


}
