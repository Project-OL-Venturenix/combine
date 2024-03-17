package com.vtxlab.projectol.backend_oscar.repository.user;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;

@Repository
public interface UserQuestionSubmissionRepository extends JpaRepository<UserScore, Long> {

    List<UserScore> findByEventId(Long eventId);

}