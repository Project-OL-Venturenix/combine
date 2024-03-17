package com.vtxlab.projectol.backend_oscar.controllers.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.projectol.backend_oscar.payload.request.user.LoginRequest;
import com.vtxlab.projectol.backend_oscar.payload.request.user.SignupRequest;
import jakarta.validation.Valid;

public interface AuthOperation {
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(
      @Valid @RequestBody LoginRequest loginRequest);

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(
      @Valid @RequestBody SignupRequest signUpRequest);

}
