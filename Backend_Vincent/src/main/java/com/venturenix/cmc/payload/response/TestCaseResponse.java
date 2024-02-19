package com.venturenix.cmc.payload.response;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TestCaseResponse {
  private String token;
  private String type = "Bearer";
  private Long id; 
  
  private Integer questionid;

  
  private Integer testcasescoreid;

  
  private String testcaseresult;

  
  private String testcasetext;
  private String status;
  
  private LocalDateTime createddate;

  
  private Integer createdby;

  
  private LocalDateTime updateddate;

  
  private Integer updatedby;
  
  
  public TestCaseResponse(String accessToken, Long id, Integer questionid, Integer testcasescoreid, String testcasetext, String testcaseresult,  String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.token = accessToken;
    this.id = id;
    this.questionid = questionid;
    this.testcasescoreid = testcasescoreid;
    this.testcasetext = testcasetext;
    this.testcaseresult = testcaseresult;
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

  public Integer getQuestionid() {
    return questionid;
  }

  public void setGroupid(Integer questionid) {
    this.questionid = questionid;
  }

  public Integer getTestcasescoreid() {
    return testcasescoreid;
  }

  public void setTestcasescoreid(Integer testcasescoreid) {
    this.testcasescoreid = testcasescoreid;
  }

  public String getTestcaseresult() {
    return testcaseresult;
  }

  public void setTestresult(String testcaseresult) {
    this.testcaseresult = testcaseresult;
  }  

  public String getTestcasetext() {
    return testcasetext;
  }

  public void setTestcasetext(String testcasetext) {
    this.testcasetext = testcasetext;
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
