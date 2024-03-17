package com.vtxlab.projectol.backend_oscar.payload.response.user;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  private String mobile;
  private String company;
  private String title;
  private Integer py_experience;
  private Integer jv_experience;
  private Integer js_experience;
  private Integer cs_experience;
  private Integer sa_experience;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy; 
  private String status;

  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String firstName, String lastName, String mobile, String email, String userName, String company, String title, Integer py_experience, Integer jv_experience, Integer js_experience, Integer cs_experience, Integer sa_experience, String status, LocalDateTime createdate, Integer createby, LocalDateTime updatedate, Integer updateby, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;    
    this.mobile = mobile;
    this.email = email;
    this.userName = userName;
    this.company = company;
    this.title = title;
    this.py_experience = py_experience;
    this.jv_experience = jv_experience;
    this.js_experience = js_experience;
    this.cs_experience = cs_experience;
    this.sa_experience = sa_experience;
    this.status = status;
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.updatedDate = updatedDate;
    this.updatedBy = updatedBy;
    this.roles = roles;
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

  public String getFirstname() {
    return firstName;
  }

  public void setFirstname(String firstName) {
    this.firstName = firstName;
  }

  public String getLastname() {
    return lastName;
  }

  public void setLastname(String lastName) {
    this.lastName = lastName;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return userName;
  }

  public void setUsername(String userName) {
    this.userName = userName;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getPy_experience() {
    return py_experience;
  }

  public void setPy_experience(Integer py_experience) {
    this.py_experience = py_experience;
  }

  public Integer getJv_experience() {
    return jv_experience;
  }

  public void setJv_experience(Integer jv_experience) {
    this.jv_experience = jv_experience;
  }
  
  public Integer getJs_experience() {
    return js_experience;
  }

  public void setJs_experience(Integer js_experience) {
    this.js_experience = js_experience;
  }
  
  public Integer getCs_experience() {
    return cs_experience;
  }

  public void setCs_experience(Integer cs_experience) {
    this.cs_experience = cs_experience;
  }
  
  public Integer getSa_experience() {
    return sa_experience;
  }

  public void setSa_experience(Integer sa_experience) {
    this.sa_experience = sa_experience;
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


  public List<String> getRoles() {
    return roles;
  }
}
