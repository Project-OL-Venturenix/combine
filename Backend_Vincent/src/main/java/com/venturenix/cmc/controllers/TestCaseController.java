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
import com.venturenix.cmc.models.TestCase;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.TestCaseRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.TestCaseResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.TestCaseRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestCaseController {
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


@PostMapping("/testcase/add")
  public ResponseEntity<?> addTestCase(@Valid @RequestBody TestCaseRequest testcaseRequest) {
    TestCase testcase = new TestCase(
               testcaseRequest.getQuestionid(), 
               testcaseRequest.getTestcasescoreid(), 
               testcaseRequest.getTestcaseresult(), 
               testcaseRequest.getTestcasetext(), 
               testcaseRequest.getStatus(),
               java.time.LocalDateTime.now(),
               testcaseRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               testcaseRequest.getUpdatedby()
               );
    testcaseRepository.save(testcase);
    return ResponseEntity.ok(new MessageResponse("Add TestCase successfully!"));
    
  }

  @GetMapping("/testcases")
  public ResponseEntity<List<TestCase>> getAllTestCases() {
    try {
        List<TestCase> testcases = new ArrayList<TestCase>();
        testcaseRepository.findAll().forEach(testcases::add);        
        if (testcases.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(testcases, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/testcase/{id}")
  public ResponseEntity<TestCase> getTestCaseById(@PathVariable("id") long id) {
    Optional<TestCase> testcaseData = testcaseRepository.findById(id);
    if (testcaseData.isPresent()) {
      return new ResponseEntity<>(testcaseData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/testcase/{id}")
  public ResponseEntity<TestCase> updateTestCase(@PathVariable("id") long id, @RequestBody TestCase testcase) {
    Optional<TestCase> testcaseData = testcaseRepository.findById(id);

    if (testcaseData.isPresent()) {
      TestCase _testcase = testcaseData.get();
      _testcase.setQuestionid(testcase.getQuestionid());
      _testcase.setTestcasescoreid(testcase.getTestcasescoreid());
      _testcase.setTestcaseresult(testcase.getTestcaseresult());
      _testcase.setTestcasetext(testcase.getTestcasetext());
      _testcase.setStatus(testcase.getStatus());
      _testcase.setUpdateddate(java.time.LocalDateTime.now());
      _testcase.setUpdatedby(testcase.getUpdatedby());
      return new ResponseEntity<>(testcaseRepository.save(_testcase), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/testcase/{id}")
  public ResponseEntity<?> deleteTestCase(@PathVariable("id") long id) {
    try {
      testcaseRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete TestCase " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
