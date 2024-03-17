package com.vtxlab.projectol.backend_oscar.entity.group;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
@Table(name = "Group_Testcases")
public class GroupTestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Group_Testcases_id")
  private Long id;
  private Long eventId;
  private Long groupId;
  private Long userId;
  private Long questionId;
  private Long testcaseid;
  
  private OffsetDateTime runstartTimeutc;
  private OffsetDateTime  runendTimeutc;
  private OffsetDateTime  runtimeutc;
  private LocalDateTime  runstartTime;    
  private LocalDateTime runendTime;
  private String testcasefilepath;
  private String fileName;    
  private String testcasepassstatus;
  private String status;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;

}