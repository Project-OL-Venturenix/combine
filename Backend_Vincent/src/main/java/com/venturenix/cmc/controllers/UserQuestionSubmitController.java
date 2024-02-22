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
import com.venturenix.cmc.models.UserQuestionSubmit;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.UserQuestionSubmitRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.UserQuestionSubmitResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.UserQuestionSubmitRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserQuestionSubmitController {
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
  UserQuestionSubmitRepository userquestionsubmitRepository;


@PostMapping("/userquestionsubmit/add")
  public ResponseEntity<?> addUserQuestionSubmit(@Valid @RequestBody UserQuestionSubmitRequest userquestionsubmitRequest) {
    UserQuestionSubmit userquestionsubmit = new UserQuestionSubmit(
               userquestionsubmitRequest.getEventid(), 
               userquestionsubmitRequest.getQuestionid(), 
               userquestionsubmitRequest.getUserid(), 
               userquestionsubmitRequest.getSubmittime(), 
               userquestionsubmitRequest.getRuntimebymsec(), 
               userquestionsubmitRequest.getStatus(),
               java.time.LocalDateTime.now(),
               userquestionsubmitRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               userquestionsubmitRequest.getUpdatedby()
               );
    userquestionsubmitRepository.save(userquestionsubmit);
    return ResponseEntity.ok(new MessageResponse("Add UserQuestionSubmit successfully!"));
    
  }

  @GetMapping("/userquestionsubmits")
  public ResponseEntity<List<UserQuestionSubmit>> getAllUserQuestionSubmits() {
    try {
        List<UserQuestionSubmit> userquestionsubmits = new ArrayList<UserQuestionSubmit>();
        userquestionsubmitRepository.findAll().forEach(userquestionsubmits::add);        
        if (userquestionsubmits.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userquestionsubmits, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/userquestionsubmit/{id}")
  public ResponseEntity<UserQuestionSubmit> getUserQuestionSubmitById(@PathVariable("id") long id) {
    Optional<UserQuestionSubmit> userquestionsubmitData = userquestionsubmitRepository.findById(id);
    if (userquestionsubmitData.isPresent()) {
      return new ResponseEntity<>(userquestionsubmitData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/userquestionsubmit/{id}")
  public ResponseEntity<UserQuestionSubmit> updateUserQuestionSubmit(@PathVariable("id") long id, @RequestBody UserQuestionSubmit userquestionsubmit) {
    Optional<UserQuestionSubmit> userquestionsubmitData = userquestionsubmitRepository.findById(id);

    if (userquestionsubmitData.isPresent()) {
      UserQuestionSubmit _userquestionsubmit = userquestionsubmitData.get();
      _userquestionsubmit.setEventid(userquestionsubmit.getEventid());
      _userquestionsubmit.setQuestionid(userquestionsubmit.getQuestionid());
      _userquestionsubmit.setUserid(userquestionsubmit.getUserid());
      _userquestionsubmit.setStatus(userquestionsubmit.getStatus());
      _userquestionsubmit.setSubmittime(userquestionsubmit.getSubmittime());
      _userquestionsubmit.setRuntimebymsec(userquestionsubmit.getRuntimebymsec());
      _userquestionsubmit.setUpdateddate(java.time.LocalDateTime.now());
      _userquestionsubmit.setUpdatedby(userquestionsubmit.getUpdatedby());
      return new ResponseEntity<>(userquestionsubmitRepository.save(_userquestionsubmit), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/userquestionsubmit/{id}")
  public ResponseEntity<?> deleteUserQuestionSubmit(@PathVariable("id") long id) {
    try {
      userquestionsubmitRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete UserQuestionSubmit " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}

