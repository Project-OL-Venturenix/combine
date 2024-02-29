package com.venturenix.cmc.controllers.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.UserScoreOperation;
import com.venturenix.cmc.entity.UserScore;
import com.venturenix.cmc.payload.request.UserScoreRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.EventRepository;
import com.venturenix.cmc.repository.QuestionRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.UserScoreRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserScoreController implements UserScoreOperation {
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
  UserScoreRepository userscoreRepository;

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private QuestionRepository questionRepository;

  public ResponseEntity<?> addUserScore(UserScoreRequest userscoreRequest) {
    UserScore userscore = UserScore.builder()
        .eventid(userscoreRequest.getEventid())
        .userid(userscoreRequest.getUserid())
        .questionid(userscoreRequest.getQuestionid())
        .testcasePassTotal(userscoreRequest.getTestcasepasstotal())
        .testcaseScoreTotal(userscoreRequest.getTestcasescoretotal())
        .status(userscoreRequest.getTestcasepasstotal() == 10 ? "Pass" : "Fail")//
        .createddate(java.time.LocalDateTime.now())
        .createdby(userscoreRequest.getCreatedby())
        .updateddate(java.time.LocalDateTime.now())
        .updatedby(userscoreRequest.getUpdatedby()).build();

    userscoreRepository.save(userscore);
    return ResponseEntity
        .ok(new MessageResponse("Add UserScore successfully!"));

  }

  public ResponseEntity<List<UserScore>> getAllUserScores() {
    try {
      List<UserScore> userscores = new ArrayList<UserScore>();
      userscoreRepository.findAll().forEach(userscores::add);
      if (userscores.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(userscores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<UserScore> getUserScoreById(long id) {
    Optional<UserScore> userscoreData = userscoreRepository.findById(id);
    if (userscoreData.isPresent()) {
      return new ResponseEntity<>(userscoreData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<UserScore> updateUserScore(long id,
      UserScore userscore) {
    Optional<UserScore> userscoreData = userscoreRepository.findById(id);

    if (userscoreData.isPresent()) {
      UserScore _userscore = userscoreData.get();
      _userscore.setEventid(userscore.getEventid());
      _userscore.setUserid(userscore.getUserid());
      _userscore.setQuestionid(userscore.getQuestionid());
      _userscore.setTestcasescoretotal(userscore.getTestcasescoretotal());
      _userscore.setStatus(userscore.getStatus());
      _userscore.setUpdateddate(java.time.LocalDateTime.now());
      _userscore.setUpdatedby(userscore.getUpdatedby());
      return new ResponseEntity<>(userscoreRepository.save(_userscore),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteUserScore(long id) {
    try {
      userscoreRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete UserScore " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }

  @Override
  public boolean addScore(String eventid, String userid, String questionid,
      String testcasePassTotal) {
    Long eventID = Long.valueOf(eventid);
    Long userID = Long.valueOf(userid);
    Long questionID = Long.valueOf(questionid);
    Integer testcasePass = Integer.valueOf(testcasePassTotal);
    if (eventRepository.findById(eventID).isPresent()
        && userRepository.findById(userID).isPresent()
        && questionRepository.findById(questionID).isPresent()) {
      userscoreRepository.saveAndFlush(UserScore.builder()//
          .eventid(eventID)//
          .userid(userID)//
          .questionid(questionID)//
          .testcasePassTotal(testcasePass)//
          .testcaseScoreTotal(0.0)//
          .status(testcasePass == 10 ? "Pass" : "Fail")//
          .createddate(LocalDateTime.now())//
          .updateddate(LocalDateTime.now())//
          .build());
      return true;
    } else {
      return false;
    }
  }
}
