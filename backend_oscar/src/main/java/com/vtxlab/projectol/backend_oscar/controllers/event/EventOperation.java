package com.vtxlab.projectol.backend_oscar.controllers.event;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.payload.request.event.EventRequest;
import jakarta.validation.Valid;

public interface EventOperation {
  @PostMapping("/events/add")
   ResponseEntity<?> addEvent(
      @Valid @RequestBody EventRequest eventRequest);

  @GetMapping("/events")
  ResponseEntity<List<Event>> getAllEvents();

  @GetMapping("/events/{id}")
   ResponseEntity<Event> getEventById(@PathVariable("id") long id);

  @PutMapping("/events/{id}")
   ResponseEntity<Event> updateEvent(@PathVariable("id") long id,
      @RequestBody Event event);

  @DeleteMapping("/events/{id}")
   ResponseEntity<?> deleteEvent(@PathVariable("id") long id);

}
