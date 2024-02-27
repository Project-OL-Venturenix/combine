package com.venturenix.cmc.controllers.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.venturenix.cmc.controllers.AuthOperation;
import com.venturenix.cmc.entity.ERole;
import com.venturenix.cmc.entity.Role;
import com.venturenix.cmc.entity.User;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import com.venturenix.cmc.payload.response.JwtResponse;
import com.venturenix.cmc.payload.response.MessageResponse;
import com.venturenix.cmc.repository.RoleRepository;
import com.venturenix.cmc.repository.UserRepository;
import com.venturenix.cmc.security.jwt.JwtUtils;
import com.venturenix.cmc.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController implements AuthOperation {
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

  public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        // UserDetailsImpl userDetails1 = (UserDetailsImpl) authentication.getPrincipal();
        // new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
            loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails =
        (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority()).collect(Collectors.toList());

    return ResponseEntity.ok(
        new JwtResponse(jwt, userDetails.getId(), userDetails.getFirstname(),
            userDetails.getLastname(), userDetails.getMobile(),
            userDetails.getEmail(), userDetails.getUsername(),
            userDetails.getCompany(), userDetails.getTitle(),
            userDetails.getPy_experience(), userDetails.getJv_experience(),
            userDetails.getJs_experience(), userDetails.getCs_experience(),
            userDetails.getSa_experience(), userDetails.getStatus(),
            java.time.LocalDateTime.now(), userDetails.getCreatedby(),
            java.time.LocalDateTime.now(), userDetails.getUpdatedby(), roles));
  }

  public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getFirstname(),
        signUpRequest.getLastname(), signUpRequest.getMobile(),
        signUpRequest.getEmail(), signUpRequest.getUsername(),
        encoder.encode(signUpRequest.getPassword()), signUpRequest.getCompany(),
        signUpRequest.getTitle(), signUpRequest.getPy_experience(),
        signUpRequest.getJv_experience(), signUpRequest.getJs_experience(),
        signUpRequest.getCs_experience(), signUpRequest.getSa_experience(),
        signUpRequest.getStatus(), java.time.LocalDateTime.now(),
        signUpRequest.getCreatedby(), java.time.LocalDateTime.now(),
        signUpRequest.getUpdatedby()//
        );

    // Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    // if (strRoles == null) {
      if (signUpRequest.getEmail().endsWith("venturenix.com")
          || signUpRequest.getEmail().endsWith("venturenixlab.com")) {
        Role adminRole =
            roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(
                () -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);
      } else {
        Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(
            () -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
      }
    // } else {
    //   strRoles.forEach(role -> {
    //     switch (role) {
    //       case "admin":
    //         Role adminRole =
    //             roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(
    //                 () -> new RuntimeException("Error: Role is not found."));
    //         roles.add(adminRole);

    //         break;
    //       case "mod":
    //         Role modRole =
    //             roleRepository.findByName(ERole.ROLE_MODERATOR).orElseThrow(
    //                 () -> new RuntimeException("Error: Role is not found."));
    //         roles.add(modRole);

    //         break;
    //       default:
    //         Role userRole =
    //             roleRepository.findByName(ERole.ROLE_USER).orElseThrow(
    //                 () -> new RuntimeException("Error: Role is not found."));
    //         roles.add(userRole);
    //     }
    //   });
    // }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity
        .ok(new MessageResponse("User registered successfully!"));
  }
}
