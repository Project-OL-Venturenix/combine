package com.venturenix.cmc.payload.request;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCaseScoreRequest {


  // @NotBlank
  private String testcasescoredesc;

  // @NotBlank
  private Double testcasescore;


  // @NotBlank
  private String status;


  private LocalDateTime createdDate;


  private Integer createdBy;


  private LocalDateTime updatedDate;


  private Integer updatedBy;

}
