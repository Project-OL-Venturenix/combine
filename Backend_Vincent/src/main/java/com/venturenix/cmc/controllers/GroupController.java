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
import com.venturenix.cmc.models.Group;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.GroupRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.GroupResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.GroupRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupController {
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
  GroupRepository groupRepository;


@PostMapping("/group/add")
  public ResponseEntity<?> addGroup(@Valid @RequestBody GroupRequest groupRequest) {
    Group group = new Group(groupRequest.getName(), 
               groupRequest.getStatus(),
               java.time.LocalDateTime.now(),
               groupRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               groupRequest.getUpdatedby()
               );
    groupRepository.save(group);
    return ResponseEntity.ok(new MessageResponse("Add Group successfully!"));
    
  }

  @GetMapping("/groups")
  public ResponseEntity<List<Group>> getAllGroups() {
    try {
        List<Group> groups = new ArrayList<Group>();
        groupRepository.findAll().forEach(groups::add);        
        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groups, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/group/{id}")
  public ResponseEntity<Group> getGroupById(@PathVariable("id") long id) {
    Optional<Group> groupData = groupRepository.findById(id);
    if (groupData.isPresent()) {
      return new ResponseEntity<>(groupData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/group/{id}")
  public ResponseEntity<Group> updateGroup(@PathVariable("id") long id, @RequestBody Group group) {
    Optional<Group> groupData = groupRepository.findById(id);

    if (groupData.isPresent()) {
      Group _group = groupData.get();
      _group.setName(group.getName());
      _group.setStatus(group.getStatus());
      _group.setUpdateddate(java.time.LocalDateTime.now());
      _group.setUpdatedby(group.getUpdatedby());
      return new ResponseEntity<>(groupRepository.save(_group), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/group/{id}")
  public ResponseEntity<?> deleteGroup(@PathVariable("id") long id) {
    try {
      groupRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete Group " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
