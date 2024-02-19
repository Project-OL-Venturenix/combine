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
  private Integer id;
  private Integer questionid;
  private Integer testcasescoreid;
  private String testcasetext;
  private String testcaseresult;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;  

  public TestCase(Integer questionid, Integer testcasescoreid, String testcasetext, String testcaseresult, String status, LocalDateTime createddate, Integer createdby, LocalDateTime updateddate, Integer updatedby) {
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Integer questionid) {
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

  public Integer getTestcasescoreid() {
    return testcasescoreid;
  }

  public void setTestcasescoreid(Integer testcasescoreid) {
    this.testcasescoreid = testcasescoreid;
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