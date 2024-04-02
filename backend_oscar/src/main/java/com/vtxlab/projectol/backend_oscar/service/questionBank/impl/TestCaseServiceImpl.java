package com.vtxlab.projectol.backend_oscar.service.questionBank.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseDTO;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.TestCaseRepository;
import com.vtxlab.projectol.backend_oscar.service.questionBank.QuestionBankService;
import com.vtxlab.projectol.backend_oscar.service.questionBank.TestCaseService;

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

  // public static final String TEST_COMPUTE_CASE =
  // "public int testComputeCase(Question%s question, int input1, int input2, int input3, int expectedOutput) {\n";
  public static String extractMethodName(String methodSignature) {
    // Define a regular expression pattern to match the method name
    String pattern = "\\s*(\\w+)\\s*\\(.*\\)"; // Matches "methodName(...)"

    // Create a Pattern object
    Pattern regex = Pattern.compile(pattern);

    // Create a Matcher object
    Matcher matcher = regex.matcher(methodSignature);

    // Check if the pattern matches the method signature
    if (matcher.find()) {
      // Extract and return the method name
      return matcher.group(1);
    }

    // Return null if no match is found
    return null;
  }

  @Override
  public String generateTestComputeCase(List<TestCaseDTO> testCases,
      Long questionId) {
    StringBuilder testCaseBuilder = new StringBuilder();
    testCases.forEach(e -> {
      testCaseBuilder.append("public int testComputeCase(Question")
          .append(questionId).append(" question, ").append(e.getInput1());

      if (e.getInput2() != null) {
        testCaseBuilder.append(", ").append(e.getInput2());
      }

      if (e.getInput3() != null) {
        testCaseBuilder.append(", ").append(e.getInput3());
      }

      testCaseBuilder.append(", ").append(e.getExpectedOutput())
          .append("); \n");
    });

    testCaseBuilder.append(COUNT_RUNTIME)
        .append(this.generateEndCodeBlock() + "\n");
    testCaseBuilder.append(questionBankService.getTestComputeCase(questionId));
    testCaseBuilder.append(this.generateEndCodeBlock());

    return testCaseBuilder.toString();
  }

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

  // public Long questionId() {
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
