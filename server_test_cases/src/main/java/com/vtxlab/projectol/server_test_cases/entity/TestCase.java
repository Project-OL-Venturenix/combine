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
public class TestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String testCase1;
  private String testCase2;
  private String testCase3;
  private String testCase4;
  private String testCase5;
  private String testCase6;
  private String testCase7;
  private String testCase8;
  private String testCase9;
  private String testCase10;

  // foriegn key onetoone reference to class Question questionId,but questionId is not a primary key
  @OneToOne
  @JoinColumn(name = "id")
  private Question questionId;
}
