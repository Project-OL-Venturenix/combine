package com.venturenix.cmc.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Question_Bank")
public class QuestionBank implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("question_id")
  @Column(name = "question_id")
  private Long questionId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "question_id", referencedColumnName = "testcase_id")
  private TestCase testCase;

  @Column(columnDefinition = "TEXT")
  private String question;

  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;

}
