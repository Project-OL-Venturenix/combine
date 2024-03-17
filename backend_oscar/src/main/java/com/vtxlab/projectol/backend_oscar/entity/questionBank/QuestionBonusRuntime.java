package com.vtxlab.projectol.backend_oscar.entity.questionBank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "question_bonus_runtimes")
public class QuestionBonusRuntime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "question_bonus_runtimes_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private QuestionBank question;

  private Integer bonusRuntime;
}
