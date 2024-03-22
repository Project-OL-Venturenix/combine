package com.vtxlab.projectol.backend_oscar.entity.user;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "user_score")
@JsonPropertyOrder({ "id", "event", "user", "question", "submitTime",
    "resultOfPassingTestecase", "BonusUnder30Mins",
    "BonusWithinQuestionRuntime", "runtimebyMsec", "status", "createdDate",
    "updatedDate" })
public class UserScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private QuestionBank question;

  private LocalDateTime submitTime;

  @Column(name = "result_of_passing_testecase")
  private Integer resultOfPassingTestecase;

  @Column(name = "bonus_under_30_mins")
  private String bonusUnder30Mins;

  @Column(name = "bonus_within_question_runtime")
  private String bonusWithinQuestionRuntime;

  private Integer runtimebyMsec;

  private String status;
  
  private LocalDateTime createdDate;

  private LocalDateTime updatedDate;

}
