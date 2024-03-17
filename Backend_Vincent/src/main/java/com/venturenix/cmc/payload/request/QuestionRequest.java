package com.venturenix.cmc.payload.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuestionRequest {

  // @NotBlank
  private String question;

  // @Nonnull
  private String testComputeCase;

  // @Nonnull
  private String methodSignatures;

  private Integer targetCompleteTime;

  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;



}
