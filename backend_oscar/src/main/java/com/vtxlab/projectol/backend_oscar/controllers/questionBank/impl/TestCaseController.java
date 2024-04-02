package com.vtxlab.projectol.backend_oscar.controllers.questionBank.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.projectol.backend_oscar.controllers.user.TestCaseOperation;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.TestCase;
import com.vtxlab.projectol.backend_oscar.payload.request.question.TestCaseRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.question.TestCaseResponse;
import com.vtxlab.projectol.backend_oscar.payload.response.user.MessageResponse;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.QuestionBankRepository;
import com.vtxlab.projectol.backend_oscar.repository.questionBank.TestCaseRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.RoleRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.UserRepository;
import com.vtxlab.projectol.backend_oscar.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestCaseController implements TestCaseOperation {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  TestCaseRepository testcaseRepository;

  @Autowired
  QuestionBankRepository questionRepository;

  public ResponseEntity<?> addTestCase(TestCaseRequest testcaseRequest) {
    QuestionBank targetQuestionBankData = questionRepository
        .findById(testcaseRequest.getQuestionId()).orElseThrow(
            () -> new RuntimeException("Error: Question is not found."));
    TestCase testcase = TestCase.builder()//
        // .questionBank(targetQuestionBankData)//
        .questionBank(targetQuestionBankData)//
        .input1(testcaseRequest.getInput1())//
        .input2(testcaseRequest.getInput2())//
        .input3(testcaseRequest.getInput3())//
        .expectedOutput(testcaseRequest.getExpectedOutput())//
        .createdDate(LocalDateTime.now())//
        .createdBy(testcaseRequest.getCreatedBy())//
        .updatedDate(LocalDateTime.now())//
        .updatedBy(testcaseRequest.getUpdatedBy())//
        .build();
    log.info("testcaseRequest " + testcaseRequest.toString());
    testcaseRepository.save(testcase);
    return ResponseEntity.ok(new MessageResponse("Add TestCase successfully!"));

  }

  public ResponseEntity<List<TestCaseDTO>> getAllTestCases() {
    try {
      List<TestCaseDTO> testcases =
          testcaseRepository.findAll().stream().map(e -> {
            QuestionBank targetQuestionBankData =
                questionRepository.findById(e.getQuestionBank().getQuestionId())
                    .orElseThrow(() -> new RuntimeException(
                        "Error: Question is not found."));
            return TestCaseDTO.builder()//
                .id(e.getQuestionBank().getQuestionId())//
                .methodSignatures(targetQuestionBankData.getMethodSignatures())//
                .testComputeCase(targetQuestionBankData.getTestComputeCase())//
                .input1(e.getInput1())//
                .input2(e.getInput2())//
                .input3(e.getInput3())//
                .expectedOutput(e.getExpectedOutput())//
                .build();//
          })//
              .collect(Collectors.toList());//
      if (testcases.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(testcases, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<TestCaseResponse> getTestCaseById(String id) {
    Long testcaseId = Long.parseLong(id);
    Optional<TestCase> testcaseData = testcaseRepository.findById(testcaseId);
    QuestionBank targetQuestionBankData = questionRepository
        .findById(testcaseData.get().getQuestionBank().getQuestionId())
        .orElseThrow(
            () -> new RuntimeException("Error: Question is not found."));

    if (testcaseData.isPresent()) {
      TestCaseResponse result = TestCaseResponse.builder()//
          .id(testcaseData.get().getTestcaseId())//
          // .mainMethod(testcaseData.get().getMainMethod())//
          .methodSignatures(targetQuestionBankData.getMethodSignatures())
          .questionId(targetQuestionBankData.getQuestionId())//
          .createdDate(testcaseData.get().getCreatedDate())//
          .createdBy(testcaseData.get().getCreatedBy())//
          .updatedDate(testcaseData.get().getUpdatedDate())//
          .updatedBy(testcaseData.get().getUpdatedBy())//
          .build();

      return new ResponseEntity<>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<TestCase> updateTestCase(String id, TestCase testcase) {
    Long testcaseId = Long.parseLong(id);
    Optional<TestCase> testcaseData = testcaseRepository.findById(testcaseId);
    QuestionBank targetQuestionBankData = questionRepository
        .findById(testcase.getQuestionBank().getQuestionId()).orElseThrow(
            () -> new RuntimeException("Error: Question is not found."));

    if (testcaseData.isPresent()) {
      TestCase result = TestCase.builder()//
          .testcaseId(testcaseData.get().getTestcaseId())//
          // .questionBank(testcaseData.get().getQuestionBank())//
          .questionBank(targetQuestionBankData)//
          .createdDate(testcaseData.get().getCreatedDate())//
          .createdBy(testcaseData.get().getCreatedBy())//
          .updatedDate(LocalDateTime.now())//
          .updatedBy(testcaseData.get().getUpdatedBy())//
          .build();

      return new ResponseEntity<>(testcaseRepository.save(result),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteTestCase(String id) {
    Long testcaseId = Long.parseLong(id);
    try {
      testcaseRepository.deleteById(testcaseId);
      return ResponseEntity
          .ok(new MessageResponse("Delete TestCase " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
