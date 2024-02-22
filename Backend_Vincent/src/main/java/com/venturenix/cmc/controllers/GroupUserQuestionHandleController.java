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
import com.venturenix.cmc.models.GroupUserQuestionHandle;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.GroupUserQuestionHandleRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.GroupUserQuestionHandleResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.GroupUserQuestionHandleRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupUserQuestionHandleController {
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


@PostMapping("/groupuserquestionhandle/add")
  public ResponseEntity<?> addGroupUserQuestionHandle(@Valid @RequestBody GroupUserQuestionHandleRequest groupuserquestionhandleRequest) {
    GroupUserQuestionHandle groupuserquestionhandle = new GroupUserQuestionHandle(
               groupuserquestionhandleRequest.getEventid(), 
               groupuserquestionhandleRequest.getGroupid(), 
               groupuserquestionhandleRequest.getUserlist(), 
               groupuserquestionhandleRequest.getQuestionid(), 
               groupuserquestionhandleRequest.getStatus(),
               java.time.LocalDateTime.now(),
               groupuserquestionhandleRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               groupuserquestionhandleRequest.getUpdatedby()
               );
    groupuserquestionhandleRepository.save(groupuserquestionhandle);
    return ResponseEntity.ok(new MessageResponse("Add GroupUserQuestionHandle successfully!"));
    
  }

  @GetMapping("/groupuserquestionhandles")
  public ResponseEntity<List<GroupUserQuestionHandle>> getAllGroupUserQuestionHandles() {
    try {
        List<GroupUserQuestionHandle> groupuserquestionhandles = new ArrayList<GroupUserQuestionHandle>();
        groupuserquestionhandleRepository.findAll().forEach(groupuserquestionhandles::add);        
        if (groupuserquestionhandles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groupuserquestionhandles, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/groupuserquestionhandle/{id}")
  public ResponseEntity<GroupUserQuestionHandle> getGroupUserQuestionHandleById(@PathVariable("id") long id) {
    Optional<GroupUserQuestionHandle> groupuserquestionhandleData = groupuserquestionhandleRepository.findById(id);
    if (groupuserquestionhandleData.isPresent()) {
      return new ResponseEntity<>(groupuserquestionhandleData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/groupuserquestionhandle/{id}")
  public ResponseEntity<GroupUserQuestionHandle> updateGroupUserQuestionHandle(@PathVariable("id") long id, @RequestBody GroupUserQuestionHandle groupuserquestionhandle) {
    Optional<GroupUserQuestionHandle> groupuserquestionhandleData = groupuserquestionhandleRepository.findById(id);

    if (groupuserquestionhandleData.isPresent()) {
      GroupUserQuestionHandle _groupuserquestionhandle = groupuserquestionhandleData.get();
      _groupuserquestionhandle.setEventid(groupuserquestionhandle.getEventid());
      _groupuserquestionhandle.setGroupid(groupuserquestionhandle.getGroupid());
      _groupuserquestionhandle.setUserlist(groupuserquestionhandle.getUserlist());
      _groupuserquestionhandle.setQuestionid(groupuserquestionhandle.getQuestionid());
      _groupuserquestionhandle.setUpdateddate(java.time.LocalDateTime.now());
      _groupuserquestionhandle.setUpdatedby(groupuserquestionhandle.getUpdatedby());
      return new ResponseEntity<>(groupuserquestionhandleRepository.save(_groupuserquestionhandle), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/groupuserquestionhandle/{id}")
  public ResponseEntity<?> deleteGroupUserQuestionHandle(@PathVariable("id") long id) {
    try {
      groupuserquestionhandleRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete GroupUserQuestionHandle " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}

