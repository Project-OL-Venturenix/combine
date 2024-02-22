package com.venturenix.cmc.payload.response;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class UserQuestionSubmitResponse {
  private String token;
  private String type = "Bearer";
  private Long id; 

  private Long eventid;


  private Long questionid;  


  private Long userid;  


  private Double run_time_by_msec;  

  private LocalDateTime submit_time;  

  private String status;
  
  private LocalDateTime createddate;

  
  private Integer createdby;

  
  private LocalDateTime updateddate;

  
  private Integer updatedby;
  
  
  public UserQuestionSubmitResponse(String accessToken, Long id, Long eventid, Long questionid, Long userid, Double run_time_by_msec, LocalDateTime submit_time, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.token = accessToken;
    this.id = id;
    this.eventid = eventid;
    this.questionid = questionid;
    this.userid = userid;
    this.run_time_by_msec = run_time_by_msec;
    this.submit_time = submit_time;
    this.status = status;
    this.createddate = createddate;
    this.createdby = createdby;
    this.updateddate = updateddate;
    this.updatedby = updatedby;
  
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
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

  public void setSubmittime(LocalDateTime submit_time) {
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
