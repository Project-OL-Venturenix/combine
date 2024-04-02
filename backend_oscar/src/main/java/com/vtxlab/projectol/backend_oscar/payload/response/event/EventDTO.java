package com.vtxlab.projectol.backend_oscar.payload.response.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionBankDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.user.UserScoreResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
  private Long id;
  private String name;
  private String status;
  private LocalDateTime targetStartTime;
  private LocalDateTime targetEndTime;
  private LocalDate eventDate;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;
  private Set<UserScoreResult> userScores = new HashSet<>();
  private Set<QuestionBankDTO> questions = new HashSet<>();
}