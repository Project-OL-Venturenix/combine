package com.vtxlab.projectol.backend_oscar.controllers.user.impl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.projectol.backend_oscar.controllers.user.AuthOperation;
import com.vtxlab.projectol.backend_oscar.entity.user.ERole;
import com.vtxlab.projectol.backend_oscar.entity.user.Role;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import com.vtxlab.projectol.backend_oscar.payload.request.user.LoginRequest;
import com.vtxlab.projectol.backend_oscar.payload.request.user.SignupRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.user.JwtResponse;
import com.vtxlab.projectol.backend_oscar.payload.response.user.MessageResponse;
import com.vtxlab.projectol.backend_oscar.repository.user.RoleRepository;
import com.vtxlab.projectol.backend_oscar.repository.user.UserRepository;
import com.vtxlab.projectol.backend_oscar.security.jwt.JwtUtils;
import com.vtxlab.projectol.backend_oscar.security.services.UserDetailsImpl;

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
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails =
                (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), //
                userDetails.getFirstName(), //
                userDetails.getLastName(), //
                userDetails.getMobile(), //
                userDetails.getEmail(), //
                userDetails.getUsername(), //
                userDetails.getCompany(), //
                userDetails.getTitle(), //
                userDetails.getPy_experience(), //
                userDetails.getJv_experience(), //
                userDetails.getJs_experience(), //
                userDetails.getCs_experience(), //
                userDetails.getSa_experience(), //
                userDetails.getStatus(), //
                LocalDateTime.now(), //
                userDetails.getCreatedBy(), //
                LocalDateTime.now(), //
                userDetails.getUpdatedBy(), //
                roles));
    }

    public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
        if (userRepository.existsByUserName(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(
                    new MessageResponse("Error: userName is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(
                    new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User builder = User.builder()//
                .firstName(signUpRequest.getFirstName())//
                .lastName(signUpRequest.getLastName())//
                .mobile(signUpRequest.getMobile())//
                .email(signUpRequest.getEmail())//
                .userName(signUpRequest.getUserName())//
                .password(encoder.encode(signUpRequest.getPassword()))//
                .company(signUpRequest.getCompany())//
                .title(signUpRequest.getTitle())//
                .pyExperience(signUpRequest.getPy_experience())//
                .jvExperience(signUpRequest.getJv_experience())//
                .jsExperience(signUpRequest.getJs_experience())//
                .csExperience(signUpRequest.getCs_experience())//
                .saExperience(signUpRequest.getSa_experience())//
                .status(signUpRequest.getStatus())//
                .createdDate(LocalDateTime.now())//
                .createdBy(signUpRequest.getCreatedBy())//
                .updatedDate(LocalDateTime.now())//
                .updatedBy(signUpRequest.getUpdatedBy())//
                .build();

        // Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        // if (strRoles == null) {
        if (signUpRequest.getEmail().endsWith("venturenix.com")
                || signUpRequest.getEmail().endsWith("venturenixlab.com")) {
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException(
                            "Error : Role is not found."));
            Role moderatorRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException(
                            "Error : Role is not found."));
            roles.add(adminRole);
            // roles.add(moderatorRole);
        } else {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(
                            "Error: Role is not found."));
            roles.add(userRole);
        }
        builder.setRoles(roles);
        userRepository.save(builder);

        return ResponseEntity
                .ok(new MessageResponse("User registered successfully!"));
    }
}
