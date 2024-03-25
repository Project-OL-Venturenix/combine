package com.vtxlab.projectol.backend_oscar.entity.questionBank;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "questions")
@JsonPropertyOrder({"id", "question", "testComputeCase", "methodSignatures",
    "targetCompleteTime", "createdDate", "createdBy", "updatedDate",
    "updatedBy"})
public class QuestionBank {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "question_id")
  @JsonProperty("id")
  private Long questionId;


  @OneToMany(mappedBy = "questionBank")
  private Set<TestCase> testCases = new HashSet<>();

  @Column(columnDefinition = "TEXT")
  private String question;

  @Column(columnDefinition = "TEXT")
  private String testComputeCase;

  private String methodSignatures;

  private Integer bonusRuntime;

  private LocalDateTime createdDate;

  private Integer createdBy;

  private LocalDateTime updatedDate;

  private Integer updatedBy;

  @ManyToMany(mappedBy = "questions")
  private Set<Event> events = new HashSet<>();
}
