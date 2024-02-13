package com.vtxlab.projectol.server_test_cases.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode
@ToString
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id") 
  private Long id;

  @Column(name = "question_id")
  private Long questionId;

  @Column(name = "question_text", columnDefinition = "TEXT")
  private String questionText;

  @Column(name = "code_text", columnDefinition = "TEXT")
  private String codeText;
  private String answer;
  private String difficulty;

  @PrePersist
  public void prePersist() {
    if (questionId == null) {
      questionId = id; // Set questionId to id if not already set
    }
  }
}
