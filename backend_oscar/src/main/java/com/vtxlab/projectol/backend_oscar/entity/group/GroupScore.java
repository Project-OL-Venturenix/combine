package com.vtxlab.projectol.backend_oscar.entity.group;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
// @Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Group_Scores")
public class GroupScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Group_Scores_id")
  private Long id;
  private Long eventId;
  private Long groupId;
  private Long questionId;
  private Integer testcaseTotal;
  private Integer testcasepassTotal;
  private Double testcasescoreTotal;
  private String status;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;



}
