package com.venturenix.cmc.entity;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userscores")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long eventid;
  private Long userid;
  private Long questionid;
  @JsonProperty("testcasepasstotal")
  private Integer testcasePassTotal;
  @JsonProperty("testcasescoretotal")
  private Double testcaseScoreTotal;
  private String status;
  private LocalDateTime createddate;
  private Integer createdby;
  private LocalDateTime updateddate;
  private Integer updatedby;



  public UserScore(Long eventid, Long userid, Long questionid,
      Integer testcasetotal, Integer testcasePassTotal,
      Double testcaseScoreTotal, String status, LocalDateTime createddate,
      Integer createdby, LocalDateTime updateddate, Integer updatedby) {
    this.eventid = eventid;
    this.userid = userid;
    this.questionid = questionid;
    this.testcasePassTotal = testcasePassTotal;
    this.testcaseScoreTotal = testcaseScoreTotal;
    this.status = status;
    this.createddate = createddate;
    this.createdby = createdby;
    this.updateddate = updateddate;
    this.updatedby = updatedby;

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

  public Integer getTestCasePasstotal() {
    return testcasePassTotal;
  }

  public void setTestcasepasstotal(Integer testcasePassTotal) {
    this.testcasePassTotal = testcasePassTotal;
  }

  public Double getTestcasescoretotal() {
    return testcaseScoreTotal;
  }

  public void setTestcasescoretotal(Double testcaseScoreTotal) {
    this.testcaseScoreTotal = testcaseScoreTotal;
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
