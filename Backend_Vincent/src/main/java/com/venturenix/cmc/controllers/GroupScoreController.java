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
import com.venturenix.cmc.models.GroupScore;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.GroupScoreRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.GroupScoreResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.GroupScoreRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupScoreController {
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
  GroupScoreRepository groupscoreRepository;


@PostMapping("/groupscore/add")
  public ResponseEntity<?> addGroupScore(@Valid @RequestBody GroupScoreRequest groupscoreRequest) {
    GroupScore groupscore = new GroupScore(
               groupscoreRequest.getEventid(), 
               groupscoreRequest.getGroupid(), 
               groupscoreRequest.getQuestionid(), 
               groupscoreRequest.getTestcasepasstotal(), 
               groupscoreRequest.getTestcasescoretotal(), 
               groupscoreRequest.getTestcasetotal(), 
               groupscoreRequest.getStatus(),
               java.time.LocalDateTime.now(),
               groupscoreRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               groupscoreRequest.getUpdatedby()
               );
    groupscoreRepository.save(groupscore);
    return ResponseEntity.ok(new MessageResponse("Add GroupScore successfully!"));
    
  }

  @GetMapping("/groupscores")
  public ResponseEntity<List<GroupScore>> getAllGroupScores() {
    try {
        List<GroupScore> groupscores = new ArrayList<GroupScore>();
        groupscoreRepository.findAll().forEach(groupscores::add);        
        if (groupscores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groupscores, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/groupscore/{id}")
  public ResponseEntity<GroupScore> getGroupScoreById(@PathVariable("id") long id) {
    Optional<GroupScore> groupscoreData = groupscoreRepository.findById(id);
    if (groupscoreData.isPresent()) {
      return new ResponseEntity<>(groupscoreData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/groupscore/{id}")
  public ResponseEntity<GroupScore> updateGroupScore(@PathVariable("id") long id, @RequestBody GroupScore groupscore) {
    Optional<GroupScore> groupscoreData = groupscoreRepository.findById(id);

    if (groupscoreData.isPresent()) {
      GroupScore _groupscore = groupscoreData.get();
      _groupscore.setEventid(groupscore.getEventid());
      _groupscore.setGroupid(groupscore.getGroupid());
      _groupscore.setQuestionid(groupscore.getQuestionid());
      _groupscore.setTestcasepasstotal(groupscore.getTestcasepasstotal());
      _groupscore.setTestcasescoretotal(groupscore.getTestcasescoretotal());
      _groupscore.setTestcasetotal(groupscore.getTestcasetotal());
      _groupscore.setStatus(groupscore.getStatus());
      _groupscore.setUpdateddate(java.time.LocalDateTime.now());
      _groupscore.setUpdatedby(groupscore.getUpdatedby());
      return new ResponseEntity<>(groupscoreRepository.save(_groupscore), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/groupscore/{id}")
  public ResponseEntity<?> deleteGroupScore(@PathVariable("id") long id) {
    try {
      groupscoreRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete GroupScore " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
