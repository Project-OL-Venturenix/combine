package com.venturenix.cmc.payload.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import jakarta.validation.constraints.Size;

public class GroupQuestionSubmitRequest {




  //@NotBlank
  private Long eventid;

  //@NotBlank
  private Long groupid;

  //@NotBlank
  private Long questionid;  

  //@NotBlank
  private Long userid;  

  //@NotBlank
  private Double run_time_by_msec;  

  //@NotBlank
  private LocalDateTime submit_time;  

  //@NotBlank
  private String status;

  
  private LocalDateTime createddate;

  
  private Integer createdby;

  
  private LocalDateTime updateddate;

  
  private Integer updatedby;


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

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }  

  public Double getRuntimebymsec() {
    return run_time_by_msec;
  }

  public void setRuntimebymsec(Double run_time_by_msec) {
    this.run_time_by_msec = run_time_by_msec;
  }  

  public LocalDateTime getSubmittime() {
    return submit_time;
  }

  public void settSubmittime(LocalDateTime submit_time) {
    this.submit_time = submit_time;
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