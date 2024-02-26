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
import com.venturenix.cmc.controllers.EventUserOperation;
import com.venturenix.cmc.entity.EventUser;
import com.venturenix.cmc.payload.request.EventUserRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.EventUserRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventUserController implements EventUserOperation {
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


  public ResponseEntity<?> addEventUser(EventUserRequest eventUserRequest) {
    EventUser eventUser = new EventUser(eventUserRequest.getUserid(),
        eventUserRequest.getEventid(), eventUserRequest.getStatus(),
        java.time.LocalDateTime.now(), eventUserRequest.getCreatedby(),
        java.time.LocalDateTime.now(), eventUserRequest.getUpdatedby());
    eventUserRepository.save(eventUser);
    return ResponseEntity
        .ok(new MessageResponse("Add Event User successfully!"));

  }

  public ResponseEntity<List<EventUser>> getAllEventUsers() {
    try {
      List<EventUser> eventUsers = new ArrayList<EventUser>();
      eventUserRepository.findAll().forEach(eventUsers::add);
      if (eventUsers.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(eventUsers, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<EventUser> getEventUserById(long id) {
    Optional<EventUser> eventUserData = eventUserRepository.findById(id);
    if (eventUserData.isPresent()) {
      return new ResponseEntity<>(eventUserData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<EventUser> updateEventUser(long id,
      EventUser eventUser) {
    Optional<EventUser> eventUserData = eventUserRepository.findById(id);

    if (eventUserData.isPresent()) {
      EventUser _eventUser = eventUserData.get();
      _eventUser.setUserid(eventUser.getUserid());
      _eventUser.setEventid(eventUser.getEventid());
      _eventUser.setStatus(eventUser.getStatus());
      _eventUser.setUpdateddate(java.time.LocalDateTime.now());
      _eventUser.setUpdatedby(eventUser.getUpdatedby());
      return new ResponseEntity<>(eventUserRepository.save(_eventUser),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteEventUser(long id) {
    try {
      eventUserRepository.deleteById(id);
      return ResponseEntity.ok(
          new MessageResponse("Delete Event User " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
