package com.vtxlab.projectol.backend_oscar.controllers.user;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserOperation {

  @PatchMapping("/join")
  ResponseEntity<?> addUserInEvent(//
      @RequestParam("userId") Long userId, //
      @RequestParam("eventId") Long eventId);

  // @GetMapping("/usertestcases/eventid/{eventid}")
  // ResponseEntity<UserScoreDTO> getUserTestCaseByEventId(
  //     @PathVariable String eventid);

  @GetMapping("/user/eventid/{eventid}")
  ResponseEntity<User> getUserByEventId(@PathVariable String eventid,HttpServletRequest request);

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
