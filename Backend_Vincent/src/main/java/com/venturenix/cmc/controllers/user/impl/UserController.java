package com.venturenix.cmc.controllers.user.impl;

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
import com.venturenix.cmc.controllers.user.UserOperation;
import com.venturenix.cmc.entity.event.Event;
import com.venturenix.cmc.entity.user.User;
import com.venturenix.cmc.payload.request.UserRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.event.EventRepository;
import com.venturenix.cmc.repository.user.RoleRepository;
import com.venturenix.cmc.repository.user.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController implements UserOperation {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  EventRepository eventRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  public ResponseEntity<?> addUser(UserRequest userRequest) {
    User builder = User.builder()//
        .firstName(userRequest.getFirstName())//
        .lastName(userRequest.getLastName())//
        .mobile(userRequest.getMobile())//
        .email(userRequest.getEmail())//
        .userName(userRequest.getUserName())//
        .password(encoder.encode(userRequest.getPassword()))//
        .company(userRequest.getCompany())//
        .title(userRequest.getTitle())//
        .pyExperience(userRequest.getPy_experience())//
        .jvExperience(userRequest.getJv_experience())//
        .jsExperience(userRequest.getJs_experience())//
        .csExperience(userRequest.getCs_experience())//
        .saExperience(userRequest.getSa_experience())//
        .status(userRequest.getStatus())//
        .createdDate(LocalDateTime.now())//
        .createdBy(userRequest.getCreatedBy())//
        .updatedDate(LocalDateTime.now())//
        .updatedBy(userRequest.getUpdatedBy())//
        .build();

    userRepository.save(builder);
    return ResponseEntity.ok(new MessageResponse("Add User successfully!"));

  }

  public ResponseEntity<List<User>> getAllUsers() {
    try {
      List<User> users = userRepository.findAll();
      if (users.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(users, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<User> getUserById(long id) {
    Optional<User> userData = userRepository.findById(id);
    if (userData.isPresent()) {
      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<User> updateUser(long id, User userRequest) {
    Optional<User> userData = userRepository.findById(id);

    if (userData.isPresent()) {
      User builder = User.builder()//
          .firstName(userRequest.getFirstName())//
          .lastName(userRequest.getLastName())//
          .mobile(userRequest.getMobile())//
          .email(userRequest.getEmail())//
          .userName(userRequest.getUserName())//
          .password(encoder.encode(userRequest.getPassword()))//
          .company(userRequest.getCompany())//
          .title(userRequest.getTitle())//
          .pyExperience(userRequest.getPyExperience())//
          .jvExperience(userRequest.getJvExperience())//
          .jsExperience(userRequest.getJsExperience())//
          .csExperience(userRequest.getCsExperience())//
          .saExperience(userRequest.getSaExperience())//
          .status(userRequest.getStatus())//
          .createdDate(LocalDateTime.now())//
          .createdBy(userRequest.getCreatedBy())//
          .updatedDate(LocalDateTime.now())//
          .updatedBy(userRequest.getUpdatedBy())//
          .build();
      return new ResponseEntity<>(userRepository.save(builder), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteUser(long id) {
    try {
      userRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete User " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }

  @Override
  public ResponseEntity<?> addUserInEvent(Long userId, Long eventId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    Optional<Event> optionalEvent = eventRepository.findById(eventId);
    if (optionalUser.isPresent() && optionalEvent.isPresent()) {
      User user = optionalUser.get();
      Event event = optionalEvent.get();
      user.getEvents().add(event);
      userRepository.save(user);
      return ResponseEntity
          .ok(new MessageResponse("User added to event successfully!"));
    } else {
      return ResponseEntity.ok(new MessageResponse("User or event not found!"));
    }

  }
}

