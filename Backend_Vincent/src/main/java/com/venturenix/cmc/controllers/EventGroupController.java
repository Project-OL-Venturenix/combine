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
import com.venturenix.cmc.models.EventGroup;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.EventGroupRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.EventGroupResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.EventGroupRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventGroupController {
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
  EventGroupRepository eventGroupRepository;


@PostMapping("/eventgroup/add")
  public ResponseEntity<?> addEventGroup(@Valid @RequestBody EventGroupRequest eventGroupRequest) {
    EventGroup eventGroup = new EventGroup(
               eventGroupRequest.getGroupid(),
               eventGroupRequest.getEventid(), 
               eventGroupRequest.getStatus(),
               java.time.LocalDateTime.now(),
               eventGroupRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               eventGroupRequest.getUpdatedby()
               );
    eventGroupRepository.save(eventGroup);
    return ResponseEntity.ok(new MessageResponse("Add Event Group successfully!"));
    
  }

  @GetMapping("/eventgroups")
  public ResponseEntity<List<EventGroup>> getAllEventGroups() {
    try {
        List<EventGroup> eventGroups = new ArrayList<EventGroup>();
        eventGroupRepository.findAll().forEach(eventGroups::add);        
        if (eventGroups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(eventGroups, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/eventgroup/{id}")
  public ResponseEntity<EventGroup> getEventGroupById(@PathVariable("id") long id) {
    Optional<EventGroup> eventGroupData = eventGroupRepository.findById(id);
    if (eventGroupData.isPresent()) {
      return new ResponseEntity<>(eventGroupData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/eventgroup/{id}")
  public ResponseEntity<EventGroup> updateEventGroup(@PathVariable("id") long id, @RequestBody EventGroup eventGroup) {
    Optional<EventGroup> eventGroupData = eventGroupRepository.findById(id);

    if (eventGroupData.isPresent()) {
      EventGroup _eventGroup = eventGroupData.get();
      _eventGroup.setGroupid(eventGroup.getGroupid());
      _eventGroup.setEventid(eventGroup.getEventid());
      _eventGroup.setStatus(eventGroup.getStatus());
      _eventGroup.setUpdateddate(java.time.LocalDateTime.now());
      _eventGroup.setUpdatedby(eventGroup.getUpdatedby());
      return new ResponseEntity<>(eventGroupRepository.save(_eventGroup), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/eventgroup/{id}")
  public ResponseEntity<?> deleteEventGroup(@PathVariable("id") long id) {
    try {
      eventGroupRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete Event Group " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
