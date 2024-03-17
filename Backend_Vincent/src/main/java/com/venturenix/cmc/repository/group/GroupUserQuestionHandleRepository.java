// package com.venturenix.cmc.repository.group;

// import java.util.List;
// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.venturenix.cmc.entity.group.GroupUserQuestionHandle;

// @Repository
// public interface GroupUserQuestionHandleRepository
//                 extends JpaRepository<GroupUserQuestionHandle, Long> {

//         Optional<GroupUserQuestionHandle> findDistinctByEventIdAndGroupIdAndQuestionId(
//                         Long eventId, Long groupId, Long questionId);

//         Optional<List<GroupUserQuestionHandle>> findByUserId(Long userId);

// }
