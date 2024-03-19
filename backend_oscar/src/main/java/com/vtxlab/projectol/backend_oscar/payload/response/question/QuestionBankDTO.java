package com.vtxlab.projectol.backend_oscar.payload.response.question;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionBankDTO {
  @Column(name = "question_id")
  private Long questionId;

  private String question;

  private String testComputeCase;

  private String methodSignatures;

  private Integer targetCompleteTime;

}
