package com.venturenix.cmc.controllers.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.venturenix.cmc.entity.user.User;
import com.venturenix.cmc.payload.request.UserRequest;
import jakarta.validation.Valid;

public interface UserOperation {
  @PostMapping("/users/add")
  ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest);

  @PatchMapping("/join")
  ResponseEntity<?> addUserInEvent(//
      @RequestParam("userId") Long userId, //
      @RequestParam("eventId") Long eventId);

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
