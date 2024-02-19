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

import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.request.UserRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.UserResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
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

  


@PostMapping("/user/add")
  public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest) {
    User user = new User(
               userRequest.getFirstname(), 
               userRequest.getLastname(), 
               userRequest.getMobile(), 
               userRequest.getEmail(), 
               userRequest.getUsername(), 
               encoder.encode(userRequest.getPassword()),
               userRequest.getCompany(), 
               userRequest.getTitle(),
               userRequest.getPy_experience(),
               userRequest.getJv_experience(),
               userRequest.getJs_experience(),
               userRequest.getCs_experience(),
               userRequest.getSa_experience(),
               userRequest.getStatus(),
               java.time.LocalDateTime.now(),
               userRequest.getCreatedby(),
               java.time.LocalDateTime.now(),
               userRequest.getUpdatedby()
               );
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("Add User successfully!"));
    
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers() {
    try {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);        
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK );
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
  }

 @GetMapping("/user/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
    Optional<User> userData = userRepository.findById(id);
    if (userData.isPresent()) {
      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
    Optional<User> userData = userRepository.findById(id);

    if (userData.isPresent()) {
      User _user = userData.get();
      _user.setFirstname(user.getFirstname());
      _user.setLastname(user.getLastname());
      _user.setMobile(user.getMobile());
      _user.setEmail(user.getEmail());
      _user.setUsername(user.getUsername());
      _user.setPassword(user.getPassword());
      _user.setCompany(user.getCompany());
      _user.setTitle(user.getTitle());
      _user.setPy_experience(user.getPy_experience());
      _user.setJv_experience(user.getJv_experience());
      _user.setJs_experience(user.getJs_experience());
      _user.setCs_experience(user.getCs_experience());
      _user.setSa_experience(user.getSa_experience());
      _user.setStatus(user.getStatus());
      _user.setUpdateddate(java.time.LocalDateTime.now());
      _user.setUpdatedby(user.getUpdatedby());
      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
    try {
      userRepository.deleteById(id);
      return ResponseEntity.ok(new MessageResponse("Delete User " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity.ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }
}

