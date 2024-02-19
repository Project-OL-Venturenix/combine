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
import com.venturenix.cmc.models.EventUser;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.EventUserRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.EventUserResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.EventUserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventUserController {
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
  EventUserRepository eventUserRepository;


@PostMapping("/eventuser/add")
  public ResponseEntity<?> addEventUser(@Valid @RequestBody EventUserRequest eventUserRequest) {
    EventUser eventUser = new EventUser(
               eventUserRequest.getUserid(),
               eventUserRequest.getEventid(), 
               eventUserRequest.getStatus(),
               java.time.LocalDateTime.now(),
               eventUserRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               eventUserRequest.getUpdatedby()
               );
    eventUserRepository.save(eventUser);
    return ResponseEntity.ok(new MessageResponse("Add Event User successfully!"));
    
  }

  @GetMapping("/eventusers")
  public ResponseEntity<List<EventUser>> getAllEventUsers() {
    try {
        List<EventUser> eventUsers = new ArrayList<EventUser>();
        eventUserRepository.findAll().forEach(eventUsers::add);        
        if (eventUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(eventUsers, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/eventuser/{id}")
  public ResponseEntity<EventUser> getEventUserById(@PathVariable("id") long id) {
    Optional<EventUser> eventUserData = eventUserRepository.findById(id);
    if (eventUserData.isPresent()) {
      return new ResponseEntity<>(eventUserData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/eventuser/{id}")
  public ResponseEntity<EventUser> updateEventUser(@PathVariable("id") long id, @RequestBody EventUser eventUser) {
    Optional<EventUser> eventUserData = eventUserRepository.findById(id);

    if (eventUserData.isPresent()) {
      EventUser _eventUser = eventUserData.get();
      _eventUser.setUserid(eventUser.getUserid());
      _eventUser.setEventid(eventUser.getEventid());
      _eventUser.setStatus(eventUser.getStatus());
      _eventUser.setUpdateddate(java.time.LocalDateTime.now());
      _eventUser.setUpdatedby(eventUser.getUpdatedby());
      return new ResponseEntity<>(eventUserRepository.save(_eventUser), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/eventuser/{id}")
  public ResponseEntity<?> deleteEventUser(@PathVariable("id") long id) {
    try {
      eventUserRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete Event User " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
