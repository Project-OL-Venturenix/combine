package com.venturenix.cmc.controllers.impl;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.TestCaseOperation;
import com.venturenix.cmc.entity.QuestionBank;
import com.venturenix.cmc.entity.TestCase;
import com.venturenix.cmc.payload.request.TestCaseRequest;
import com.venturenix.cmc.payload.response.TestCaseResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.QuestionRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.TestCaseRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;

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
  QuestionRepository questionRepository;

  public ResponseEntity<?> addTestCase(TestCaseRequest testcaseRequest) {
    QuestionBank targetQuestionBankData = questionRepository
        .findById(testcaseRequest.getQuestionId()).orElseThrow(
            () -> new RuntimeException("Error: Question is not found."));
    TestCase testcase = TestCase.builder()//
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

  public ResponseEntity<List<TestCase>> getAllTestCases() {
    try {
      List<TestCase> testcases = new ArrayList<TestCase>();
      testcaseRepository.findAll().forEach(testcases::add);
      if (testcases.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(testcases, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<TestCaseResponse> getTestCaseById(String id) {
    log.info("before testcaseData: ");
    Optional<TestCase> testcaseData =
        testcaseRepository.findById(Long.parseLong(id));
    log.info("testcaseData: " + testcaseData);
    if (testcaseData.isPresent()) {
      TestCaseResponse result = TestCaseResponse.builder()//
          .id(testcaseData.get().getTestcaseId())//
          .questionid(testcaseData.get().getQuestionBank().getQuestionId())//
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

  public ResponseEntity<TestCase> updateTestCase(long id, TestCase testcase) {
    Optional<TestCase> testcaseData = testcaseRepository.findById(id);

    if (testcaseData.isPresent()) {
      TestCase result = TestCase.builder()//
          .testcaseId(testcaseData.get().getTestcaseId())//
          .questionBank(testcaseData.get().getQuestionBank())//
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

  public ResponseEntity<?> deleteTestCase(long id) {
    try {
      testcaseRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete TestCase " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
