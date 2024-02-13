package com.vtxlab.projectol.server_test_cases.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseResult {
  private String name;
  private boolean passed;
  private String errorMessage;

}
