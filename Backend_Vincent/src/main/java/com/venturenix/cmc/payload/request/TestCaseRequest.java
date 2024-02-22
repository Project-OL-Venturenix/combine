package com.venturenix.cmc.payload.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.Size;

public class TestCaseRequest {

  //@NotBlank
  private Long questionid;

  //@NotBlank
  private Long testcasescoreid;

  //@NotBlank
  private String testcaseresult;

  //@NotBlank
  private String testcasetext;

  //@NotBlank
  private String status;

  
  private LocalDateTime createddate;

  
  private Integer createdby;

  
  private LocalDateTime updateddate;

  
  private Integer updatedby;

  public Long getQuestionid() {
    return questionid;
  }

  public void setGroupid(Long questionid) {
    this.questionid = questionid;
  }

  public Long getTestcasescoreid() {
    return testcasescoreid;
  }

  public void setTestcasescoreid(Long testcasescoreid) {
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