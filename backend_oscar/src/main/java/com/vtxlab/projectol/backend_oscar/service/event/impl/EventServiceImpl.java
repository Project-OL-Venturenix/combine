package com.vtxlab.projectol.backend_oscar.service.event.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.repository.event.EventRepository;
import com.vtxlab.projectol.backend_oscar.service.event.EventService;

@Service
public class EventServiceImpl implements EventService {

  @Autowired
  EventRepository eventRepository;

  @Override
  public Event save(Event event) {
    return eventRepository.save(event);
  }

  @Override
  public List<Event> findAll() {
    return eventRepository.findAll();
  }

  @Override
  public Optional<Event> findById(Long id) {
    return eventRepository.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    eventRepository.deleteById(id);
  }

}
