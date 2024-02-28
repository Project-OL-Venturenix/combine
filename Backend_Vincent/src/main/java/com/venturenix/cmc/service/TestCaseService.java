package com.venturenix.cmc.service;

import java.util.List;
import com.venturenix.cmc.payload.response.TestCaseDTO;

public interface TestCaseService {
  String generateTestCase(List<TestCaseDTO> testCases, Long questionId);

  public String generateClassDeclaration(Long questionId);

  public String generateFullCode(Long questionId);

  public String generateMainMethod(Long questionId);
}
