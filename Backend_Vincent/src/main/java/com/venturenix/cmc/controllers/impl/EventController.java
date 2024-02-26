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
import com.venturenix.cmc.controllers.EventOperation;
import com.venturenix.cmc.entity.Event;
import com.venturenix.cmc.payload.request.EventRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.EventRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventController implements EventOperation {
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

  public ResponseEntity<?> addEvent(EventRequest eventRequest) {
    Event event = new Event(eventRequest.getName(), eventRequest.getStatus(),
        java.time.LocalDateTime.now(), eventRequest.getCreatedby(),
        java.time.LocalDateTime.now(), eventRequest.getUpdatedby());
    eventRepository.save(event);
    return ResponseEntity.ok(new MessageResponse("Add Event successfully!"));

  }

  public ResponseEntity<List<Event>> getAllEvents() {
    try {
      List<Event> events = new ArrayList<Event>();
      eventRepository.findAll().forEach(events::add);
      if (events.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(events, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<Event> getEventById(long id) {
    Optional<Event> eventData = eventRepository.findById(id);
    if (eventData.isPresent()) {
      return new ResponseEntity<>(eventData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Event> updateEvent(long id, Event event) {
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

  public ResponseEntity<?> deleteEvent(long id) {
    try {
      eventRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete Event " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
