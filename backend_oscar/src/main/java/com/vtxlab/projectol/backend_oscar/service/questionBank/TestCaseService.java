package com.vtxlab.projectol.backend_oscar.service.questionBank;

import java.util.List;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseDTO;

public interface TestCaseService {
  String generateTestCase(List<TestCaseDTO> testCases, Long questionId);

  public String generateClassDeclaration(Long questionId);

  public String generateFullCode(Long questionId);

  public String generateMainMethod(Long questionId);

  String generateTestComputeCase(List<TestCaseDTO> testCases, Long questionId);
}
