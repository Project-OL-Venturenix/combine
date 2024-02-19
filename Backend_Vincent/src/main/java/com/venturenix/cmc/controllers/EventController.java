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
import com.venturenix.cmc.models.Event;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.EventRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.EventResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.EventRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventController {
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
  EventRepository eventRepository;


@PostMapping("/event/add")
  public ResponseEntity<?> addEvent(@Valid @RequestBody EventRequest eventRequest) {
    Event event = new Event(eventRequest.getName(), 
               eventRequest.getStatus(),
               java.time.LocalDateTime.now(),
               eventRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               eventRequest.getUpdatedby()
               );
    eventRepository.save(event);
    return ResponseEntity.ok(new MessageResponse("Add Event successfully!"));
    
  }

  @GetMapping("/events")
  public ResponseEntity<List<Event>> getAllEvents() {
    try {
        List<Event> events = new ArrayList<Event>();
        eventRepository.findAll().forEach(events::add);        
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/event/{id}")
  public ResponseEntity<Event> getEventById(@PathVariable("id") long id) {
    Optional<Event> eventData = eventRepository.findById(id);
    if (eventData.isPresent()) {
      return new ResponseEntity<>(eventData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/event/{id}")
  public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event event) {
    Optional<Event> eventData = eventRepository.findById(id);

    if (eventData.isPresent()) {
      Event _event = eventData.get();
      _event.setName(event.getName());
      _event.setStatus(event.getStatus());
      _event.setUpdateddate(java.time.LocalDateTime.now());
      _event.setUpdatedby(event.getUpdatedby());
      return new ResponseEntity<>(eventRepository.save(_event), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/event/{id}")
  public ResponseEntity<?> deleteEvent(@PathVariable("id") long id) {
    try {
      eventRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete Event " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
