package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.GroupUserQuestionHandle;
import java.util.List;

@Repository
public interface GroupUserQuestionHandleRepository extends JpaRepository<GroupUserQuestionHandle, Long> {

    Optional<GroupUserQuestionHandle> findById(Long id);

        List<GroupUserQuestionHandle> findAll();
    
    

  
}