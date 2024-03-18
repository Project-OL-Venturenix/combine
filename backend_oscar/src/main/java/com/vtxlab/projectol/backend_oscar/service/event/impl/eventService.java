package com.vtxlab.projectol.backend_oscar.service.event.impl;

import java.util.List;
import java.util.Optional;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;

public interface eventService {
  Event save(Event event);

  List<Event> findAll();

  Optional<Event> findById(Long id);
}
