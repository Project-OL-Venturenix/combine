package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class UserQuestionSubmitResponse {
  private String token;
  private String type = "Bearer";
  private Long id; 

  private Long eventId;


  private Long questionId;  


  private Long userId;  


  private Double runtimebyMsec;  

  private LocalDateTime submitTime;  

  private String status;
  
  private LocalDateTime createdDate;

  
  private Integer createdBy;

  
  private LocalDateTime updatedDate;

  
  private Integer updatedBy;
  
  
  public UserQuestionSubmitResponse(String accessToken, Long id, Long eventId, Long questionId, Long userId, Double runtimebyMsec, LocalDateTime submitTime, String status, LocalDateTime createdDate, Integer createdBy, LocalDateTime updatedDate, Integer updatedBy) {
    this.token = accessToken;
    this.id = id;
    this.eventId = eventId;
    this.questionId = questionId;
    this.userId = userId;
    this.runtimebyMsec = runtimebyMsec;
    this.submitTime = submitTime;
    this.status = status;
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.updatedDate = updatedDate;
    this.updatedBy = updatedBy;
  
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

    public Long getEventId() {
    return eventId;
  }

  public void setEventid(Long eventId) {
    this.eventId = eventId;
  }

   public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionid(Long questionId) {
    this.questionId = questionId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserid(Long userId) {
    this.userId = userId;
  }  

  public Double getRuntimebymsec() {
    return runtimebyMsec;
  }

  public void setRuntimebymsec(Double runtimebyMsec) {
    this.runtimebyMsec = runtimebyMsec;
  }  

  public LocalDateTime getSubmittime() {
    return submitTime;
  }

  public void setSubmittime(LocalDateTime submitTime) {
    this.submitTime = submitTime;
  }  

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

   public Integer getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getupdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }
}
