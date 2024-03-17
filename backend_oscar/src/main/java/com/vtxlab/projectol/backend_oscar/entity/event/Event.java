package com.vtxlab.projectol.backend_oscar.entity.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.entity.questionBank.QuestionBank;
import com.vtxlab.projectol.backend_oscar.entity.user.UserScore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
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
@Table(name = "events")
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "event_id")
  private Long id;

  @Size(min = 1, max = 20)
  private String name;

  @Size(min = 1, max = 20)
  private String status;

  private LocalDateTime targetStartTime;
 
  private LocalDateTime targetEndTime;

  private LocalDate eventDate;

  private LocalDateTime createdDate;

  // @Size(min = 1, max = 20)
  private Integer createdBy;

  private LocalDateTime updatedDate;

  // @Size(min = 1, max = 20)
  private Integer updatedBy;

  @OneToMany(mappedBy = "event")
  private Set<UserScore> userScores = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "event_question",
      joinColumns = @JoinColumn(name = "event_id"),
      inverseJoinColumns = @JoinColumn(name = "question_id"))
  private Set<QuestionBank> questions = new HashSet<>();
}
