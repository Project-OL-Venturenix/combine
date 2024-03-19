package com.vtxlab.projectol.backend_oscar.payload;

import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.TestCase;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionBankDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseDTO;

public class Mapper {
  public static TestCaseDTO map(TestCase testCase) {
    return TestCaseDTO.builder()
        // .questionId(testCase.getQuestionBank().getQuestionId())//
        .questionId(testCase.getQuestionBank().getQuestionId())//
        .input1(testCase.getInput1())//
        .input2(testCase.getInput2())//
        .input3(testCase.getInput3())//
        .expectedOutput(testCase.getExpectedOutput())//
        .build();
  }

  public static QuestionBankDTO map(QuestionBank questionBank) {
    return QuestionBankDTO.builder()//
        .questionId(questionBank.getQuestionId())//
        .question(questionBank.getQuestion())//
        .testComputeCase(questionBank.getTestComputeCase())//
        .methodSignatures(questionBank.getMethodSignatures())//
        .targetCompleteTime(questionBank.getTargetCompleteTime())//
        .build();
  }
}
