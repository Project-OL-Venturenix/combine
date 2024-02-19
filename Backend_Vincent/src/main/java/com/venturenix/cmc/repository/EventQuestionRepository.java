package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.EventQuestion;
import java.util.List;

@Repository
public interface EventQuestionRepository extends JpaRepository<EventQuestion, Long> {

    Optional<EventQuestion> findById(int id);

    List<EventQuestion> findAll();
    
    

  
}