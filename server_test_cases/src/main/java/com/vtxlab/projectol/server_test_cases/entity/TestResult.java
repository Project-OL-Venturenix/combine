package com.vtxlab.projectol.server_test_cases.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResult {
  private boolean success;
  private String message;
  private List<TestCaseResult> testResults;
  
}
