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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.GroupUserQuestionHandleOperation;
import com.venturenix.cmc.entity.GroupUserQuestionHandle;
import com.venturenix.cmc.payload.request.GroupUserQuestionHandleRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.GroupUserQuestionHandleRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupUserQuestionHandleController
    implements GroupUserQuestionHandleOperation {
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
  GroupUserQuestionHandleRepository groupuserquestionhandleRepository;


  public ResponseEntity<?> addGroupUserQuestionHandle(
      GroupUserQuestionHandleRequest groupuserquestionhandleRequest) {
    GroupUserQuestionHandle groupuserquestionhandle =
        new GroupUserQuestionHandle(groupuserquestionhandleRequest.getEventid(),
            groupuserquestionhandleRequest.getGroupid(),
            groupuserquestionhandleRequest.getUserlist(),
            groupuserquestionhandleRequest.getQuestionid(),
            groupuserquestionhandleRequest.getStatus(),
            java.time.LocalDateTime.now(),
            groupuserquestionhandleRequest.getCreatedby(),
            java.time.LocalDateTime.now(),
            groupuserquestionhandleRequest.getUpdatedby());
    groupuserquestionhandleRepository.save(groupuserquestionhandle);
    return ResponseEntity
        .ok(new MessageResponse("Add GroupUserQuestionHandle successfully!"));

  }

  public ResponseEntity<List<GroupUserQuestionHandle>> getAllGroupUserQuestionHandles() {
    try {
      List<GroupUserQuestionHandle> groupuserquestionhandles =
          new ArrayList<GroupUserQuestionHandle>();
      groupuserquestionhandleRepository.findAll()
          .forEach(groupuserquestionhandles::add);
      if (groupuserquestionhandles.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(groupuserquestionhandles, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<GroupUserQuestionHandle> getGroupUserQuestionHandleById(
      long id) {
    Optional<GroupUserQuestionHandle> groupuserquestionhandleData =
        groupuserquestionhandleRepository.findById(id);
    if (groupuserquestionhandleData.isPresent()) {
      return new ResponseEntity<>(groupuserquestionhandleData.get(),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<GroupUserQuestionHandle> updateGroupUserQuestionHandle(
      long id, GroupUserQuestionHandle groupuserquestionhandle) {
    Optional<GroupUserQuestionHandle> groupuserquestionhandleData =
        groupuserquestionhandleRepository.findById(id);

    if (groupuserquestionhandleData.isPresent()) {
      GroupUserQuestionHandle _groupuserquestionhandle =
          groupuserquestionhandleData.get();
      _groupuserquestionhandle.setEventid(groupuserquestionhandle.getEventid());
      _groupuserquestionhandle.setGroupid(groupuserquestionhandle.getGroupid());
      _groupuserquestionhandle
          .setUserlist(groupuserquestionhandle.getUserlist());
      _groupuserquestionhandle
          .setQuestionid(groupuserquestionhandle.getQuestionid());
      _groupuserquestionhandle.setUpdateddate(java.time.LocalDateTime.now());
      _groupuserquestionhandle
          .setUpdatedby(groupuserquestionhandle.getUpdatedby());
      return new ResponseEntity<>(
          groupuserquestionhandleRepository.save(_groupuserquestionhandle),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteGroupUserQuestionHandle(long id) {
    try {
      groupuserquestionhandleRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse(
          "Delete GroupUserQuestionHandle " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}

