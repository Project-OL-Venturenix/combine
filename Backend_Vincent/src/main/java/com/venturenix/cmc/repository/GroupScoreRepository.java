package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.GroupScore;
import java.util.List;

@Repository
public interface GroupScoreRepository extends JpaRepository<GroupScore, Long> {

    Optional<GroupScore> findById(Long id);

    List<GroupScore> findAll();
    
    

  
}