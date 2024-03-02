package com.venturenix.cmc.controllers.impl;

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
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.controllers.GroupUserOperation;
import com.venturenix.cmc.entity.GroupUser;
import com.venturenix.cmc.payload.request.GroupUserRequest;
import com.venturenix.cmc.payload.response.GroupUserDTO;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.repository.GroupUserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupUserController implements GroupUserOperation {
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
  GroupUserRepository groupUserRepository;


  public ResponseEntity<?> addGroupUser(GroupUserRequest groupuserRequest) {
    GroupUser groupuser = new GroupUser(groupuserRequest.getGroupid(),
        groupuserRequest.getUserid(), groupuserRequest.getStatus(),
        java.time.LocalDateTime.now(), groupuserRequest.getCreatedby(),
        java.time.LocalDateTime.now(), groupuserRequest.getUpdatedby());
    groupUserRepository.save(groupuser);
    return ResponseEntity
        .ok(new MessageResponse("Add GroupUser successfully!"));

  }

  public ResponseEntity<List<GroupUserDTO>> getAllGroupUsers() {
    try {
      List<GroupUserDTO> result = new ArrayList<>();
      groupUserRepository.findAll()//
          .forEach(groupuser -> {
            result.add(new GroupUserDTO(//
                groupuser.getId(), //
                groupuser.getGroupid(), //
                groupuser.getUserId()));
          });
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<GroupUser> getGroupUserById(long id) {
    Optional<GroupUser> groupuserData = groupUserRepository.findById(id);
    if (groupuserData.isPresent()) {
      return new ResponseEntity<>(groupuserData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<GroupUser> updateGroupUser(long id,
      @RequestBody GroupUser groupuser) {
    Optional<GroupUser> groupuserData = groupUserRepository.findById(id);

    if (groupuserData.isPresent()) {
      GroupUser _groupuser = groupuserData.get();
      _groupuser.setGroupid(groupuser.getGroupid());
      _groupuser.setUserId(groupuser.getUserId());
      _groupuser.setStatus(groupuser.getStatus());
      _groupuser.setUpdateddate(java.time.LocalDateTime.now());
      _groupuser.setUpdatedby(groupuser.getUpdatedby());
      return new ResponseEntity<>(groupUserRepository.save(_groupuser),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<?> deleteGroupUser(long id) {
    try {
      groupUserRepository.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete GroupUser " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}
