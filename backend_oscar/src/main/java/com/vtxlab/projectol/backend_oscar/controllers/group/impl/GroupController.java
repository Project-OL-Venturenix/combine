package com.vtxlab.projectol.backend_oscar.controllers.group.impl;

import java.util.HashMap;
import java.util.HashSet;
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
import com.vtxlab.projectol.backend_oscar.controllers.group.GroupOperation;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.entity.group.Group;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import com.vtxlab.projectol.backend_oscar.payload.response.group.GroupUserDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.user.MessageResponse;
import com.vtxlab.projectol.backend_oscar.repository.event.EventRepository;
import com.vtxlab.projectol.backend_oscar.repository.group.GroupRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.RoleRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.UserRepository;
import com.vtxlab.projectol.backend_oscar.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupController implements GroupOperation {
  @Autowired
  AuthenticationManager authenticationManager;


  @Autowired
  UserRepository userRepository;

  @Autowired
  EventRepository eventRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  GroupRepository groupRepository;

  // public ResponseEntity<?> addGroup(
  // @Valid @RequestBody GroupRequest groupRequest) {
  // Group builder = Group.builder()//
  // .name(groupRequest.getName())//
  // .status(groupRequest.getStatus())//
  // .createdBy(groupRequest.getCreatedBy())//
  // .createdDate(LocalDateTime.now())//
  // .updatedBy(groupRequest.getUpdatedBy())//
  // .updatedDate(LocalDateTime.now())//
  // .build();

  // groupRepository.save(builder);
  // return ResponseEntity.ok(new MessageResponse("Add Group successfully!"));

  // }

  @Override
  public ResponseEntity<List<Group>> getAllGroups() {
    try {
      List<Group> groups = groupRepository.findAll();
      if (groups.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(groups, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  @Override
  public ResponseEntity<GroupUserDTO> getGroupById(String groupId) {
    List<Group> groupData =
        groupRepository.findByGroupsId(Long.valueOf(groupId));
    log.info("groupData: {}", groupData);
    GroupUserDTO builder = GroupUserDTO.builder()//
        .groupId(Long.valueOf(groupId))//
        .users(new HashMap<>())//
        .build();

    for (Group group : groupData) {
      for (User user : group.getUsers()) {
        builder.getUsers().put(user.getId(), user.getUserName());
      }
    }
    return new ResponseEntity<>(builder, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Group> updateGroup(long id, Group group) {
    Optional<Group> groupData = groupRepository.findById(id);

    if (groupData.isPresent()) {
      Group _group = groupData.get();
      _group.setName(group.getName());
      _group.setStatus(group.getStatus());
      _group.setUpdatedDate(java.time.LocalDateTime.now());
      _group.setUpdatedBy(group.getUpdatedBy());
      return new ResponseEntity<>(groupRepository.save(_group), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseEntity<?> deleteGroup(long id) {
    try {
      groupRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete Group " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }

  @Override
  public boolean addGroup(String eventID, String userID, String groupId) {
    Optional<User> user = userRepository.findById(Long.valueOf(userID));
    Optional<Event> event = eventRepository.findById(Long.valueOf(eventID));
    if (!user.isPresent() || !event.isPresent()) {
      return false;
    }
    Group builder = Group.builder()//
        .groupsId(Long.valueOf(groupId))//
        .users(new HashSet<>())//
        .events(new HashSet<>())//
        .build();
    builder.getUsers().add(user.get());
    builder.getEvents().add(event.get());

    groupRepository.save(builder);
    return true;
  }
}
