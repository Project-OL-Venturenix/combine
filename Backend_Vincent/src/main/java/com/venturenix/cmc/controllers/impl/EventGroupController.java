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
import com.venturenix.cmc.controllers.EventGroupOperation;
import com.venturenix.cmc.entity.EventGroup;
import com.venturenix.cmc.payload.request.EventGroupRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.EventGroupRepository;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventGroupController implements EventGroupOperation {
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

  public ResponseEntity<?> addEventGroup(EventGroupRequest eventGroupRequest) {
    EventGroup eventGroup = new EventGroup(eventGroupRequest.getGroupid(),
        eventGroupRequest.getEventid(), eventGroupRequest.getStatus(),
        java.time.LocalDateTime.now(), eventGroupRequest.getCreatedby(),
        java.time.LocalDateTime.now(), eventGroupRequest.getUpdatedby());
    eventGroupRepository.save(eventGroup);
    return ResponseEntity
        .ok(new MessageResponse("Add Event Group successfully!"));

  }

  public ResponseEntity<List<EventGroup>> getAllEventGroups() {
    try {
      List<EventGroup> eventGroups = new ArrayList<EventGroup>();
      eventGroupRepository.findAll().forEach(eventGroups::add);
      if (eventGroups.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(eventGroups, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<EventGroup> getEventGroupById(long id) {
    Optional<EventGroup> eventGroupData = eventGroupRepository.findById(id);
    if (eventGroupData.isPresent()) {
      return new ResponseEntity<>(eventGroupData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<EventGroup> updateEventGroup(long id,
      EventGroup eventGroup) {
    Optional<EventGroup> eventGroupData = eventGroupRepository.findById(id);

    if (eventGroupData.isPresent()) {
      EventGroup _eventGroup = eventGroupData.get();
      _eventGroup.setGroupid(eventGroup.getGroupid());
      _eventGroup.setEventid(eventGroup.getEventid());
      _eventGroup.setStatus(eventGroup.getStatus());
      _eventGroup.setUpdateddate(java.time.LocalDateTime.now());
      _eventGroup.setUpdatedby(eventGroup.getUpdatedby());
      return new ResponseEntity<>(eventGroupRepository.save(_eventGroup),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteEventGroup(long id) {
    try {
      eventGroupRepository.deleteById(id);
      return ResponseEntity.ok(
          new MessageResponse("Delete Event Group " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
