package com.vtxlab.projectol.backend_oscar.controllers.event;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.payload.request.event.EventRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.event.EventDTO;
import jakarta.validation.Valid;

public interface EventOperation {
      @PostMapping("/events/add")
      ResponseEntity<?> addEvent(@Valid @RequestBody EventRequest eventRequest);

      @GetMapping("/events")
      ResponseEntity<List<EventDTO>> getAllEvents();

      @GetMapping("/events/{id}")
      ResponseEntity<EventDTO> getEventById(@PathVariable("id") long id);

      @PutMapping("/events/{id}/{status}")
      @ResponseStatus(HttpStatus.CREATED)
      Event updateEvent(@PathVariable("id") long id,
                  @PathVariable String status);

      @DeleteMapping("/events/{id}")
      ResponseEntity<?> deleteEvent(@PathVariable("id") long id);

}
