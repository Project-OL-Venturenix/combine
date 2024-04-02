package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vtxlab.projectol.backend_oscar.payload.response.event.EventDTO;
import com.vtxlab.projectol.backend_oscar.payload.response.question.QuestionBankDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonPropertyOrder({ "id", "event", "user", "question", "submitTime",
    "resultOfPassingTestecase", "bonusUnder30Mins",
    "bonusWithinQuestionRuntime", "runtimeByMsec", "status", "createdDate",
    "updatedDate" })
public class UserScoreDTO {
  private Long id;
    private EventDTO event;
    private UserDTO user;
    private QuestionBankDTO question;
    private LocalDateTime submitTime;
    private Integer resultOfPassingTestecase;
    private String bonusUnder30Mins;
    private String bonusWithinQuestionRuntime;
    private Integer runtimeByMsec;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
