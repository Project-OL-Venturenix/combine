package com.venturenix.cmc.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.venturenix.cmc.entity.EventGroup;
import com.venturenix.cmc.payload.request.EventGroupRequest;
import jakarta.validation.Valid;

public interface EventGroupOperation {
  @PostMapping("/eventgroups/add")
  ResponseEntity<?> addEventGroup(
      @Valid @RequestBody EventGroupRequest eventGroupRequest);

  @GetMapping("/eventgroups")
  ResponseEntity<List<EventGroup>> getAllEventGroups();

  @GetMapping("/eventgroups/{id}")
  ResponseEntity<EventGroup> getEventGroupById(@PathVariable("id") long id);

  @PutMapping("/eventgroups/{id}")
  ResponseEntity<EventGroup> updateEventGroup(@PathVariable("id") long id,
      @RequestBody EventGroup eventGroup);

  @DeleteMapping("/eventgroups/{id}")
  ResponseEntity<?> deleteEventGroup(@PathVariable("id") long id);

}
