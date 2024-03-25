package com.vtxlab.projectol.backend_oscar.payload.request.question;

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

  private Integer bonusRuntime;

  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;



}
