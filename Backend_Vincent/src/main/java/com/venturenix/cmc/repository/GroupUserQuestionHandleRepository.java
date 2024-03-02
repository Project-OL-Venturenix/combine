package com.venturenix.cmc.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.venturenix.cmc.entity.GroupUserQuestionHandle;

@Repository
public interface GroupUserQuestionHandleRepository
                extends JpaRepository<GroupUserQuestionHandle, Long> {

        Optional<GroupUserQuestionHandle> findDistinctByEventidAndGroupidAndQuestionid(
                        Long eventid, Long groupid, Long questionid);

        Optional<List<GroupUserQuestionHandle>> findByUserid(Long userid);

}
