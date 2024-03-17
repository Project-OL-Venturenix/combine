package com.venturenix.cmc.repository.user;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.user.UserScore;

@Repository
public interface UserQuestionSubmissionRepository extends JpaRepository<UserScore, Long> {

    List<UserScore> findByEventId(Long eventId);

}