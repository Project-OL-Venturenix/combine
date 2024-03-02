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
import com.venturenix.cmc.controllers.GroupQuestionSubmitOperation;
import com.venturenix.cmc.entity.GroupQuestionSubmit;
import com.venturenix.cmc.payload.request.GroupQuestionSubmitRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.GroupQuestionSubmitRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupQuestionSubmitController
    implements GroupQuestionSubmitOperation {
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
  GroupQuestionSubmitRepository groupquestionsubmitRepository;


  public ResponseEntity<?> addGroupQuestionSubmit(
      GroupQuestionSubmitRequest groupquestionsubmitRequest) {
    GroupQuestionSubmit groupquestionsubmit = new GroupQuestionSubmit(
        groupquestionsubmitRequest.getEventid(),
        groupquestionsubmitRequest.getGroupid(),
        groupquestionsubmitRequest.getQuestionid(),
        groupquestionsubmitRequest.getUserid(),
        groupquestionsubmitRequest.getSubmittime(),
        groupquestionsubmitRequest.getRuntimebymsec(),
        groupquestionsubmitRequest.getStatus(), java.time.LocalDateTime.now(),
        groupquestionsubmitRequest.getCreatedby(),
        java.time.LocalDateTime.now(),
        groupquestionsubmitRequest.getUpdatedby());
    groupquestionsubmitRepository.save(groupquestionsubmit);
    return ResponseEntity
        .ok(new MessageResponse("Add GroupQuestionSubmit successfully!"));

  }

  public ResponseEntity<List<GroupQuestionSubmit>> getAllGroupQuestionSubmits() {
    try {
      List<GroupQuestionSubmit> groupquestionsubmits =
          new ArrayList<GroupQuestionSubmit>();
      groupquestionsubmitRepository.findAll()
          .forEach(groupquestionsubmits::add);
      if (groupquestionsubmits.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(groupquestionsubmits, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<GroupQuestionSubmit> getGroupQuestionSubmitById(
      long id) {
    Optional<GroupQuestionSubmit> groupquestionsubmitData =
        groupquestionsubmitRepository.findById(id);
    if (groupquestionsubmitData.isPresent()) {
      return new ResponseEntity<>(groupquestionsubmitData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<GroupQuestionSubmit> updateGroupQuestionSubmit(long id,
      GroupQuestionSubmit groupquestionsubmit) {
    Optional<GroupQuestionSubmit> groupquestionsubmitData =
        groupquestionsubmitRepository.findById(id);

    if (groupquestionsubmitData.isPresent()) {
      GroupQuestionSubmit _groupquestionsubmit = groupquestionsubmitData.get();
      _groupquestionsubmit.setEventid(groupquestionsubmit.getEventid());
      _groupquestionsubmit.setGroupid(groupquestionsubmit.getGroupid());
      _groupquestionsubmit.setQuestionid(groupquestionsubmit.getQuestionid());
      _groupquestionsubmit.setUserid(groupquestionsubmit.getUserid());
      _groupquestionsubmit.setStatus(groupquestionsubmit.getStatus());
      _groupquestionsubmit.setSubmittime(groupquestionsubmit.getSubmittime());
      _groupquestionsubmit
          .setRuntimebymsec(groupquestionsubmit.getRuntimebymsec());
      _groupquestionsubmit.setUpdateddate(java.time.LocalDateTime.now());
      _groupquestionsubmit.setUpdatedby(groupquestionsubmit.getUpdatedby());
      return new ResponseEntity<>(
          groupquestionsubmitRepository.save(_groupquestionsubmit),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteGroupQuestionSubmit(long id) {
    try {
      groupquestionsubmitRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse(
          "Delete GroupQuestionSubmit " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}

