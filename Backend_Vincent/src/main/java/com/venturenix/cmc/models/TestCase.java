package com.venturenix.cmc.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "testcases")
public class TestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long questionid;
  private Long testcasescoreid;
  private String testcasetext;
  private String testcaseresult;
  private String status;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby;  

  public TestCase(Long questionid, Long testcasescoreid, String testcasetext, String testcaseresult, String status, LocalDateTime createddate, Long createdby, LocalDateTime updateddate, Long updatedby) {
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

  public TestCase(String testcasetext) {
    this.testcasetext = testcasetext;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Long questionid) {
    this.questionid = questionid;
  }  

  public String getTestcasetext() {
    return testcasetext;
  }

  public void setTestcasetext(String testcasetext) {
    this.testcasetext = testcasetext;
  }

  public String getTestcaseresult() {
    return testcaseresult;
  }

  public void setTestcaseresult(String testcaseresult) {
    this.testcaseresult = testcaseresult;
  }

  public Long getTestcasescoreid() {
    return testcasescoreid;
  }

  public void setTestcasescoreid(Long testcasescoreid) {
    this.testcasescoreid = testcasescoreid;
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