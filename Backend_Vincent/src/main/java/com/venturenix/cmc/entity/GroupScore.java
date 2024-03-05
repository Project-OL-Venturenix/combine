package com.venturenix.cmc.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "groupscores")
public class GroupScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long eventid;
  private Long groupid;
  private Long questionid;
  private Integer testcasetotal;
  private Integer testcasepasstotal;
  private Double testcasescoretotal;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;


  public GroupScore() {
    
  }

  public GroupScore(Long eventid, Long groupid, Long questionid, Integer testcasepasstotal, Double testcasescoretotal, Integer testcasetotal, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.eventid = eventid;
    this.groupid = groupid;
    this.questionid = questionid;
    this.testcasepasstotal = testcasepasstotal;
    this.testcasescoretotal = testcasescoretotal;
    this.testcasetotal = testcasetotal;
    this.status = status;
    this.createddate = createddate;
    this.createdby = createdby;
    this.updateddate = updateddate;
    this.updatedby = updatedby;
    
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getEventid() {
    return eventid;
  }

  public void setEventid(Long eventid) {
    this.eventid = eventid;
  }  

  public Long getGroupid() {
    return groupid;
  }

  public void setGroupid(Long groupid) {
    this.groupid = groupid;
  }

  public Long getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Long questionid) {
    this.questionid = questionid;
  }  

  public Integer getTestcasetotal() {
    return testcasetotal;
  }

  public void setTestcasetotal(Integer testcasetotal) {
    this.testcasetotal = testcasetotal;
  }  

  public Integer getTestcasepasstotal() {
    return testcasepasstotal;
  }

  public void setTestcasepasstotal(Integer testcasepasstotal) {
    this.testcasepasstotal = testcasepasstotal;
  } 

  public Double getTestcasescoretotal() {
    return testcasescoretotal;
  }

  public void setTestcasescoretotal(Double testcasescoretotal) {
    this.testcasescoretotal = testcasescoretotal;
  } 


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }  

  public LocalDateTime getCreateddate() {
    return createddate;
  }

  public void setCreateddate(LocalDateTime createddate) {
    this.createddate = createddate;
  }  

  public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }   

  public LocalDateTime getUpdateddate() {
    return updateddate;
  }

  public void setUpdateddate(LocalDateTime updateddate) {
    this.updateddate = updateddate;
  }  


}