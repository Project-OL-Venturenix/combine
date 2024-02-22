package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.EventUser;
import java.util.List;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, Long> {

    Optional<EventUser> findById(Long id);

    List<EventUser> findAll();
    
    

  
}