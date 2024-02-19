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
import com.venturenix.cmc.models.GroupTestCase;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.GroupTestCaseRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.GroupTestCaseResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.GroupTestCaseRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupTestCaseController {
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
  GroupTestCaseRepository grouptestcaseRepository;


@PostMapping("/grouptestcase/add")
  public ResponseEntity<?> addGroupTestCase(@Valid @RequestBody GroupTestCaseRequest grouptestcaseRequest) {
    GroupTestCase grouptestcase = new GroupTestCase(
               grouptestcaseRequest.getEventid(), 
               grouptestcaseRequest.getGroupid(), 
               grouptestcaseRequest.getQuestionid(), 
               grouptestcaseRequest.getTestcaseid(), 
               grouptestcaseRequest.getUserid(), 
               grouptestcaseRequest.getRuntimebysec(), 
               grouptestcaseRequest.getTestcasepassstatus(), 
               grouptestcaseRequest.getStatus(),
               java.time.LocalDateTime.now(),
               grouptestcaseRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               grouptestcaseRequest.getUpdatedby()
               );
    grouptestcaseRepository.save(grouptestcase);
    return ResponseEntity.ok(new MessageResponse("Add GroupTestCase successfully!"));
    
  }

  @GetMapping("/grouptestcases")
  public ResponseEntity<List<GroupTestCase>> getAllGroupTestCases() {
    try {
        List<GroupTestCase> grouptestcases = new ArrayList<GroupTestCase>();
        grouptestcaseRepository.findAll().forEach(grouptestcases::add);        
        if (grouptestcases.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(grouptestcases, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/grouptestcase/{id}")
  public ResponseEntity<GroupTestCase> getGroupTestCaseById(@PathVariable("id") long id) {
    Optional<GroupTestCase> grouptestcaseData = grouptestcaseRepository.findById(id);
    if (grouptestcaseData.isPresent()) {
      return new ResponseEntity<>(grouptestcaseData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/grouptestcase/{id}")
  public ResponseEntity<GroupTestCase> updateGroupTestCase(@PathVariable("id") long id, @RequestBody GroupTestCase grouptestcase) {
    Optional<GroupTestCase> grouptestcaseData = grouptestcaseRepository.findById(id);

    if (grouptestcaseData.isPresent()) {
      GroupTestCase _grouptestcase = grouptestcaseData.get();
      _grouptestcase.setEventid(grouptestcase.getEventid());
      _grouptestcase.setGroupid(grouptestcase.getGroupid());
      _grouptestcase.setQuestionid(grouptestcase.getQuestionid());
      _grouptestcase.setTestcaseid(grouptestcase.getTestcaseid());
      _grouptestcase.setUserid(grouptestcase.getUserid());
      _grouptestcase.setRuntimebysec(grouptestcase.getRuntimebysec());
      _grouptestcase.setTestcasepassstatus(grouptestcase.getTestcasepassstatus());
      _grouptestcase.setStatus(grouptestcase.getStatus());
      _grouptestcase.setUpdateddate(java.time.LocalDateTime.now());
      _grouptestcase.setUpdatedby(grouptestcase.getUpdatedby());
      return new ResponseEntity<>(grouptestcaseRepository.save(_grouptestcase), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/grouptestcase/{id}")
  public ResponseEntity<?> deleteGroupTestCase(@PathVariable("id") long id) {
    try {
      grouptestcaseRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete GroupTestCase " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
