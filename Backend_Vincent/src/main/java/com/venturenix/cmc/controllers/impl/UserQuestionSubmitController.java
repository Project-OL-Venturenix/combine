package com.venturenix.cmc.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.UserQuestionSubmitOperation;
import com.venturenix.cmc.entity.UserQuestionSubmit;
import com.venturenix.cmc.payload.request.UserQuestionSubmitRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.UserQuestionSubmitRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserQuestionSubmitController
    implements UserQuestionSubmitOperation {
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


  public ResponseEntity<?> addUserQuestionSubmit(
      UserQuestionSubmitRequest userquestionsubmitRequest) {
    UserQuestionSubmit userquestionsubmit = new UserQuestionSubmit(
        userquestionsubmitRequest.getEventid(),
        userquestionsubmitRequest.getQuestionid(),
        userquestionsubmitRequest.getUserid(),
        userquestionsubmitRequest.getSubmittime(),
        userquestionsubmitRequest.getRuntimebymsec(),
        userquestionsubmitRequest.getStatus(), java.time.LocalDateTime.now(),
        userquestionsubmitRequest.getCreatedby(),
        java.time.LocalDateTime.now(),
        userquestionsubmitRequest.getUpdatedby());
    userquestionsubmitRepository.save(userquestionsubmit);
    return ResponseEntity
        .ok(new MessageResponse("Add UserQuestionSubmit successfully!"));

  }

  public ResponseEntity<List<UserQuestionSubmit>> getAllUserQuestionSubmits() {
    try {
      List<UserQuestionSubmit> userquestionsubmits =
          new ArrayList<UserQuestionSubmit>();
      userquestionsubmitRepository.findAll()
          .forEach(userquestionsubmits::add);
      if (userquestionsubmits.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(userquestionsubmits, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<UserQuestionSubmit> getUserQuestionSubmitById(
      long id) {
    Optional<UserQuestionSubmit> userquestionsubmitData =
        userquestionsubmitRepository.findById(id);
    if (userquestionsubmitData.isPresent()) {
      return new ResponseEntity<>(userquestionsubmitData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<UserQuestionSubmit> updateUserQuestionSubmit(long id,
      UserQuestionSubmit userquestionsubmit) {
    Optional<UserQuestionSubmit> userquestionsubmitData =
        userquestionsubmitRepository.findById(id);

    if (userquestionsubmitData.isPresent()) {
      UserQuestionSubmit _userquestionsubmit = userquestionsubmitData.get();
      _userquestionsubmit.setEventid(userquestionsubmit.getEventid());
      _userquestionsubmit.setQuestionid(userquestionsubmit.getQuestionid());
      _userquestionsubmit.setUserid(userquestionsubmit.getUserid());
      _userquestionsubmit.setStatus(userquestionsubmit.getStatus());
      _userquestionsubmit.setSubmittime(userquestionsubmit.getSubmittime());
      _userquestionsubmit
          .setRuntimebymsec(userquestionsubmit.getRuntimebymsec());
      _userquestionsubmit.setUpdateddate(java.time.LocalDateTime.now());
      _userquestionsubmit.setUpdatedby(userquestionsubmit.getUpdatedby());
      return new ResponseEntity<>(
          userquestionsubmitRepository.save(_userquestionsubmit),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteUserQuestionSubmit(long id) {
    try {
      userquestionsubmitRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse(
          "Delete UserQuestionSubmit " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}

