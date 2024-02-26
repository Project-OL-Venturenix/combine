package com.venturenix.cmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.UserScore;
import java.util.List;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, Long> {

    Optional<UserScore> findById(Long id);

    List<UserScore> findAll();
    
    

  
}