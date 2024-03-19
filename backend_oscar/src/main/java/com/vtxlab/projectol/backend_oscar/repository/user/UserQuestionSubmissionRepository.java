package com.vtxlab.projectol.backend_oscar.repository.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;

@Repository
public interface UserQuestionSubmissionRepository
        extends JpaRepository<UserScore, Long> {

    List<UserScore> findByEventId(Long eventId);

    @Query("SELECT u FROM UserScore u WHERE u.event.id = ?1 AND u.user.id = ?2 AND u.question.id = ?3")
    Optional<UserScore> findByEventIdAndUserIdAndQuestionId(Long eventId, Long userId,
            Long questionId);
}
