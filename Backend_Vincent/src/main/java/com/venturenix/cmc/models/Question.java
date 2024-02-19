package com.venturenix.cmc.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String questiontext;
  private String answertext;
  private String status;
  private LocalDateTime createddate;
  private Long createdby;
  private LocalDateTime updateddate;
  private Long updatedby;

  public Question(String questiontext, String answertext, String status,
      LocalDateTime createddate, Long createdby, LocalDateTime updateddate,
      Long updatedby) {
    this.questiontext = questiontext;
    this.answertext = answertext;
    this.status = status;
    this.createddate = createddate;
    this.createdby = createdby;
    this.updateddate = updateddate;
    this.updatedby = updatedby;

  }

  public Question(String questiontext) {
    this.questiontext = questiontext;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQuestiontext() {
    return questiontext;
  }

  public void setQuestiontext(String questiontext) {
    this.questiontext = questiontext;
  }

  public String getAnswertext() {
    return answertext;
  }

  public void setAnswertext(String answertext) {
    this.answertext = answertext;
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

  public void setCreatedBy(Long createdby) {
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
