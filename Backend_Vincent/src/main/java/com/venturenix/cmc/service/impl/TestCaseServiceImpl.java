package com.venturenix.cmc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.venturenix.cmc.payload.response.TestCaseDTO;
import com.venturenix.cmc.repository.TestCaseRepository;
import com.venturenix.cmc.service.QuestionBankService;
import com.venturenix.cmc.service.TestCaseService;

@Service
public class TestCaseServiceImpl implements TestCaseService {

  @Autowired
  private QuestionBankService questionBankService;

  @Autowired
  private TestCaseRepository testCaseRepository;

  public static final String CLASS_DECLARATION_TEMPLATE =
      "import java.util.*;\nimport java.math.*;\n public class Question%s";
  public static final String CODE_TEMPLATE =
      " \n //Enter the code Here.Your class should be named Question%s.\n \n ";
  public static final String MAIN_METHOD_TEMPLATE =
      "public static void main(String[] args) {\n" + //
          "    int counter = 0;\n" + //
          "    Question%s question%s = new Question%s();\n\n ";

  public static final String COUNT_RUNTIME =
      "        long startTime = System.nanoTime();\n" + //
          "        System.out.println(\"Test Case Result: \" + counter + \" / 10\");\n"
          + //
          "        long endTime = System.nanoTime();\n" + //
          "        long duration = (endTime - startTime) / 1000000; // Milliseconds\n"
          + //
          "        System.out.println(\n" + //
          "                \"Time taken for Test Case 10: \" + duration + \" milliseconds\");\n";

  @Override
  public String generateTestCase(List<TestCaseDTO> testCases, Long questionId) {
    StringBuilder testCaseBuilder = new StringBuilder();
    testCases.stream().forEach(e -> {
      testCaseBuilder.append("counter += testComputeCase(question")
          .append(questionId).append(", ").append(e.getInput1());
      if (e.getInput2() != null) {
        if (e.getInput2().equals("0")) {
          // Append "0" if input2 is "0"
          testCaseBuilder.append(",").append(0);
        } else {
          testCaseBuilder.append(", ")//
              .append(e.getInput2());

        }

        // Append input3
        if (e.getInput3() != null) {
          if (e.getInput3().equals("0")) {
            // Append "0" if input3 is "0"
            testCaseBuilder.append(",").append(0);
          } else {
            testCaseBuilder.append(", ").append(e.getInput3());
          }
        }


        // append expectedOutput
        if (e.getExpectedOutput().equals("0")) {
          // Append "0" if input3 is "0"
          testCaseBuilder.append(",").append(0);
        } else {
          testCaseBuilder.append(", ").append(e.getExpectedOutput());
        }
        // testCaseBuilder.append(", ").append(getExpectedOutput())
        // .append(");\n");
      }
      testCaseBuilder.append("); \n");
    });

    testCaseBuilder.append(COUNT_RUNTIME)
        .append(this.generateEndCodeBlock() + "\n");
    testCaseBuilder.append(questionBankService.getTestComputeCase(questionId));
    testCaseBuilder.append(this.generateEndCodeBlock());
    return testCaseBuilder.toString();
  }

  // public Long QuestionId() {
  // return this.getQuestionBank().getQuestionId();
  // }
  @Override
  public String generateClassDeclaration(Long questionId) {
    return String.format(CLASS_DECLARATION_TEMPLATE + //
        this.generateOpenCodeBlock(), questionId);
  }

  @Override
  public String generateFullCode(Long questionId) {
    return String.format(questionBankService.getMethodSignatures(questionId) + //
        this.generateOpenCodeBlock() + //
        CODE_TEMPLATE + //
        this.generateEndCodeBlock() + //
        "\n" + this.generateEndCodeBlock(), questionId);
  }

  @Override
  public String generateMainMethod(Long questionId) {
    StringBuilder mainMethodCode = new StringBuilder();
    mainMethodCode.append(String.format(MAIN_METHOD_TEMPLATE, questionId, //
        questionId, //
        questionId//
    )) //
        .append("\n");//

    return mainMethodCode.toString();
  }

  public String generateOpenCodeBlock() {
    return "{";
  }

  public String generateEndCodeBlock() {
    return "}";
  }

}
