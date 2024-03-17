package com.venturenix.cmc.entity.event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.venturenix.cmc.entity.group.Group;
import com.venturenix.cmc.entity.questionBank.QuestionBank;
import com.venturenix.cmc.entity.user.UserScore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

  private LocalDateTime targetEndTime;

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
