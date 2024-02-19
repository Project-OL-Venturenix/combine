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
import com.venturenix.cmc.models.GroupUser;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.GroupUserRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.GroupUserResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.GroupUserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupUserController {
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
  GroupUserRepository groupuserRepository;


@PostMapping("/groupuser/add")
  public ResponseEntity<?> addGroupUser(@Valid @RequestBody GroupUserRequest groupuserRequest) {
    GroupUser groupuser = new GroupUser(
               groupuserRequest.getGroupid(), 
               groupuserRequest.getUserid(), 
               groupuserRequest.getStatus(),
               java.time.LocalDateTime.now(),
               groupuserRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               groupuserRequest.getUpdatedby()
               );
    groupuserRepository.save(groupuser);
    return ResponseEntity.ok(new MessageResponse("Add GroupUser successfully!"));
    
  }

  @GetMapping("/groupusers")
  public ResponseEntity<List<GroupUser>> getAllGroupUsers() {
    try {
        List<GroupUser> groupusers = new ArrayList<GroupUser>();
        groupuserRepository.findAll().forEach(groupusers::add);        
        if (groupusers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groupusers, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/groupuser/{id}")
  public ResponseEntity<GroupUser> getGroupUserById(@PathVariable("id") long id) {
    Optional<GroupUser> groupuserData = groupuserRepository.findById(id);
    if (groupuserData.isPresent()) {
      return new ResponseEntity<>(groupuserData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/groupuser/{id}")
  public ResponseEntity<GroupUser> updateGroupUser(@PathVariable("id") long id, @RequestBody GroupUser groupuser) {
    Optional<GroupUser> groupuserData = groupuserRepository.findById(id);

    if (groupuserData.isPresent()) {
      GroupUser _groupuser = groupuserData.get();
      _groupuser.setGroupid(groupuser.getGroupid());
      _groupuser.setUserid(groupuser.getUserid());
      _groupuser.setStatus(groupuser.getStatus());
      _groupuser.setUpdateddate(java.time.LocalDateTime.now());
      _groupuser.setUpdatedby(groupuser.getUpdatedby());
      return new ResponseEntity<>(groupuserRepository.save(_groupuser), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/groupuser/{id}")
  public ResponseEntity<?> deleteGroupUser(@PathVariable("id") long id) {
    try {
      groupuserRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete GroupUser " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
