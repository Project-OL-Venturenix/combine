package com.vtxlab.projectol.backend_oscar.payload.response.question;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.payload.response.event.EventDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionBankDTO {
  @Column(name = "question_id")
  private Long questionId;

  private String question;

  private String testComputeCase;

  private String methodSignatures;

  private Integer bonusRuntime;

  private LocalDateTime createdDate;

  private Integer createdBy;

  private LocalDateTime updatedDate;

  private Integer updatedBy;

  private Set<EventDTO> events = new HashSet<>();

}
