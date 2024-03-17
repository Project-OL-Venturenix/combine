package com.vtxlab.projectol.backend_oscar.payload.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
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

  @JsonProperty("result_of_passing_testecase")
  private Integer resultOfPassingTestecase;

  @JsonProperty("bonus_under_30_mins")
  private String BonusUnder30Mins;

  @JsonProperty("bonus_within_question_runtime")
  private String BonusWithinQuestionRuntime;

  // @NotBlank
  private Integer testcaseTotal = 10;

  @JsonProperty("runtimebymsec")
  private Integer runTimeByMsec;

  private Integer createdBy;



  private Integer updatedBy;


}
