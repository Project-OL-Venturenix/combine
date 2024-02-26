package com.venturenix.cmc.controllers.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
import com.venturenix.cmc.controllers.UserTestCaseOperation;
import com.venturenix.cmc.entity.ERole;
import com.venturenix.cmc.entity.Role;
import com.venturenix.cmc.entity.User;
import com.venturenix.cmc.entity.UserTestCase;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.UserTestCaseRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.UserTestCaseResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.UserTestCaseRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserTestCaseController implements UserTestCaseOperation {
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
  UserTestCaseRepository usertestcaseRepository;


  public ResponseEntity<?> addUserTestCase(
      UserTestCaseRequest usertestcaseRequest) {

    System.out.println("getEventid = " + usertestcaseRequest.getEventid());
    System.out
        .println("getQuestionid = " + usertestcaseRequest.getQuestionid());
    System.out
        .println("getTestcaseid = " + usertestcaseRequest.getTestcaseid());
    // System.out.println("getUserid = " + usertestcaseRequest.getUserid());
    System.out.println(
        "getRunstarttimeutc = " + usertestcaseRequest.getRunstarttimeutc());
    System.out.println(
        "getRunendtimeutc = " + usertestcaseRequest.getRunendtimeutc());
    System.out
        .println("getRuntimeutc = " + usertestcaseRequest.getRuntimeutc());
    System.out
        .println("getRunstarttime = " + usertestcaseRequest.getRunstarttime());
    System.out
        .println("getRunendtime = " + usertestcaseRequest.getRunendtime());
    System.out.println(
        "getTestcasefilepath = " + usertestcaseRequest.getTestcasefilepath());
    System.out.println("getFilename = " + usertestcaseRequest.getFilename());
    System.out.println("getTestcasepassstatus = "
        + usertestcaseRequest.getTestcasepassstatus());
    System.out.println("getStatus = " + usertestcaseRequest.getStatus());
    System.out.println("getCreatedby = " + usertestcaseRequest.getCreatedby());
    System.out.println("getUpdatedby = " + usertestcaseRequest.getUpdatedby());


    UserTestCase usertestcase = new UserTestCase(
        usertestcaseRequest.getEventid(), usertestcaseRequest.getQuestionid(),
        usertestcaseRequest.getTestcaseid(), usertestcaseRequest.getUserid(),
        usertestcaseRequest.getRunstarttimeutc(),
        usertestcaseRequest.getRunendtimeutc(),
        usertestcaseRequest.getRuntimeutc(),
        usertestcaseRequest.getRunstarttime(),
        usertestcaseRequest.getRunendtime(),
        usertestcaseRequest.getTestcasefilepath(),
        usertestcaseRequest.getFilename(),
        usertestcaseRequest.getTestcasepassstatus(),
        usertestcaseRequest.getStatus(), java.time.LocalDateTime.now(),
        usertestcaseRequest.getCreatedby(), java.time.LocalDateTime.now(),
        usertestcaseRequest.getUpdatedby());
    usertestcaseRepository.save(usertestcase);
    return ResponseEntity
        .ok(new MessageResponse("Add UserTestCase successfully!"));

  }

  public ResponseEntity<List<UserTestCase>> getAllUserTestCases() {
    try {
      List<UserTestCase> usertestcases = new ArrayList<UserTestCase>();
      usertestcaseRepository.findAll().forEach(usertestcases::add);
      if (usertestcases.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(usertestcases, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<UserTestCase> getUserTestCaseById(long id) {
    Optional<UserTestCase> usertestcaseData =
        usertestcaseRepository.findById(id);
    if (usertestcaseData.isPresent()) {
      return new ResponseEntity<>(usertestcaseData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<UserTestCase> updateUserTestCase(long id,
      UserTestCase usertestcase) {
    Optional<UserTestCase> usertestcaseData =
        usertestcaseRepository.findById(id);

    if (usertestcaseData.isPresent()) {
      UserTestCase _usertestcase = usertestcaseData.get();
      _usertestcase.setEventid(usertestcase.getEventid());
      _usertestcase.setQuestionid(usertestcase.getQuestionid());
      _usertestcase.setTestcaseid(usertestcase.getTestcaseid());
      _usertestcase.setUserid(usertestcase.getUserid());
      _usertestcase.setRunstarttimeutc(usertestcase.getRunstarttimeutc());
      _usertestcase.setRunendtimeutc(usertestcase.getRunendtimeutc());
      _usertestcase.setRuntimeutc(usertestcase.getRuntimeutc());
      _usertestcase.setRunstarttime(usertestcase.getRunstarttime());
      _usertestcase.setRunendtime(usertestcase.getRunendtime());
      _usertestcase.setTestcasefilepath(usertestcase.getTestcasefilepath());
      _usertestcase.setFilename(usertestcase.getFilename());
      _usertestcase.setTestcasepassstatus(usertestcase.getTestcasepassstatus());
      _usertestcase.setStatus(usertestcase.getStatus());
      _usertestcase.setUpdateddate(java.time.LocalDateTime.now());
      _usertestcase.setUpdatedby(usertestcase.getUpdatedby());
      return new ResponseEntity<>(usertestcaseRepository.save(_usertestcase),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteUserTestCase(long id) {
    try {
      usertestcaseRepository.deleteById(id);
      return ResponseEntity.ok(
          new MessageResponse("Delete UserTestCase " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
