package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.Event;
import com.venturenix.cmc.payload.request.EventRequest;
import jakarta.validation.Valid;

public interface EventOperation {
  @PostMapping("/event/add")
   ResponseEntity<?> addEvent(
      @Valid @RequestBody EventRequest eventRequest);

  @GetMapping("/events")
  ResponseEntity<List<Event>> getAllEvents();

  @GetMapping("/event/{id}")
   ResponseEntity<Event> getEventById(@PathVariable("id") long id);

  @PutMapping("/event/{id}")
   ResponseEntity<Event> updateEvent(@PathVariable("id") long id,
      @RequestBody Event event);

  @DeleteMapping("/event/{id}")
   ResponseEntity<?> deleteEvent(@PathVariable("id") long id);

}
