package com.venturenix.cmc.payload.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import jakarta.validation.constraints.Size;

public class GroupTestCaseRequest {

  @NotBlank
  private Long eventid;
  @NotBlank
  private Long groupid;
  @NotBlank
  private Long userid;
  @NotBlank
  private Long questionid;
  @NotBlank
  private Long testcaseid;
  @NotBlank
  private Double run_time_by_sec;
  @NotBlank
  private String testcase_pass_status;      

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

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public Long getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Long questionid) {
    this.questionid = questionid;
  }

  public Long getTestcaseid() {
    return testcaseid;
  }

  public void setTestcaseid(Long testcaseid) {
    this.testcaseid = testcaseid;
  }  

  public String getTestcasepassstatus() {
    return testcase_pass_status;
  }

  public void setTestcasepassstatus(String testcase_pass_status) {
    this.testcase_pass_status = testcase_pass_status;
  }    

  public Double getRuntimebysec() {
    return run_time_by_sec;
  }  

  public void setRuntimebysec(Double run_time_by_sec) {
    this.run_time_by_sec = run_time_by_sec;
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