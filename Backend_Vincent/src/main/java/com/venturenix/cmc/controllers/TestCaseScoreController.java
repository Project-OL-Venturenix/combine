package com.venturenix.cmc.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.venturenix.cmc.models.ERole;
import com.venturenix.cmc.models.Role;
import com.venturenix.cmc.models.User;
import com.venturenix.cmc.models.TestCaseScore;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.TestCaseScoreRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.TestCaseScoreResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.TestCaseScoreRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestCaseScoreController {
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


@PostMapping("/testcasescore/add")
  public ResponseEntity<?> addTestCaseScore(@Valid @RequestBody TestCaseScoreRequest testcasescoreRequest) {
    TestCaseScore testcasescore = new TestCaseScore(
               testcasescoreRequest.getTestcasescoredesc(), 
               testcasescoreRequest.getTestcasescore(),
               testcasescoreRequest.getStatus(),
               java.time.LocalDateTime.now(),
               testcasescoreRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               testcasescoreRequest.getUpdatedby()
               );
    testcasescoreRepository.save(testcasescore);
    return ResponseEntity.ok(new MessageResponse("Add TestCaseScore successfully!"));
    
  }

  @GetMapping("/testcasescores")
  public ResponseEntity<List<TestCaseScore>> getAllTestCaseScores() {
    try {
        List<TestCaseScore> testcasescores = new ArrayList<TestCaseScore>();
        testcasescoreRepository.findAll().forEach(testcasescores::add);        
        if (testcasescores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(testcasescores, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/testcasescore/{id}")
  public ResponseEntity<TestCaseScore> getTestCaseScoreById(@PathVariable("id") long id) {
    Optional<TestCaseScore> testcasescoreData = testcasescoreRepository.findById(id);
    if (testcasescoreData.isPresent()) {
      return new ResponseEntity<>(testcasescoreData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/testcasescore/{id}")
  public ResponseEntity<TestCaseScore> updateTestCaseScore(@PathVariable("id") long id, @RequestBody TestCaseScore testcasescore) {
    Optional<TestCaseScore> testcasescoreData = testcasescoreRepository.findById(id);

    if (testcasescoreData.isPresent()) {
      TestCaseScore _testcasescore = testcasescoreData.get();
      _testcasescore.setTestcasescoredesc(testcasescore.getTestcasescoredesc());
      _testcasescore.setTestcasescore(testcasescore.getTestcasescore());
      _testcasescore.setStatus(testcasescore.getStatus());
      _testcasescore.setUpdateddate(java.time.LocalDateTime.now());
      _testcasescore.setUpdatedby(testcasescore.getUpdatedby());
      return new ResponseEntity<>(testcasescoreRepository.save(_testcasescore), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/testcasescore/{id}")
  public ResponseEntity<?> deleteTestCaseScore(@PathVariable("id") long id) {
    try {
      testcasescoreRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete TestCaseScore " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
