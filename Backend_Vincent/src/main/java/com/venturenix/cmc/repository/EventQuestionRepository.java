package com.venturenix.cmc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.EventQuestion;

@Repository
public interface EventQuestionRepository
        extends JpaRepository<EventQuestion, Long> {



}
