package com.venturenix.cmc.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import com.venturenix.cmc.models.QuestionBank;
import com.venturenix.cmc.models.TestCase;
import com.venturenix.cmc.payload.request.QuestionRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.payload.response.QuestionResponse;
import com.venturenix.cmc.repository.QuestionRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.TestCaseRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QuestionController {
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
  QuestionRepository questionRepository;

  @Autowired
  TestCaseRepository testCaseRepository;

  @PostMapping("/question/add")
  public ResponseEntity<?> addQuestion(
      @Valid @RequestBody QuestionRequest questionRequest) {
    QuestionBank question = QuestionBank.builder()//
        .question(questionRequest.getQuestion())//
        .createddate(java.time.LocalDateTime.now())//
        .createdby(questionRequest.getCreatedby())//
        .updateddate(java.time.LocalDateTime.now())//
        .updatedby(questionRequest.getUpdatedby())//
        .build();

    questionRepository.save(question);
    return ResponseEntity.ok(new MessageResponse("Add Question successfully!"));

  }

  @GetMapping("/questions")
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

  @GetMapping("/question/{id}")
  public ResponseEntity<QuestionResponse> getQuestionById(
      @PathVariable("id") String id) {
    Long questionId = Long.parseLong(id);
    Optional<QuestionBank> questionData =
        questionRepository.findById(questionId);
    log.info("questionData : ");
    Optional<TestCase> testcaseData = testCaseRepository.findAll().stream()//
        .filter(e -> e.getQuestionBank().getQuestionId().equals(questionId))//
        .findFirst();
    log.info("testcaseData : " + testcaseData.get());
    if (questionData.isPresent() && testcaseData.isPresent()) {
      QuestionResponse questionResponse = QuestionResponse.builder()//
          .quesetionId(questionData.get().getQuestionId())//
          .classDeclaration(
              "import java.util.*;\nimport java.math.*;\n public class Question"
                  + id + " {\n")//
          .code(testcaseData.get().getMethodSignatures()
              + "\n//Enter the code Here.Your class should be named Question"
              + id + ".\n \n }")//
          .mainMethod("public static void main(String[] args) {\n" + //
              "    int counter = 0;\n" + //
              "    Question" + id + " question" + id + " = new Question" + id
              + "();\n\n  " + testcaseData.get().getMainMethod())//
          .endOfCode("}")//
          .createdby(questionData.get().getCreatedby())//
          .updateddate(questionData.get().getUpdateddate())//
          .updatedby(questionData.get().getUpdatedby())//
          .build();
      return new ResponseEntity<>(questionResponse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/question/{id}")
  public ResponseEntity<QuestionBank> updateQuestion(
      @PathVariable("id") long id, @RequestBody QuestionBank question) {
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

  @DeleteMapping("/question/{id}")
  public ResponseEntity<?> deleteQuestion(@PathVariable("id") long id) {
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
