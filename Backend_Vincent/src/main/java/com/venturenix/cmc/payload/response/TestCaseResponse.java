package com.venturenix.cmc.payload.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TestCaseResponse {
  private String token;
  private String type = "Bearer";
  private Long id;

  private Long questionid;

  private String methodSignatures;
  private String mainMethod;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;


}
