package com.vtxlab.projectol.backend_oscar.payload.response.question;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TestCaseResponse {
  private String token;
  private String type = "Bearer";
  private Long id;

  private Long questionId;

  private String methodSignatures;
  // private String mainMethod;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;


}
