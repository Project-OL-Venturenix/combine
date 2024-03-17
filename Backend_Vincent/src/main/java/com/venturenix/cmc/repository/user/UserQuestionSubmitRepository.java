package com.venturenix.cmc.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.user.UserScore;

@Repository
public interface UserQuestionSubmitRepository extends JpaRepository<UserScore, Long> {
  
}