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
import com.venturenix.cmc.models.EventQuestion;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.EventQuestionRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.EventQuestionResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.EventQuestionRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventQuestionController {
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
  EventQuestionRepository eventQuestionRepository;


@PostMapping("/eventquestion/add")
  public ResponseEntity<?> addEventQuestion(@Valid @RequestBody EventQuestionRequest eventQuestionRequest) {
    EventQuestion eventQuestion = new EventQuestion(
               eventQuestionRequest.getQuestionid(),
               eventQuestionRequest.getEventid(), 
               eventQuestionRequest.getStatus(),
               java.time.LocalDateTime.now(),
               eventQuestionRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               eventQuestionRequest.getUpdatedby()
               );
    eventQuestionRepository.save(eventQuestion);
    return ResponseEntity.ok(new MessageResponse("Add Event Question successfully!"));
    
  }

  @GetMapping("/eventquestions")
  public ResponseEntity<List<EventQuestion>> getAllEventQuestions() {
    try {
        List<EventQuestion> eventQuestions = new ArrayList<EventQuestion>();
        eventQuestionRepository.findAll().forEach(eventQuestions::add);        
        if (eventQuestions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(eventQuestions, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/eventquestion/{id}")
  public ResponseEntity<EventQuestion> getEventQuestionById(@PathVariable("id") long id) {
    Optional<EventQuestion> eventQuestionData = eventQuestionRepository.findById(id);
    if (eventQuestionData.isPresent()) {
      return new ResponseEntity<>(eventQuestionData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/eventquestion/{id}")
  public ResponseEntity<EventQuestion> updateEventQuestion(@PathVariable("id") long id, @RequestBody EventQuestion eventQuestion) {
    Optional<EventQuestion> eventQuestionData = eventQuestionRepository.findById(id);

    if (eventQuestionData.isPresent()) {
      EventQuestion _eventQuestion = eventQuestionData.get();
      _eventQuestion.setQuestionid(eventQuestion.getQuestionid());
      _eventQuestion.setEventid(eventQuestion.getEventid());
      _eventQuestion.setStatus(eventQuestion.getStatus());
      _eventQuestion.setUpdateddate(java.time.LocalDateTime.now());
      _eventQuestion.setUpdatedby(eventQuestion.getUpdatedby());
      return new ResponseEntity<>(eventQuestionRepository.save(_eventQuestion), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/eventquestion/{id}")
  public ResponseEntity<?> deleteEventQuestion(@PathVariable("id") long id) {
    try {
      eventQuestionRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete Event Question " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
