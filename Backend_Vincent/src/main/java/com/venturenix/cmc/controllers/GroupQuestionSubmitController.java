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
import com.venturenix.cmc.models.GroupQuestionSubmit;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.GroupQuestionSubmitRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.GroupQuestionSubmitResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.GroupQuestionSubmitRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupQuestionSubmitController {
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


@PostMapping("/groupquestionsubmit/add")
  public ResponseEntity<?> addGroupQuestionSubmit(@Valid @RequestBody GroupQuestionSubmitRequest groupquestionsubmitRequest) {
    GroupQuestionSubmit groupquestionsubmit = new GroupQuestionSubmit(
               groupquestionsubmitRequest.getEventid(), 
               groupquestionsubmitRequest.getGroupid(), 
               groupquestionsubmitRequest.getQuestionid(), 
               groupquestionsubmitRequest.getUserid(), 
               groupquestionsubmitRequest.getSubmittime(), 
               groupquestionsubmitRequest.getRuntimebymsec(), 
               groupquestionsubmitRequest.getStatus(),
               java.time.LocalDateTime.now(),
               groupquestionsubmitRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               groupquestionsubmitRequest.getUpdatedby()
               );
    groupquestionsubmitRepository.save(groupquestionsubmit);
    return ResponseEntity.ok(new MessageResponse("Add GroupQuestionSubmit successfully!"));
    
  }

  @GetMapping("/groupquestionsubmits")
  public ResponseEntity<List<GroupQuestionSubmit>> getAllGroupQuestionSubmits() {
    try {
        List<GroupQuestionSubmit> groupquestionsubmits = new ArrayList<GroupQuestionSubmit>();
        groupquestionsubmitRepository.findAll().forEach(groupquestionsubmits::add);        
        if (groupquestionsubmits.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groupquestionsubmits, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/groupquestionsubmit/{id}")
  public ResponseEntity<GroupQuestionSubmit> getGroupQuestionSubmitById(@PathVariable("id") long id) {
    Optional<GroupQuestionSubmit> groupquestionsubmitData = groupquestionsubmitRepository.findById(id);
    if (groupquestionsubmitData.isPresent()) {
      return new ResponseEntity<>(groupquestionsubmitData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/groupquestionsubmit/{id}")
  public ResponseEntity<GroupQuestionSubmit> updateGroupQuestionSubmit(@PathVariable("id") long id, @RequestBody GroupQuestionSubmit groupquestionsubmit) {
    Optional<GroupQuestionSubmit> groupquestionsubmitData = groupquestionsubmitRepository.findById(id);

    if (groupquestionsubmitData.isPresent()) {
      GroupQuestionSubmit _groupquestionsubmit = groupquestionsubmitData.get();
      _groupquestionsubmit.setEventid(groupquestionsubmit.getEventid());
      _groupquestionsubmit.setGroupid(groupquestionsubmit.getGroupid());
      _groupquestionsubmit.setQuestionid(groupquestionsubmit.getQuestionid());
      _groupquestionsubmit.setUserid(groupquestionsubmit.getUserid());
      _groupquestionsubmit.setStatus(groupquestionsubmit.getStatus());
      _groupquestionsubmit.setSubmittime(groupquestionsubmit.getSubmittime());
      _groupquestionsubmit.setRuntimebymsec(groupquestionsubmit.getRuntimebymsec());
      _groupquestionsubmit.setUpdateddate(java.time.LocalDateTime.now());
      _groupquestionsubmit.setUpdatedby(groupquestionsubmit.getUpdatedby());
      return new ResponseEntity<>(groupquestionsubmitRepository.save(_groupquestionsubmit), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/groupquestionsubmit/{id}")
  public ResponseEntity<?> deleteGroupQuestionSubmit(@PathVariable("id") long id) {
    try {
      groupquestionsubmitRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete GroupQuestionSubmit " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}

