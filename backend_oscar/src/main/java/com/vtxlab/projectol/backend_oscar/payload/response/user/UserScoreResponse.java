package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class UserScoreResponse {
  private String token;
  private String type = "Bearer";
  private Long id;

  private Long eventId;


  private Long userId;


  private Long questionId;


  private Integer testcasepassTotal;


  private Double testcasescoreTotal;


  private Integer testcaseTotal;

  private String status;

  private boolean isPass() {
    return this.testcasepassTotal == 10;
  };

  private LocalDateTime createdDate;


  private Integer createdBy;


  private LocalDateTime updatedDate;


  private Integer updatedBy;


  public UserScoreResponse(String accessToken, Long id, Long eventId,
      Long userId, Long questionId, Integer testcaseTotal,
      Integer testcasepassTotal, Double testcasescoreTotal,
      LocalDateTime createdDate, Integer createdBy, LocalDateTime updatedDate,
      Integer updatedBy) {
    this.token = accessToken;
    this.id = id;
    this.eventId = eventId;
    this.userId = userId;
    this.questionId = questionId;
    this.testcasepassTotal = testcasepassTotal;
    this.testcasescoreTotal = testcasescoreTotal;
    this.testcaseTotal = testcaseTotal;
    this.status = this.isPass() == true ? "Pass" : "Fail";
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

  public Long getUserId() {
    return userId;
  }

  public void setUserid(Long userId) {
    this.userId = userId;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionid(Long questionId) {
    this.questionId = questionId;
  }

  public Integer getTestcasetotal() {
    return testcaseTotal;
  }

  public void setTestcasetotal(Integer testcaseTotal) {
    this.testcaseTotal = testcaseTotal;
  }

  public Integer getTestcasepasstotal() {
    return testcasepassTotal;
  }

  public void setTestcasepasstotal(Integer testcasepassTotal) {
    this.testcasepassTotal = testcasepassTotal;
  }

  public Double getTestcasescoretotal() {
    return testcasescoreTotal;
  }

  public void setTestcasescoretotal(Double testcasescoreTotal) {
    this.testcasescoreTotal = testcasescoreTotal;
  }

  public String getStatus() {
    return this.isPass() == true ? "Pass" : "Fail";
  }

  public void setStatus(String status) {
    this.status = this.isPass() == true ? "Pass" : "Fail";
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
