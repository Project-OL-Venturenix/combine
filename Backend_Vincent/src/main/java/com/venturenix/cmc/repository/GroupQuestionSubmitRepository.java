package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.GroupQuestionSubmit;
import java.util.List;

@Repository
public interface GroupQuestionSubmitRepository extends JpaRepository<GroupQuestionSubmit, Long> {

    Optional<GroupQuestionSubmit> findById(Long id);

        List<GroupQuestionSubmit> findAll();
    
    

  
}