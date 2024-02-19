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

 
  private Long testcase_pass_total;

 
  private Double testcase_score_total;

 
  private Long testcase_total;          

  private String status;
  
  private LocalDateTime createddate;

  
  private Long createdby;

  
  private LocalDateTime updateddate;

  
  private Long updatedby;
  
  
  public UserScoreResponse(String accessToken, Long id, Long eventid, Long userid, Long questionid, Long testcase_total, Long testcase_pass_total, Double testcase_score_total, String status, LocalDateTime createddate, Long createdby, LocalDateTime updateddate, Long updatedby) {
    this.token = accessToken;
    this.id = id;
    this.eventid = eventid;
    this.userid = userid;
    this.questionid = questionid;
    this.testcase_pass_total = testcase_pass_total;
    this.testcase_score_total = testcase_score_total;
    this.testcase_total = testcase_total;
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
