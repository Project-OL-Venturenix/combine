package com.venturenix.cmc.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.TestCaseScoreOperation;
import com.venturenix.cmc.entity.TestCaseScore;
import com.venturenix.cmc.payload.request.TestCaseScoreRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.TestCaseScoreRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestCaseScoreController implements TestCaseScoreOperation {
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
  TestCaseScoreRepository testcasescoreRepository;


  public ResponseEntity<?> addTestCaseScore(
      TestCaseScoreRequest testcasescoreRequest) {
    TestCaseScore testcasescore =
        new TestCaseScore(testcasescoreRequest.getTestcasescoredesc(),
            testcasescoreRequest.getTestcasescore(),
            testcasescoreRequest.getStatus(), java.time.LocalDateTime.now(),
            testcasescoreRequest.getCreatedby(), java.time.LocalDateTime.now(),
            testcasescoreRequest.getUpdatedby());
    testcasescoreRepository.save(testcasescore);
    return ResponseEntity
        .ok(new MessageResponse("Add TestCaseScore successfully!"));

  }

  public ResponseEntity<List<TestCaseScore>> getAllTestCaseScores() {
    try {
      List<TestCaseScore> testcasescores = new ArrayList<TestCaseScore>();
      testcasescoreRepository.findAll().forEach(testcasescores::add);
      if (testcasescores.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(testcasescores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<TestCaseScore> getTestCaseScoreById(long id) {
    Optional<TestCaseScore> testcasescoreData =
        testcasescoreRepository.findById(id);
    if (testcasescoreData.isPresent()) {
      return new ResponseEntity<>(testcasescoreData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<TestCaseScore> updateTestCaseScore(long id,
      TestCaseScore testcasescore) {
    Optional<TestCaseScore> testcasescoreData =
        testcasescoreRepository.findById(id);

    if (testcasescoreData.isPresent()) {
      TestCaseScore _testcasescore = testcasescoreData.get();
      _testcasescore.setTestcasescoredesc(testcasescore.getTestcasescoredesc());
      _testcasescore.setTestcasescore(testcasescore.getTestcasescore());
      _testcasescore.setStatus(testcasescore.getStatus());
      _testcasescore.setUpdateddate(java.time.LocalDateTime.now());
      _testcasescore.setUpdatedby(testcasescore.getUpdatedby());
      return new ResponseEntity<>(testcasescoreRepository.save(_testcasescore),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteTestCaseScore(long id) {
    try {
      testcasescoreRepository.deleteById(id);
      return ResponseEntity.ok(
          new MessageResponse("Delete TestCaseScore " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
