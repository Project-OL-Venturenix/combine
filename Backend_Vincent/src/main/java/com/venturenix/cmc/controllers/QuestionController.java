package com.venturenix.cmc.controllers;

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
import com.venturenix.cmc.models.Question;
import com.venturenix.cmc.payload.request.QuestionRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.QuestionRepository;
import com.venturenix.cmc.repository.RoleRepository;
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


  @PostMapping("/question/add")
  public ResponseEntity<?> addQuestion(
      @Valid @RequestBody QuestionRequest questionRequest) {
    Question question = new Question(questionRequest.getQuestiontext(),
        questionRequest.getAnswertext(), questionRequest.getStatus(),
        java.time.LocalDateTime.now(), questionRequest.getCreatedby(),
        java.time.LocalDateTime.now(), questionRequest.getUpdatedby());
    questionRepository.save(question);
    return ResponseEntity.ok(new MessageResponse("Add Question successfully!"));

  }

  @GetMapping("/questions")
  public ResponseEntity<List<Question>> getAllQuestions() {
    try {
      log.info("111");
      List<Question> questions = new ArrayList<Question>();
      log.info("222");
      // questionRepository.findAll().forEach(questions::add);
      questionRepository.findById(1);
      log.info("questionRepository.findAll().size() "
          + questionRepository.findAll().size());
      // if (questions.isEmpty()) {
      // log.info("333");
      // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      // }
      log.info("444");
      return new ResponseEntity<>(questions, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  @GetMapping("/question/{id}")
  public ResponseEntity<Question> getQuestionById(@PathVariable("id") long id) {
    Optional<Question> questionData = questionRepository.findById(id);
    if (questionData.isPresent()) {
      return new ResponseEntity<>(questionData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/question/{id}")
  public ResponseEntity<Question> updateQuestion(@PathVariable("id") long id,
      @RequestBody Question question) {
    Optional<Question> questionData = questionRepository.findById(id);

    if (questionData.isPresent()) {
      Question _question = questionData.get();
      _question.setQuestiontext(question.getQuestiontext());
      _question.setAnswertext(question.getAnswertext());
      _question.setStatus(question.getStatus());
      _question.setUpdateddate(java.time.LocalDateTime.now());
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
