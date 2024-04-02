package com.vtxlab.projectol.backend_oscar.controllers.event.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.projectol.backend_oscar.controllers.event.EventOperation;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.payload.Mapper;
import com.vtxlab.projectol.backend_oscar.payload.request.event.EventRequest;
import com.vtxlab.projectol.backend_oscar.payload.response.event.EventDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.user.MessageResponse;
import com.vtxlab.projectol.backend_oscar.service.event.EventService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EventController implements EventOperation {

  @Autowired
  EventService eventService;

  public ResponseEntity<?> addEvent(EventRequest eventRequest) {
    Event builder = Event.builder()//
        .name(eventRequest.getName())//
        .status("O")//
        .eventDate(eventRequest.getEventDate())
        .targetStartTime(eventRequest.getTargetStartTime())//
        .targetEndTime(eventRequest.getTargetEndTime())//
        .createdDate(LocalDateTime.now())//
        .createdBy(eventRequest.getCreatedBy())//
        .updatedDate(LocalDateTime.now())//
        .updatedBy(eventRequest.getUpdatedBy())//
        .build();

    eventService.save(builder);
    return ResponseEntity.ok(new MessageResponse("Add Event successfully!"));

  }

  public ResponseEntity<List<EventDTO>> getAllEvents() {
    try {
      List<EventDTO> events = eventService.findAll().stream()
          .map(e -> Mapper.map(e)).collect(Collectors.toList());
      if (events.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(events, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  public ResponseEntity<EventDTO> getEventById(long id) {
    Optional<Event> eventData = eventService.findById(id);
    if (eventData.isPresent()) {
      return new ResponseEntity<>(Mapper.map(eventData.get()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }



  public ResponseEntity<?> deleteEvent(long id) {
    try {
      eventService.deleteById(id);
      return ResponseEntity
          .ok(new MessageResponse("Delete Event " + id + " successfully!"));
    } catch (Exception e) {
      return ResponseEntity
          .ok(new MessageResponse("HttpStatus.INTERNAL_SERVER_ERROR"));
    }
  }

  @Override
  public Event updateEvent(long id, String status) {
    Optional<Event> optionalEvent = eventService.findById(id);
    if (optionalEvent.isPresent()) {
      Event event = optionalEvent.get();
      if (isValidStatus(status)) {
        event.setStatus(status);
        return eventService.save(event);
      } else {
        throw new IllegalArgumentException("Invalid status: " + status);
      }
    } else {
      throw new IllegalArgumentException("Event not found with ID: " + id);
    }
  }

  private boolean isValidStatus(String status) {
    return status.equalsIgnoreCase("Open") || status.equalsIgnoreCase("Close");
  }
}
