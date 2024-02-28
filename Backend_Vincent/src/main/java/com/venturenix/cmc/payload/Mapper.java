package com.venturenix.cmc.payload;

import com.venturenix.cmc.entity.TestCase;
import com.venturenix.cmc.payload.response.TestCaseDTO;

public class Mapper {
  public static TestCaseDTO map(TestCase testCase) {
    return TestCaseDTO.builder()
        .questionId(testCase.getQuestionBank().getQuestionId())//
        .methodSignatures(testCase.getMethodSignatures())//
        .mainMethod(testCase.getMainMethod())//
        .input1(testCase.getInput1())//
        .input2(testCase.getInput2())//
        .input3(testCase.getInput3())//
        .expectedOutput(testCase.getExpectedOutput())//
        .build();
  }
}
