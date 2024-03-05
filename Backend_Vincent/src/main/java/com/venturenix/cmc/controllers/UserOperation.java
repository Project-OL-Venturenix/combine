package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.User;
import com.venturenix.cmc.payload.request.UserRequest;
import com.venturenix.cmc.payload.response.MessageResponse;
import jakarta.validation.Valid;

public interface UserOperation {
  @PostMapping("/users/add")
  ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest);

  @GetMapping("/users")
  ResponseEntity<List<User>> getAllUsers();

  @GetMapping("/users/{id}")
  ResponseEntity<User> getUserById(@PathVariable long id);

  @PutMapping("/users/{id}")
  ResponseEntity<User> updateUser(@PathVariable long id,
      @RequestBody User user);

  @DeleteMapping("/users/{id}")
  ResponseEntity<?> deleteUser(@PathVariable long id);
}
