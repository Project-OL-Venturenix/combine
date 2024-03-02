package com.venturenix.cmc.controllers.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.QuestionOperation;
import com.venturenix.cmc.entity.QuestionBank;
import com.venturenix.cmc.entity.TestCase;
import com.venturenix.cmc.payload.Mapper;
import com.venturenix.cmc.payload.request.QuestionRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.payload.response.QuestionResponse;
import com.venturenix.cmc.payload.response.TestCaseDTO;
import com.venturenix.cmc.repository.QuestionRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.TestCaseRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.service.QuestionBankService;
import com.venturenix.cmc.service.TestCaseService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QuestionController implements QuestionOperation {
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
  private QuestionBankService questionBankService;

  @Autowired
  private TestCaseService testCaseService;

  @Autowired
  QuestionRepository questionRepository;

  @Autowired
  TestCaseRepository testCaseRepository;

  public ResponseEntity<?> addQuestion(QuestionRequest questionRequest) {
    QuestionBank question = QuestionBank.builder()//
        .question(questionRequest.getQuestion())//
        .testComputeCase(questionRequest.getTestComputeCase())//
        .methodSignatures(questionRequest.getMethodSignatures())//
        .createddate(java.time.LocalDateTime.now())//
        .createdby(questionRequest.getCreatedby())//
        .updateddate(java.time.LocalDateTime.now())//
        .updatedby(questionRequest.getUpdatedby())//
        .build();

    questionBankService.save(question);
    return ResponseEntity.ok(new MessageResponse("Add Question successfully!"));

  }

  public ResponseEntity<List<QuestionBank>> getAllQuestions() {
    try {
      List<QuestionBank> questions = new ArrayList<>();
      questionRepository.findAll().forEach(questions::add);
      if (questions.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(questions, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  @Override
  public ResponseEntity<QuestionResponse> getQuestionById(String id) {
    Long questionId = Long.parseLong(id);
    Optional<QuestionBank> questionData =
        questionRepository.findById(questionId);
    log.info("questionData : ");

    Optional<List<TestCase>> testcaseData =
        Optional.of(testCaseRepository.getTestCaseByQuestionId(questionId));
    log.info("testcaseData : " + testcaseData.orElse(null));

    List<TestCaseDTO> testCases = testCaseRepository.findAll().stream()//
        .filter(e -> e.getQuestionBank().getQuestionId().equals(questionId))//
        .limit(3)//
        .map(e -> Mapper.map(e))//
        .collect(Collectors.toList());
    log.info("testCases : " + testCases.get(0));


    if (questionData.isPresent() && testcaseData.isPresent()) {
      QuestionResponse questionResponse = QuestionResponse.builder()
          .questionId(questionData.get().getQuestionId())//
          .classDeclaration(
              testCaseService.generateClassDeclaration(questionId))//
          .code(testCaseService.generateFullCode(questionId))//
          .mainMethod(testCaseService.generateMainMethod(questionId) + //
              testCaseService.generateTestCase(testCases, questionId))//
          .createdby(questionData.get().getCreatedby())//
          .updateddate(questionData.get().getUpdateddate())//
          .updatedby(questionData.get().getUpdatedby())//
          .build();
      return new ResponseEntity<>(questionResponse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseEntity<QuestionResponse> getQuestionSubmitById(String id) {
    Long questionId = Long.parseLong(id);
    Optional<QuestionBank> questionData =
        questionRepository.findById(questionId);
    log.info("questionData : ");

    // Optional<TestCase> testcaseData = testCaseRepository.findAll().stream()//
    // .filter(e -> e.getQuestionBank().getQuestionId().equals(questionId))//
    // .findFirst();
    Optional<List<TestCase>> testcaseData =
        Optional.of(testCaseRepository.getTestCaseByQuestionId(questionId));
    log.info("testcaseData : " + testcaseData.orElse(null));

    List<TestCaseDTO> testCases = testCaseRepository.findAll().stream()//
        .filter(e -> e.getQuestionBank().getQuestionId().equals(questionId))//
        .map(e -> Mapper.map(e))//
        .collect(Collectors.toList());
    log.info("testCases : " + testCases.get(0));


    if (questionData.isPresent() && testcaseData.isPresent()) {
      QuestionResponse questionResponse = QuestionResponse.builder()
          .questionId(questionData.get().getQuestionId())//
          .classDeclaration(
              testCaseService.generateClassDeclaration(questionId))//
          .code(testCaseService.generateFullCode(questionId))//
          // .mainMethod(testcaseData.get().generateMainMethod()
          // + testcaseData.get().getMainMethod() + "\n"
          // + testcaseData.get().generateEndCodeBlock())//
          .mainMethod(testCaseService.generateMainMethod(questionId) + //
              testCaseService.generateTestCase(testCases, questionId))//
          .createdby(questionData.get().getCreatedby())//
          .updateddate(questionData.get().getUpdateddate())//
          .updatedby(questionData.get().getUpdatedby())//
          .build();
      return new ResponseEntity<>(questionResponse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<QuestionBank> updateQuestion(long id,
      QuestionBank question) {
    Optional<QuestionBank> questionData = questionRepository.findById(id);

    if (questionData.isPresent()) {
      QuestionBank _question = questionData.get();
      _question.setQuestion(question.getQuestion());
      _question.setCreateddate(LocalDateTime.now());
      _question.setCreatedby(question.getCreatedby());
      _question.setUpdateddate(LocalDateTime.now());
      _question.setUpdatedby(question.getUpdatedby());
      return new ResponseEntity<>(questionRepository.save(_question),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteQuestion(long id) {
    try {
      questionRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete Question " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }


}
