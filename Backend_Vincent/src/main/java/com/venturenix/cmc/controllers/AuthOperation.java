package com.venturenix.cmc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.payload.request.LoginRequest;
import com.venturenix.cmc.payload.request.SignupRequest;
import jakarta.validation.Valid;

public interface AuthOperation {
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(
      @Valid @RequestBody LoginRequest loginRequest);

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(
      @Valid @RequestBody SignupRequest signUpRequest);

}
