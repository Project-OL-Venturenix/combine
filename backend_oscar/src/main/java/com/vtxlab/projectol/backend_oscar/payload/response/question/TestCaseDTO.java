package com.vtxlab.projectol.backend_oscar.payload.response.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TestCaseDTO {
  private Long id;
  private String methodSignatures;
  private String testComputeCase;
  private String input1;
  private String input2;
  private String input3;
  private String expectedOutput;

}
