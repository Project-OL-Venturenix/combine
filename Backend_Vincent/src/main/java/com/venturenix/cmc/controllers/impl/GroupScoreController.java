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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.GroupScoreOperation;
import com.venturenix.cmc.entity.GroupScore;
import com.venturenix.cmc.payload.request.GroupScoreRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.GroupScoreRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupScoreController implements GroupScoreOperation {
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


  public ResponseEntity<?> addGroupScore(GroupScoreRequest groupscoreRequest) {
    GroupScore groupscore = new GroupScore(groupscoreRequest.getEventid(),
        groupscoreRequest.getGroupid(), groupscoreRequest.getQuestionid(),
        groupscoreRequest.getTestcasepasstotal(),
        groupscoreRequest.getTestcasescoretotal(),
        groupscoreRequest.getTestcasetotal(), groupscoreRequest.getStatus(),
        java.time.LocalDateTime.now(), groupscoreRequest.getCreatedby(),
        java.time.LocalDateTime.now(), groupscoreRequest.getUpdatedby());
    groupscoreRepository.save(groupscore);
    return ResponseEntity
        .ok(new MessageResponse("Add GroupScore successfully!"));

  }

  public ResponseEntity<List<GroupScore>> getAllGroupScores() {
    try {
      List<GroupScore> groupscores = new ArrayList<GroupScore>();
      groupscoreRepository.findAll().forEach(groupscores::add);
      if (groupscores.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(groupscores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<GroupScore> getGroupScoreById(long id) {
    Optional<GroupScore> groupscoreData = groupscoreRepository.findById(id);
    if (groupscoreData.isPresent()) {
      return new ResponseEntity<>(groupscoreData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<GroupScore> updateGroupScore(long id,
      GroupScore groupscore) {
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
      return new ResponseEntity<>(groupscoreRepository.save(_groupscore),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteGroupScore(long id) {
    try {
      groupscoreRepository.deleteById(id);
      return ResponseEntity.ok(
          new MessageResponse("Delete GroupScore " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
