package com.venturenix.cmc.payload.response;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class UserScoreResponse {
  private String token;
  private String type = "Bearer";
  private Long id;

  private Long eventid;


  private Long userid;


  private Long questionid;


  private Integer testcasepasstotal;


  private Double testcasescoretotal;


  private Integer testcasetotal;

  private String status;

  private boolean isPass() {
    return this.testcasepasstotal == 10;
  };

  private LocalDateTime createddate;


  private Integer createdby;


  private LocalDateTime updateddate;


  private Integer updatedby;


  public UserScoreResponse(String accessToken, Long id, Long eventid,
      Long userid, Long questionid, Integer testcasetotal,
      Integer testcasepasstotal, Double testcasescoretotal,
      LocalDateTime createddate, Integer createdby, LocalDateTime updateddate,
      Integer updatedby) {
    this.token = accessToken;
    this.id = id;
    this.eventid = eventid;
    this.userid = userid;
    this.questionid = questionid;
    this.testcasepasstotal = testcasepasstotal;
    this.testcasescoretotal = testcasescoretotal;
    this.testcasetotal = testcasetotal;
    this.status = this.isPass() == true ? "Pass" : "Fail";
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
    return this.isPass() == true ? "Pass" : "Fail";
  }

  public void setStatus(String status) {
    this.status = this.isPass() == true ? "Pass" : "Fail";
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
