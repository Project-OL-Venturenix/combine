package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.EventGroup;
import java.util.List;

@Repository
public interface EventGroupRepository extends JpaRepository<EventGroup, Long> {

    Optional<EventGroup> findById(int id);

    List<EventGroup> findAll();
    
    

  
}