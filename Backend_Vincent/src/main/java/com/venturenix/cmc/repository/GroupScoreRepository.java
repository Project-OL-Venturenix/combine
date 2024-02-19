package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.venturenix.cmc.models.GroupScore;
import java.util.List;

@Repository
public interface GroupScoreRepository extends JpaRepository<GroupScore, Long> {

    Optional<GroupScore> findById(long id);

    List<GroupScore> findAll();
    
    

  
}