package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.UserQuestionSubmit;
import java.util.List;

@Repository
public interface UserQuestionSubmitRepository extends JpaRepository<UserQuestionSubmit, Long> {

    Optional<UserQuestionSubmit> findById(Long id);

        List<UserQuestionSubmit> findAll();
    
    

  
}