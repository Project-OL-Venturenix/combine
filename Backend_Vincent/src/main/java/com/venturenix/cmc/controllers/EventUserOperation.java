package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.EventUser;
import com.venturenix.cmc.payload.request.EventUserRequest;
import jakarta.validation.Valid;

public interface EventUserOperation {
  @PostMapping("/eventusers/add")
  ResponseEntity<?> addEventUser(
      @Valid @RequestBody EventUserRequest eventUserRequest);

  @GetMapping("/eventusers")
  ResponseEntity<List<EventUser>> getAllEventUsers();

  @GetMapping("/eventusers/{id}")
  ResponseEntity<EventUser> getEventUserById(@PathVariable("id") long id);

  @PutMapping("/eventusers/{id}")
  ResponseEntity<EventUser> updateEventUser(@PathVariable("id") long id,
      @RequestBody EventUser eventUser);

  @DeleteMapping("/eventusers/{id}")
  ResponseEntity<?> deleteEventUser(@PathVariable("id") long id);
}
