package com.venturenix.cmc.payload.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import jakarta.validation.constraints.Size;

public class GroupScoreRequest {

  @NotBlank
  private Long eventid;

  @NotBlank
  private Long groupid;

  @NotBlank
  private Long questionid;

  @NotBlank
  private Long testcase_pass_total;

  @NotBlank
  private Double testcase_score_total;

  @NotBlank
  private Long testcase_total;          

  @NotBlank
  private String status;

  
  private LocalDateTime createddate;

  
  private Long createdby;

  
  private LocalDateTime updateddate;

  
  private Long updatedby;

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

  public Long getTestcasetotal() {
    return testcase_total;
  }

  public void setTestcasetotal(Long testcase_total) {
    this.testcase_total = testcase_total;
  }  

  public Long getTestcasepasstotal() {
    return testcase_pass_total;
  }

  public void setTestcasepasstotal(Long testcase_pass_total) {
    this.testcase_pass_total = testcase_pass_total;
  } 

  public Double getTestcasescoretotal() {
    return testcase_score_total;
  }

  public void setTestcasescoretotal(Double testcase_score_total) {
    this.testcase_score_total = testcase_score_total;
  } 



  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
 public Long getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Long createdby) {
    this.createdby = createdby;
  }

  public LocalDateTime getCreateddate() {
    return createddate;
  }

  public void setCreateddate(LocalDateTime createddate) {
    this.createddate = createddate;
  }

   public Long getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Long updatedby) {
    this.updatedby = updatedby;
  }

  public LocalDateTime getUpdateddate() {
    return updateddate;
  }

  public void setUpdateddate(LocalDateTime updateddate) {
    this.updateddate = updateddate;
  }

}