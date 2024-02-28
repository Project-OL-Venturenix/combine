package com.venturenix.cmc.payload.request;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCaseRequest {

  private Long questionId;
  // no need add "{" and "}" in the methodSignatures
  private String expectedOutput;
  private String input1;
  private String input2;
  private String input3;

  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;

}
