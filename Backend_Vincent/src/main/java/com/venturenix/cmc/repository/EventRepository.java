package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.Event;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findById(int id);

    Event findByName(String name);

    List<Event> findAll();
    
    

  
}